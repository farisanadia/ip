package duke;

import jdk.jshell.Snippet;
import java.io.*;
import java.time.chrono.MinguoDate;
import java.util.Scanner;

public class Duke {
    protected Storage storage;
    protected TaskList taskList;
    protected Ui ui = new Ui();
    protected Parser parser;

    public void run() throws IOException {
        ui.printGreeting();
        File dukeFile = new File("duke.txt"); //creates new text file
        dukeFile.createNewFile();
        storage = new Storage("duke.txt", dukeFile);
        taskList = new TaskList(storage.readFile(), storage);
        parser = new Parser(ui, taskList); //must initialize taskList using storage
        Scanner sc = new Scanner(System.in);
        String userReply = sc.nextLine();

        while (!userReply.equals("bye")) {
            //to introduce parser object that takes processes user input
            parser.inputProcessor(userReply);
            userReply = sc.nextLine();
        }

        ui.printGoodbye();
    }

    public static void main(String[] args) throws IOException {
        new Duke().run();
    }
}
