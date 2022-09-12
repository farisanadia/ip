package duke;

import java.io.File;
import java.io.IOException;

public class Duke {
    protected Storage storage;
    protected TaskList taskList;
    protected Ui ui = new Ui();
    protected Parser parser;
    protected boolean hasInitialised = false;

    /**
     * Gets response from Duke.
     * @param input User Input.
     * @return String output.
     * @throws IOException
     */
    public String getResponse(String input) throws IOException {
        if (!hasInitialised) {
            File dukeFile = new File("duke.txt");
            dukeFile.createNewFile();
            storage = new Storage("duke.txt", dukeFile);
            taskList = new TaskList(storage.readFile(), storage);
            parser = new Parser(ui, taskList);
        }
        hasInitialised = true;
        return parser.inputProcessor(input);
    }
}
