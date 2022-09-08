package duke;

import java.io.IOException;

public class Parser {
    protected Ui ui;
    //to add Tasklist object that handles updating taskList as required
    protected TaskList taskList;

    public Parser(Ui ui, TaskList t) {
        this.ui = ui;
        this.taskList = t;
    }

    /**
     * Processes input given by user.
     * If input unknown, passes error.
     * @param s Input given by user.
     */
    public String inputProcessor(String s) {
        String[] userInput = s.split(" ");
        switch (userInput[0].toLowerCase()) {
        case "mark" :
            try {
                int pos = Integer.parseInt(userInput[1]) - 1;
                taskList.markTask(pos);
                return "    Nice! I've marked this task as done:\n" + taskList.taskToString(pos);
            } catch (IndexOutOfBoundsException e) {
                return "☹ OOPS!!! Invalid index given.";
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
            case "unmark" :
            try {
                int pos = Integer.parseInt(userInput[1])- 1;
                taskList.unmarkTask(pos);
                return "    Ok, I've marked this task as not done yet:\n " +
                        taskList.taskToString(pos);
            } catch (IndexOutOfBoundsException e) {
                return "☹ OOPS!!! Invalid index given.";
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        case "delete" :
            try {
                int pos = Integer.parseInt(userInput[1]) - 1;
                String temp = taskList.taskToString(pos);
                taskList.removeTask(pos);
                return "    Noted. I've removed this task:\n" + temp +
                        "\n  Now you have " + String.valueOf(taskList.getSize()) +
                        " tasks in this list.";
            } catch (IndexOutOfBoundsException e) {
                return "☹ OOPS!!! Invalid index given.";
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        case "list" :
            return taskList.toString();
        case "find" :
            return taskList.findTask(userInput[1]);
        case "todo" :
        case "deadline" :
        case "event" :
            return taskProcessor(s, userInput[0]);
        default:
            assert false : "☹ OOPS!!! I'm sorry, but I don't know what that means.";
        }
        return "I don't know this command. Try another one!";
    }

    /**
     * Processes specific task given by user.
     * @param input String input given by user to be processed.
     * @param taskType String type of task given by user.
     */
    public String taskProcessor(String input, String taskType) {
        switch (taskType.toLowerCase()) {
        case ("todo"):
            try {
                ToDos currInput = new ToDos(input.substring(5, input.length()));
                taskList.addTask(currInput);
                return "Got it. I've added this task:\n" + currInput.getFullDesc() +
                        "\nNow you have " + String.valueOf(taskList.getSize()) +
                        " tasks in this list.";
            } catch (StringIndexOutOfBoundsException t) {
                return "☹ OOPS!!! The description of a todo cannot be empty.";
            } catch (IOException e) {
                e.printStackTrace();
            }
        case ("deadline"):
            try {
                String[] userInput = input.split("/");
                Deadlines currInput = new Deadlines(userInput[0].substring(9, userInput[0].length()),
                        userInput[1]);
                String checkConflict = taskList.checkScheduleClash(currInput);
                taskList.addTask(currInput);
                return "Got it. I've added this deadline:\n" + currInput.getFullDesc() +
                        "\nNow you have " + String.valueOf(taskList.getSize()) +
                        " tasks in this list.\n" + checkConflict;
            } catch (StringIndexOutOfBoundsException t) {
                return "☹ OOPS!!! The description of a deadline cannot be empty.";
            } catch (IOException e) {
                e.printStackTrace();
            }
        case ("event"):
            try {
                String[] userInput = input.split("/");
                Events currInput = new Events(userInput[0].substring(6),
                        userInput[1]);
                String checkConflict = taskList.checkScheduleClash(currInput);
                taskList.addTask(currInput);
                return "Got it. I've added this event:\n" + currInput.getFullDesc() +
                        "\nNow you have " + String.valueOf(taskList.getSize()) +
                        " tasks in this list.\n" + checkConflict;
            } catch (StringIndexOutOfBoundsException t) {
                return "☹ OOPS!!! The description of an event cannot be empty.";
            } catch (IOException e) {
                e.printStackTrace();
            }
        default:
            assert false : ("☹ OOPS!!! I'm sorry, but I don't know what that means.");
        }
        return "I don't know this command. Try another one!";
    }
}
