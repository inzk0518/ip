package faith.logic.command;

import faith.exception.FaithException;
import faith.io.Storage;
import faith.io.Ui;
import faith.model.TaskList;
import faith.model.task.Task;

/**
 * Mark a task as done by its displaying index.
 */
public class MarkCommand extends Command {

    private int idx;

    /**
     * Creates a command to mark a task as done with the given displaying index.
     */
    public MarkCommand(int idx) {
        this.idx = idx;
    }

    /**
     * Executes: marks the task as done, shows feedback, and saves the change.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws FaithException {
        Task targetTask = tasks.get(idx - 1);
        targetTask.markDone();
        ui.show("     Nice! I've marked this task as done:");
        ui.show("       " + targetTask);
        storage.save(tasks);
    }
}