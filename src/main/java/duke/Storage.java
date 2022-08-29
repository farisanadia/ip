package duke;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {
    protected String filePath;
    protected File dukeFile;

    public Storage(String filePath, File dukeFile) {
        this.filePath = filePath;
        this.dukeFile = dukeFile;
    }

    /**
     * Returns an array list of tasks users input in the past by reading file.
     * @return ArrayList<Task> tasks.</Task>
     */
    public ArrayList<Task> readFile() {
        ArrayList<Task> tasks = new ArrayList<>();
        try{
            Scanner sc = new Scanner(dukeFile);
            while (sc.hasNextLine()) {
                String data = sc.nextLine();
                String[] split = data.split(" : ");

                switch (split[0]) {
                    case "T" :
                        tasks.add(new ToDos(split[2]));
                        if (split[1].equals("[X]")) {
                            tasks.get(tasks.size() - 1).markAsDone();
                        }
                        break;
                    case "D" :
                        tasks.add(new Deadlines(split[2], split[3]));
                        if (split[1].equals("[X]")) {
                            tasks.get(tasks.size() - 1).markAsDone();
                        }
                        break;
                    case "E" :
                        tasks.add(new Events(split[2], split[3]));
                        if (split[1].equals("[X]")) {
                            tasks.get(tasks.size() - 1).markAsDone();
                        }
                        break;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error reading file: file not found!");
        }
        return tasks;
    }

    /**
     * Appends a task to dukeFile when task is to be added.
     * @param t String detailing task to be added.
     * @throws IOException if no file detected.
     */
    public void appendToFile(String t) throws IOException {
        FileWriter fw = new FileWriter(this.filePath, true);
        fw.write(t);
        fw.close();
    }

    /**
     * Modifies details of tasks in dukeFile.
     * @param tasks ArrayList of tasks to update dukeFile with.
     * @throws IOException if no file detected.
     */
    public void modifyFile(ArrayList<Task> tasks) throws IOException {
        try {
            PrintWriter writer = new PrintWriter(this.dukeFile);
            writer.print("");
            for (int i = 0; i < tasks.size(); i++) {
                appendToFile(tasks.get(i).textDesc());
            }
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error reading file: file not found!");
        }
    }
}
