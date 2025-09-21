package faith;

import faith.exception.*;
import faith.io.Storage;
import faith.io.Ui;
import faith.logic.Parser;
import faith.logic.command.Command;
import faith.model.TaskList;

/**
 * Entry point of the Faith application.
 * Wires together UI, storage, task list, and the command loop.
 */
public class Faith {
    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    /**
     * Creates a new Faith instance and attempts to load tasks from the given file path.
     *
     * @param filePath path to the storage tasks file (e.g., "data/tasks.txt").
     */
    public Faith(String filePath) {
        this.ui = new Ui();
        this.storage = new Storage(filePath);
        try {
            tasks = new TaskList(storage.load());
        } catch (FaithException e) {
            ui.showLoadingError();
            tasks = new TaskList();
        }
    }

    /**
     * Runs the main event loop:
     * reads commands, executes them, handles errors, and decides when to exit.
     */
    public void run() {
        ui.showWelcome();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                ui.showLine(); // show the divider line ("_______")
                Command c = Parser.parse(fullCommand);
                c.execute(tasks, ui, storage);
                isExit = c.isExit();
            } catch (FaithException e) {
                ui.showError(e.getMessage());
            } finally {
                ui.showLine();
            }
        }
    }

    /**
     * Launches the application.
     *
     * @param args command line arguments (unused).
     */
    public static void main (String[] args) {
        new Faith("data/tasks.txt").run();
    }

}

