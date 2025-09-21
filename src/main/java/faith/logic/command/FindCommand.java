package faith.logic.command;

import faith.io.Storage;
import faith.io.Ui;
import faith.model.TaskList;
import faith.model.task.Task;

public class FindCommand extends Command {
    private String keyword;

    public FindCommand(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        TaskList findList = new TaskList();
        for (int i = 0; i < tasks.size(); i++) {
            Task currentTask = tasks.get(i);
            if (currentTask.getDescription().toLowerCase().contains(keyword.toLowerCase())) {
                findList.add(currentTask);
            }
        }
        ui.show("     Here are the matching tasks in your list:");
        for (int i = 0; i < findList.size(); i++) {
            ui.show("     " + (i + 1) + "." + findList.get(i));
        }
    }
}