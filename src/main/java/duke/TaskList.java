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

    public void addTask(Task t) throws IOException {
        tasks.add(t);
        this.storage.appendToFile(t.textDesc());
    }

    public void removeTask(int i) throws IOException {
        tasks.remove(i);
        this.storage.modifyFile(tasks);
    }

    public void markTask(int pos) throws IOException {
        tasks.get(pos).markAsDone();
        this.storage.modifyFile(tasks);
    }

    public void unmarkTask(int pos) throws IOException {
        tasks.get(pos).markAsUndone();
        this.storage.modifyFile(tasks);
    }

    public void taskToString(int pos) {
        tasks.get(pos).fullDesc();
    }

    public String toString() {
        String fullString = "";
        for (int i = 0; i < tasks.size(); i++) {
            fullString += String.valueOf(i + 1) + ". "
                    + tasks.get(i).stringDesc() + "\n";
        }
        return fullString;
    }

    public int getSize() {
        return this.tasks.size();
    }

    public String findTask(String s) {
        String fullString = "";
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).textDesc().contains(s)) {
                fullString += String.valueOf(i + 1) + ". "
                        + tasks.get(i).stringDesc() + "\n";
            }
        }
        return fullString;
    }
}
