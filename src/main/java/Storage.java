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

    public void appendToFile(String t) throws IOException {
        FileWriter fw = new FileWriter(this.filePath, true);
        fw.write(t);
        fw.close();
    }

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
