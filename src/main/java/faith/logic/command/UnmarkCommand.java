package faith.logic.command;

import faith.exception.FaithException;
import faith.io.Storage;
import faith.io.Ui;
import faith.model.TaskList;
import faith.model.task.Task;
/**
 * Marks a task as not done by its displaying index.
 */
public class UnmarkCommand extends Command {
    private int idx;

    /**
     * Creates a command to mark a task as not done with the given displaying index.
     */
    public UnmarkCommand(int idx) {
        this.idx = idx;
    }

    /**
     * Executes: marks the task as not done, shows feedback, and saves the change.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws FaithException{
        Task targetTask = tasks.get(idx - 1);
        targetTask.unmarkDone();
        ui.show("     OK, I've marked this task as not done yet:");
        ui.show("       " + targetTask);
        storage.save(tasks);
    }
}