package faith.logic.command;

import faith.io.Storage;
import faith.io.Ui;
import faith.model.TaskList;

public class ExitCommand extends Command {

    public boolean isExit() {
        return true;
    }
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.showGoodbye();
    }
}
