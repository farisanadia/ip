package duke;

public class Ui {

    public void printBuffLine() {
        System.out.println("    _____________________________________");
    }

    public void printString(String msg) {
        printBuffLine();
        System.out.println(msg);
    }

    public String printInvalidIndexError() {
        return "☹ OOPS!!! I'm sorry, but I don't know what that means.";
    }

    public String getWelcome() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        return "Hello from\n" + logo
                + "\nInput a Todo, Deadline, or Event to start logging your tasks!";
    }
}
