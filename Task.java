public class Task {

    public String description;
    private boolean marked;

    public Task(String description) {
        this.description = description;
        this.marked = false;
    }
    public void markDone() {
        this.marked = true;
    }
    public void unmarkDone() {
        this.marked = false;
    }
    @Override
    public String toString() {
        return (this.marked ? "[X] " : "[ ] ") + description;
    }

}