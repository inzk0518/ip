package faith.logic.command;

import faith.exception.FaithException;
import faith.io.Storage;
import faith.io.Ui;
import faith.model.TaskList;
import faith.model.task.Deadline;
import faith.model.task.Event;
import faith.model.task.Task;

public class EditCommand extends Command {
    public enum Field { DESC, BY, FROM, TO }

    private final int index; // 0-based
    private final Field field;
    private final String value;

    public EditCommand(int index, Field field, String value) {
        this.index = index;
        this.field = field;
        this.value = value;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws FaithException {
        if (index < 0 || index >= tasks.size()) {
            throw new FaithException("Index out of range.");
        }
        Task t = tasks.get(index);
        String before = t.toString();

        switch (field) {
        case DESC:
            t.setDescription(value);
            break;
        case BY:
            if (t instanceof Deadline) {
                ((Deadline) t).setBy(value);
            } else {
                throw new FaithException("Field '/by' applies only to deadlines.");
            }
            break;
        case FROM:
            if (t instanceof Event) {
                ((Event) t).setFrom(value);
            } else {
                throw new FaithException("Field '/from' applies only to events.");
            }
            break;
        case TO:
            if (t instanceof Event) {
                ((Event) t).setTo(value);
            } else {
                throw new FaithException("Field '/to' applies only to events.");
            }
            break;
        default:
            throw new FaithException("Unknown field.");
        }

        storage.save(tasks);
        ui.show("Edited task:\n  before: " + before + "\n  after:  " + t);
    }
}