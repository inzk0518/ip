package faith.logic.command;

import faith.io.Storage;
import faith.io.Ui;
import faith.model.TaskList;

/**
 * Print the task list in their natural order.
 */
public class ListCommand extends Command {

    /**
     * Executes: prints either an empty message or a numbered list of tasks.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.show("     Here are the tasks in your list:");
        for (int i = 0; i < tasks.size(); i++) {
            ui.show("     " + (i + 1) + "." + tasks.get(i));
        }
    }
}