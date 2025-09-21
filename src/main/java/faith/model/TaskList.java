package faith.model;

import faith.model.task.Task;
import java.util.ArrayList;
import java.util.List;

public class TaskList {

    private final ArrayList<Task> taskList;

    /**
     * Returns a new empty task list
     */
    public TaskList() {
        this.taskList = new ArrayList<>();
    }

    /**
     * Constructs a task list from given list
     *
     * @param initial returns a task list constructed with given list
     */
    public TaskList(List<Task> initial) {
        this.taskList = new ArrayList<>(initial);
    }

    /**
     * Returns the number of tasks in the list
     *
     * @return the number of tasks in the list.
     */
    public int size() {
        return taskList.size();
    }

    /**
     * Returns the task at the specified position in this list
     * @param index index of the task to return
     * @return the task at the specified position in this list
     */
    public Task get(int index) {
        return taskList.get(index);
    }

    /**
     * Appends the specified task to the end of this list
     * @param t task to be appended to this list
     */
    public void add(Task t) {
        taskList.add(t);
    }

    /**
     * Removes the task at the specified position in this list. Shifts any subsequent tasks to the left (subtracts one from their indices).
     *
     * @param index the index of the task to be removed
     * @return the task that was removed from the list
     */
    public Task remove(int index) {
        return taskList.remove(index);
    }

    /**
     * return task list
     *
     * @return task list
     */
    public List<Task> asList() {
        return taskList;
    }
}