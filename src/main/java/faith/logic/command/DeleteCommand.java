package faith.logic.command;

import faith.exception.FaithException;
import faith.io.Storage;
import faith.io.Ui;
import faith.model.TaskList;

/**
 * Deletes a task from the list by index.
 */
public class DeleteCommand extends Command {

    private final int idx;

    /**
     * Constructs a deletion command for the given 1-based index.
     *
     * @param idx position of the task on the UI to remove.
     */
    public DeleteCommand(int idx) {
        this.idx = idx;
    }

    /**
     * Executes: removes the task, shows feedback, and saves the new list.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws FaithException {
        ui.show("     Noted. I've removed this task:");
        ui.show("       " + tasks.remove(this.idx - 1).toString());
        ui.show("     Now you have " + tasks.size() + " tasks in the list.");
        storage.save(tasks);
    }
}
