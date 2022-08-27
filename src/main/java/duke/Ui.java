package duke;

public class Ui {

    public void printBuffLine() {
        System.out.println("    _____________________________________");
    }

    public void printGreeting() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";

        System.out.println("    Hello from\n" + logo);
        System.out.println("    What can I do for you?\n");
        printBuffLine();
    }

    public void printString(String msg) {
        printBuffLine();
        System.out.println(msg);
    }

    public void printGoodbye() {
        printBuffLine();
        System.out.println("    Bye. Hope to see you again soon!");
        printBuffLine();
    }

    public void printInvalidIndexError() {
        System.out.println("☹ OOPS!!! I'm sorry, but I don't know what that means.");
    }

}
