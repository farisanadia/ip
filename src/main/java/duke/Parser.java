package duke;

import java.io.IOException;
import java.util.Locale;

public class Parser {
    protected Ui ui;
    //to add Tasklist object that handles updating taskList as required
    protected TaskList taskList;

    public Parser(Ui ui, TaskList t) {
        this.ui = ui;
        this.taskList = t;
    }

    public void inputProcessor(String s) {
        String[] userInput = s.split(" ");
        switch (userInput[0].toLowerCase()) {
        case "mark" :
            try {
                int pos = Integer.parseInt(userInput[1]) - 1;
                taskList.markTask(pos);
                ui.printString("    Nice! I've marked this task as done: ");
                taskList.taskToString(pos);
                ui.printBuffLine();
                break;
            } catch (IndexOutOfBoundsException e) {
                System.out.println("☹ OOPS!!! Invalid index given.");
                break;
            } catch (IOException e) {
                e.printStackTrace();
            }
        case "unmark" :
            try {
                int pos = Integer.parseInt(userInput[1])- 1;
                taskList.unmarkTask(pos);
                ui.printString("    Ok, I've marked this task as not done yet: ");
                taskList.taskToString(pos);
                ui.printBuffLine();
                break;
            } catch (IndexOutOfBoundsException e) {
                System.out.println("☹ OOPS!!! Invalid index given.");
                break;
            } catch (IOException e) {
                e.printStackTrace();
            }
        case "delete" :
            try {
                int pos = Integer.parseInt(userInput[1]) - 1;
                ui.printString("    Noted. I've removed this task: ");
                taskList.taskToString(pos);
                taskList.removeTask(pos);
                ui.printString(" Now you have " + String.valueOf(taskList.getSize()) +
                        " tasks in this list.");
                ui.printBuffLine();
                break;
            } catch (IndexOutOfBoundsException e) {
                System.out.println("☹ OOPS!!! Invalid index given.");
                break;
            } catch (IOException e) {
                e.printStackTrace();
            }
        case "list" :
            ui.printBuffLine();
            System.out.println(taskList.toString());
            ui.printBuffLine();
            break;
        case "todo" :
        case "deadline" :
        case "event" :
            taskProcessor(s, userInput[0]);
            break;
        default:
            ui.printInvalidIndexError();
        }
    }

    public void taskProcessor(String input, String taskType) {
        if (taskType.equals("todo")) {
            try {
                ToDos currInput = new ToDos(input.substring(5, input.length()));
                taskList.addTask(currInput);
                ui.printString("    Got it. I've added this task: ");
                currInput.fullDesc();
                ui.printString("    Now you have " + String.valueOf(taskList.getSize()) +
                        " tasks in this list.");
                ui.printBuffLine();
            } catch (StringIndexOutOfBoundsException t) {
                System.out.println("☹ OOPS!!! The description of a todo cannot be empty.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (taskType.equals("deadline")) {
            try {
                String[] userInput = input.split("/");
                Deadlines currInput = new Deadlines(userInput[0].substring(9, userInput[0].length()),
                        userInput[1]);
                taskList.addTask(currInput);
                ui.printString("    Got it. I've added this deadline: ");
                currInput.fullDesc();
                ui.printString("    Now you have " + String.valueOf(taskList.getSize()) +
                        " tasks in this list.");
                ui.printBuffLine();
            } catch (StringIndexOutOfBoundsException t) {
                System.out.println("☹ OOPS!!! The description of a deadline cannot be empty.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (taskType.equals("event")) {
            try {
                String[] userInput = input.split("/");
                Events currInput = new Events(userInput[0].substring(6),
                        userInput[1]);
                taskList.addTask(currInput);
                ui.printString("    Got it. I've added this event: ");
                currInput.fullDesc();
                ui.printString("    Now you have " + String.valueOf(taskList.getSize()) +
                        " tasks in this list.");
                ui.printBuffLine();
            } catch (StringIndexOutOfBoundsException t) {
                System.out.println("☹ OOPS!!! The description of an event cannot be empty.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
