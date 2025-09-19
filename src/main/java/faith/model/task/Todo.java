package faith.model.task;

public class Todo extends Task {

    public Todo(String description) {
        super(description);
    }

    @Override
    public String saveToFileFormat() {
        return "T | " + this.isDoneInt() + " | " + description;
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}