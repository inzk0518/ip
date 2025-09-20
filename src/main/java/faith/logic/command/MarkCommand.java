package faith.logic.command;

import faith.exception.FaithException;
import faith.io.Storage;
import faith.io.Ui;
import faith.model.TaskList;
import faith.model.task.Task;


public class MarkCommand extends Command {
    private int idx;
    public MarkCommand(int idx) {
        this.idx = idx;
    }
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws FaithException {
        Task targetTask = tasks.get(idx - 1);
        targetTask.markDone();
        ui.show("     Nice! I've marked this task as done:");
        ui.show("       " + targetTask);
        storage.save(tasks);
    }
}