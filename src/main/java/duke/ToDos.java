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
     */
    @Override
    public String fullDesc() {
        return "      " + this.taskType +
                this.getStatusIcon() + " " + this.description;
    }

    /**
     * Returns a string of the details of a todo inputted by user
     * @return String description
     */
    @Override
    public String stringDesc() {
        return this.taskType +
                this.getStatusIcon() + " " + this.description;
    }

    @Override
    public String textDesc() {
        return "T : " + this.getStatusIcon() + " : " + this.description + "\n";
    }
}
