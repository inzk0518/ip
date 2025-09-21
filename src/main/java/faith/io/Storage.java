package faith.io;

import faith.exception.FaithException;
import faith.logic.Parser;
import faith.model.TaskList;
import faith.model.task.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Store tasks to disk and loads them back on startup.
 * Storage format is string text, one task per line.
 */
public class Storage {

    private final String filePath;

    /**
     * Creates a storage with the given file path.
     *
     * @param filePath path to the tasks file.
     */
    public Storage(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Loads tasks from disk. Creates the file if missing.
     *
     * @return a list of tasks loaded from storage.
     * @throws FaithException if the file cannot be read or parsed.
     */
    public List<Task> load() throws FaithException {
        TaskList taskList = new TaskList();
        File file = new File(filePath);

        if (!file.exists()) {
            return taskList.asList();
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))){
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length < 3) {
                    continue;
                }
                String taskType = parts[0].trim();
                String description = parts[2].trim();
                if (taskType.equals("T")) {
                    Task task = new Todo(description);
                    taskList.add(task);
                    if (parts[1].trim().equals("1")) {
                        task.markDone();
                    }
                }
                if (taskType.equals("D")) {
                    if (parts.length < 4) {
                        continue;
                    }
                    Task task = new Deadline(description, parts[3].trim());
                    taskList.add(task);
                    if (parts[1].trim().equals("1")) {
                        task.markDone();
                    }
                }
                if (taskType.equals("E")) {
                    if (parts.length < 4) {
                        continue;
                    }
                    String[] timeParts = parts[3].trim().split("-");
                    if (timeParts.length != 2) {
                        continue;
                    }
                    Task task = new Event(description, timeParts[0].trim(), timeParts[1].trim());
                    taskList.add(task);
                    if (parts[1].trim().equals("1")) {
                        task.markDone();
                    }
                }

            }
        } catch (IOException e) {
            throw new FaithException();
        }
        return taskList.asList();
    }

    /**
     * Saves the task list to disk, overwriting the file.
     *
     * @param tasks the task list to store.
     * @throws FaithException if writing fails.
     */
    public void save(TaskList tasks) throws FaithException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (Task t : tasks.asList()) {
                bw.write(t.saveToFileFormat());
                bw.newLine();
            }
        } catch (IOException e) {
            throw new FaithException();
        }
    }
}