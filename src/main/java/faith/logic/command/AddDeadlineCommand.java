package faith.logic.command;

import faith.exception.FaithException;
import faith.io.Storage;
import faith.io.Ui;
import faith.model.TaskList;
import faith.model.task.Deadline;

public class AddDeadlineCommand extends Command {
    private final String desc;
    private final String by;
    public AddDeadlineCommand(String desc, String by) {
        this.desc = desc;
        this.by = by;
    }
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