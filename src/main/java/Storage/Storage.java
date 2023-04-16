package Storage;

import Exception.DukeException;
import Ui.*;
import TaskList.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Storage extends TaskList {
    private final String filePath;
    private static final Storage storage = new Storage();

    public Storage() {
        String dir = System.getProperty("user.dir");
        java.nio.file.Path path = java.nio.file.Paths.get(dir, "data", "storage.txt");
        this.filePath = path.toString();
        fileCreate();
    }



    public void fileCreate() {
        try {
            File file = new File(this.filePath);
            boolean isCreateNewFile = file.createNewFile();
            if (isCreateNewFile) {
                System.out.println("File created,file path: " + file.getAbsolutePath());
            } else {
                System.out.println("File already exist,file path: " + file.getAbsolutePath());
            }
            Interface.printDivider();
        } catch (IOException e) {
            DukeException exception =  new DukeException("☹ OOPS!!! An error for file create occurred.");
            exception.printException();
        }
    }

    public void writeToFile(String textToAdd) {
        try {
            FileWriter fw = new FileWriter(this.filePath);
            fw.write(textToAdd);
            fw.close();
        } catch (IOException e) {
            DukeException exception = new DukeException("File write get problem!");
            exception.printException();
        }
    }

    public void readFile() {
        try {
            File file = new File(this.filePath);
            Scanner s = new Scanner(file);
            while (s.hasNextLine()) {
                storage.loadTask(taskPerLine(s.nextLine()));
            }
        } catch (FileNotFoundException e) {
            DukeException exception = new DukeException("File read get problem!");
            exception.printException();
        }
    }
}
