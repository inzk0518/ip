package faith.logic.command;

import faith.exception.FaithException;
import faith.io.Storage;
import faith.io.Ui;
import faith.model.TaskList;
import faith.model.task.Task;

public class UnmarkCommand extends Command {
    private int idx;
    public UnmarkCommand(int idx) {
        this.idx = idx;
    }
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws FaithException{
        Task targetTask = tasks.get(idx - 1);
        targetTask.unmarkDone();
        ui.show("     OK, I've marked this task as not done yet:");
        ui.show("       " + targetTask);
        storage.save(tasks);
    }
}