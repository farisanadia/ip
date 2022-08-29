package duke;

import java.io.IOException;
import java.util.ArrayList;

public class TaskList {
    protected ArrayList<Task> tasks;
    protected Storage storage; //to update duke.txt

    public TaskList(ArrayList<Task> tasks, Storage storage) {
        this.tasks = tasks;
        this.storage = storage;
    }

    /**
     * Adds given Task to array list of tasks.
     * Updates storage to include new task given.
     * @param t Task to be added to task list.
     * @throws IOException
     */
    public void addTask(Task t) throws IOException {
        tasks.add(t);
        this.storage.appendToFile(t.textDesc());
    }

    /**
     * Removes specified task from array list of tasks.
     * @param i Index of task to be removed from list.
     * @throws IOException
     */
    public void removeTask(int i) throws IOException {
        tasks.remove(i);
        this.storage.modifyFile(tasks);
    }

    /**
     * Marks specified task in array list of tasks as done.
     * @param pos Position of task to be marked as done.
     * @throws IOException
     */
    public void markTask(int pos) throws IOException {
        tasks.get(pos).markAsDone();
        this.storage.modifyFile(tasks);
    }

    /**
     * Marks specified task in array list of tasks as undone.
     * @param pos Position of task to be marked as undone.
     * @throws IOException
     */
    public void unmarkTask(int pos) throws IOException {
        tasks.get(pos).markAsUndone();
        this.storage.modifyFile(tasks);
    }

    /**
     * Prints string description of task at specified index.
     * @param pos Index of task to be printed.
     */
    public void taskToString(int pos) {
        tasks.get(pos).fullDesc();
    }

    /**
     * Returns string of all task descriptions in array list of tasks.
     * @return String description.
     */
    public String toString() {
        String fullString = "";
        for (int i = 0; i < tasks.size(); i++) {
            fullString += String.valueOf(i + 1) + ". "
                    + tasks.get(i).stringDesc() + "\n";
        }
        return fullString;
    }

    /**
     * Returns number of tasks in current array list of tasks.
     * @return int size of task list.
     */
    public int getSize() {
        return this.tasks.size();
    }
}
