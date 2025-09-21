package faith.logic.command;

import faith.exception.FaithException;
import faith.io.Storage;
import faith.io.Ui;
import faith.model.TaskList;

/**
 * Base class for all user commands such as marking, deleting, or exiting.
 */
public abstract class Command {

    /**
     * Executes the command against the given collaborators.
     *
     * @param tasks   task list.
     * @param ui      the UI to show messages to the user.
     * @param storage the storage used to store task list.
     * @throws FaithException error during execution.
     */
    public abstract void execute(TaskList tasks, Ui ui, Storage storage) throws FaithException;

    /**
     *
     * @return true if it is an exit command, false otherwise.
     */
    public boolean isExit() {
        return false;
    }
}