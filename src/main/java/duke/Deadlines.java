package duke;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.util.Date;

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

    @Override
    public void fullDesc() {
        System.out.println("      " + this.taskType + this.getStatusIcon() +
                " " + this.description + " (" + this.deadline + ")");
    }

    @Override
    public String stringDesc() {
        return this.taskType + this.getStatusIcon() +
                " " + this.description + " (" + this.deadline + ")";
    }

    @Override
    public String textDesc() {
        return "D : " + this.getStatusIcon() + " : " +
                this.description + " : " + this.deadline + "\n";
    }
}
