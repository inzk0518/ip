package faith.logic.command;

import faith.exception.FaithException;
import faith.io.Storage;
import faith.io.Ui;
import faith.model.TaskList;
import faith.model.task.Deadline;

/**
 * Adds a new {@code Deadline} task with a due date/time string.
 * The {@code Deadline} class is responsible for parsing the date/time.
 */
public class AddDeadlineCommand extends Command {
    private final String desc;
    private final String by;

    /**
     * Creates a command to add a Deadline task with the given description.
     * @param desc non-empty task description.
     * @param by deadline datetime of task (e.g., 20/9/2025 1600).
     */
    public AddDeadlineCommand(String desc, String by) {
        this.desc = desc;
        this.by = by;
    }

    /**
     * Executes: adds the deadline task, shows feedback, and saves.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws FaithException {
        Deadline t = new Deadline(desc, by);
        tasks.add(t);
        ui.show("     Got it. I've added this task:");
        ui.show("       " + t.toString());
        ui.show("     Now you have " + tasks.size() + " tasks in the list.");
        storage.save(tasks);
    }
}