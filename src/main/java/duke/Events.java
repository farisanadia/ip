package duke;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;

/**
 * Represents a type of task that can be called by user. An Events object corresponds to
 * an event to be attended by the user.
 */
public class Events extends Task {
    protected String taskType = "[E]";
    protected String duration;

    public Events(String description, String d) {
        super(description);
        if (!d.contains("at ")) {
            this.duration = d;
        } else {
            String[] split = d.split("at ");
            try {
                this.duration = LocalDate.parse(split[1], parserFormats).
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
     * Prints the full description of the event inputted by user.
     */
    @Override
    public String getFullDesc() {
        return "      " + this.taskType + this.getStatusIcon() +
                " " + this.description + " (" + this.duration + ")";
    }

    /**
     * Returns a string of the details of an event inputted by user
     * @return String description
     */
    @Override
    public String getStringDesc() {
        return this.taskType + this.getStatusIcon() +
                " " + this.description + " (" + this.duration + ")";
    }

    @Override
    public String getTextDesc() {
        return "E : " + this.getStatusIcon() + " : " +
                this.description + " : " + this.duration + "\n" ;
    }
}