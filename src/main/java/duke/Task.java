package duke;

/**
 * Represents a task given by user. A Task object corresponds to a single task
 * inputted by the user, represented by a description and a status.
 */
public class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Returns status icon of task object.
     * [X] is returned if task is done, else [ ] is returned.
     * @return String status.
     */
    public String getStatusIcon() {
        return (isDone ? "[X]" : "[ ]"); //mark done task with x
    }

    /**
     * Marks task object as done.
     */
    public void markAsDone() {
        this.isDone = true;
    }

    /**
     * Marks task object as undone.
     */
    public void markAsUndone() {
        this.isDone = false;
    }

    /**
     * Prints description of task object.
     */
    public void fullDesc() {
        System.out.println("      " + this.getStatusIcon() + " " + this.description);
    }

    /**
     * Returns string description of task object.
     * @return String description.
     */
    public String stringDesc() {
        return this.getStatusIcon() + " " + this.description;
    }

    /**
     * Returns string of task inputted.
     * @return String task.
     */
    public String textDesc() {
        return this.description;
    }
}
