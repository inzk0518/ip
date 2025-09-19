package faith.logic.command;

import faith.exception.FaithException;
import faith.io.Storage;
import faith.io.Ui;
import faith.model.TaskList;
import faith.model.task.Todo;

public class AddTodoCommand extends Command {
    private String desc;
    public AddTodoCommand(String desc) {
        this.desc = desc;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws FaithException {
        Todo t = new Todo(desc);
        tasks.add(t);
        ui.show("     Got it. I've added this task:");
        ui.show("       " + t.toString());
        ui.show("     Now you have " + tasks.size() + " tasks in the list.");
        storage.save(tasks);
    }
}