package faith.logic.command;

import faith.exception.FaithException;
import faith.io.Storage;
import faith.io.Ui;
import faith.model.TaskList;
import faith.model.task.Event;

public class AddEventCommand extends Command {
    private final String desc;
    private final String from;
    private final String to;
    public AddEventCommand(String desc, String from, String to) {
        this.desc = desc;
        this.from = from;
        this.to = to;
    }
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws FaithException {
        Event e = new Event(desc, from, to);
        tasks.add(e);
        ui.show("     Got it. I've added this task:");
        ui.show("       " + e.toString());
        ui.show("     Now you have " + tasks.size() + " tasks in the list.");
        storage.save(tasks);
    }
}