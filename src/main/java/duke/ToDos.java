package duke;

/**
 * Represents a type of task that can be called by user. A ToDos object corresponds to
 * a todo to be completed by the user.
 */
public class ToDos extends Task {
    protected String taskType = "[T]";

    public ToDos(String description) {
        super(description);
    }

    /**
     * Prints the full description of the todo inputted by user.
     * @return String description.
     */
    @Override
    public String getFullDesc() {
        return "      " + this.taskType +
                this.getStatusIcon() + " " + this.description;
    }

    /**
     * Returns a string of the details of a todo inputted by user
     * @return String description.
     */
    @Override
    public String getStringDesc() {
        return this.taskType +
                this.getStatusIcon() + " " + this.description;
    }

    @Override
    public String getTextDesc() {
        return "T : " + this.getStatusIcon() + " : " + this.description + "\n";
    }

    @Override
    public String checkSchedule() {
        return "";
    }
}
