package faith.logic.command;

import faith.io.Storage;
import faith.io.Ui;
import faith.model.TaskList;

/**
 * Tell the application to exit after showing a goodbye message.
 */
public class ExitCommand extends Command {

    /**
     *
     * @return always true because this is an exit command
     */
    public boolean isExit() {
        return true;
    }

    /**
     * Executes: prints the goodbye message
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.showGoodbye();
    }
}
