package duke;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;

/**
 * Represents a type of task that can be called by user. A Deadlines object corresponds to
 * a deadline to be met by the user.
 */
public class Deadlines extends Task {
    protected String taskType = "[D]";
    protected String deadline;

    public Deadlines(String description, String d) {
        super(description);
        if (!d.contains("by ")) {
            this.deadline = d;
        } else {
            String[] split = d.split("by ");
            try {
                this.deadline = LocalDate.parse(split[1], parserFormats).
                        format(DateTimeFormatter.ofPattern("MMM d yyyy"));
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Oops! Your deadline should have a due date after /deadline");
            } catch (DateTimeParseException e) {
                System.out.println("Please enter a valid date!");
            }
        }
    }

    protected static DateTimeFormatter parserFormats = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_LOCAL_DATE)
            .appendOptional(DateTimeFormatter.ofPattern("d MMM uuuu"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyyMMdd"))
            .toFormatter();

    /**
     * Prints the full description of the deadline inputted by user.
     * @return description.
     */
    @Override
    public String getFullDesc() {
        return "      " + this.taskType + this.getStatusIcon() +
                " " + this.description + " (" + this.deadline + ")";
    }

    /**
     * Returns a string of the details of a deadline inputted by user
     * @return String description
     */
    @Override
    public String getStringDesc() {
        return this.taskType + this.getStatusIcon() +
                " " + this.description + " (" + this.deadline + ")";
    }

    @Override
    public String getTextDesc() {
        return "D : " + this.getStatusIcon() + " : " +
                this.description + " : " + this.deadline + "\n";
    }

    /**
     * Returns string of schedule of task.
     * @return String deadline.
     */
    @Override
    public String checkSchedule() {
        return this.deadline;
    }
}
