package faith.logic.command;

import faith.io.Ui;
import faith.io.Storage;
import faith.model.TaskList;

public class ListCommand extends Command {
    public ListCommand() {}
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.show("     Here are the tasks in your list:");
        for (int i = 0; i < tasks.size(); i++) {
            ui.show("     " + (i + 1) + "." + tasks.get(i));
        }
    }
}