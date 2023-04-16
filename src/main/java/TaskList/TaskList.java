package TaskList;

import Tasks.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
public class TaskList {
    private ArrayList<Task> list; //initialize Tasks.Task arraylist

    public TaskList() {
        this.list = new ArrayList<Task>();
    }
    public void printTaskList() { // Prints TaskList.TaskList
        System.out.println("Here are the tasks in your list:");
        for(int i = 0; i < this.list.size(); i++) {
            System.out.println(i+1 + "." + this.list.get(i).toString());
        }
    }


    public void loadTask(Task task){
        this.list.add(task);
    }

    public static Task taskPerLine(String nextLine) {
        String[] body = nextLine.split(" \\| ");
        Task task = null;
        switch (body[0]) {
            case "T":
                task = new Todo(body[2]);
                if (body[1].equals("1")) {
                    task.setDone();
                }
                break;
            case "D":
                task = new Deadline(body[2],
                        LocalDateTime.parse(body[3].replace("T"," "), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
                if (body[1].equals("1")) {
                    task.setDone();
                }
                break;
            case "E":
                task = new Event(body[2],
                        LocalDateTime.parse(body[3].replace("T"," "), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")),
                        LocalDateTime.parse(body[4].replace("T"," "), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
                if (body[1].equals("1")) {
                    task.setUnDone();
                }
                break;
        }
        return task;
    }

    public int getListSize () {
        return this.list.size();
    }

    public Task getListTask(int index) {
        Task item = this.list.get(index);
        return item;
    }

    public Task removeListTask(int index) {
        return this.list.remove(index);
    }

    public void addListTask(Task task) {
        this.list.add(task);
    }
}
