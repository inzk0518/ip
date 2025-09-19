package faith.logic.command;

import faith.exception.FaithException;
import faith.io.Storage;
import faith.io.Ui;
import faith.model.TaskList;


public abstract class Command {

    public abstract void execute(TaskList tasks, Ui ui, Storage storage) throws FaithException;

    public boolean isExit() {
        return false;
    }
}