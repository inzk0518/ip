package faith.model;

import faith.model.task.Task;
import java.util.ArrayList;
import java.util.List;

public class TaskList {
    private final ArrayList<Task> taskList;

    public TaskList() {
        this.taskList = new ArrayList<>();
    }

    public TaskList(List<Task> initial) {
        this.taskList = new ArrayList<>(initial);
    }

    public int size() {
        return taskList.size();
    }

    public Task get(int index) {
        return taskList.get(index);
    }

    public void add(Task t) {
        taskList.add(t);
    }

    public Task remove(int index) {
        return taskList.remove(index);
    }

    public List<Task> asList() {
        return taskList;
    }
}