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

}
