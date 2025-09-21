package faith.model.task;

public class Task {

    public String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getDescription() {
        return this.description;
    }

    public void markDone() {
        this.isDone = true;
    }
    public void unmarkDone() {
        this.isDone = false;
    }

    public int isDoneInt() {
        return this.isDone ? 1 : 0;
    }

    public String saveToFileFormat() {
        return "";
    }

    @Override
    public String toString() {
        return (this.isDone ? "[X] " : "[ ] ") + this.description;
    }

}