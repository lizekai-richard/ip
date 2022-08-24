import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Processes IO requests
 */
public class FileProcessor {
    private final String filePath;

    /**
     * Constructor for FileProcessor
     * @param filePath user's data file path
     */
    public FileProcessor(String filePath) {
        this.filePath = filePath;
    }

    private void createFile() {
        File file = new File(this.filePath);
        try {
            if (file.createNewFile()) {
                System.out.println("Your new personal data file has been created!");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private void createFolder() {
        File dataFolder = new File("data");
        if (!dataFolder.mkdir()) {
            System.out.println("Welcome Back!");
        }
    }

    /**
     * Initializes the file processor.
     */
    public void initialize() {
        this.createFolder();
        this.createFile();
    }

    /**
     * Saves new tasks
     * @param taskList the task list which contains new added tasks
     */
    public void save(ArrayList<Task> taskList) {
        File file = new File(filePath);
        try {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream writer = new ObjectOutputStream(fos);
            writer.writeObject(taskList);
            fos.close();
            writer.close();
        } catch (IOException e) {
            System.out.println(e);
            System.out.println("Oops! Something wrong with your personal file...");
        }
    }

    /**
     * Loads task list
     * @return user's previous tasklist
     */
    public ArrayList<Task> load() {
        File file = new File(filePath);
        ArrayList<Task> taskList = null;
        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream reader = new ObjectInputStream(fis);
            taskList = (ArrayList<Task>) reader.readObject();
            reader.close();
        } catch (EOFException eof) {
            taskList = null;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e);
            System.out.println("Oops! Something wrong with your personal file...");
        }
        return taskList;
    }

}
