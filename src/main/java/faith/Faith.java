package faith;

import faith.exception.*;
import faith.io.Storage;
import faith.io.Ui;
import faith.logic.Parser;
import faith.logic.command.Command;
import faith.model.TaskList;


public class Faith {
    private static final String FILE_PATH = "./data/tasks.txt";
    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    public Faith(String filePath) {
        this.ui = new Ui();
        this.storage = new Storage(filePath);
        try {
            tasks = new TaskList(storage.load());
        } catch (FaithException e) {
            ui.showLoadingError();
            tasks = new TaskList();
        }
    }

    public void run() {
        ui.showWelcome();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                ui.showLine(); // show the divider line ("_______")
                Command c = Parser.parse(fullCommand);
                c.execute(tasks, ui, storage);
                isExit = c.isExit();
            } catch (FaithException e) {
                ui.showError(e.getMessage());
            } finally {
                ui.showLine();
            }
        }
    }

    public static void main (String[] args) {
        new Faith("data/tasks.txt").run();
    }

    private void save() {
        try {
            storage.save(tasks);
        } catch (FaithException e) {
            ui.showError("     OOPS!!! There is an error saving tasks.");
        }
    }
}

