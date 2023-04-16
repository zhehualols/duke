import TaskList.TaskList;
import Tasks.Deadline;
import Tasks.Event;
import Tasks.Task;
import Tasks.Todo;
import Ui.Interface;
import Exception.DukeException;
import Storage.Storage;
import java.util.Scanner;
import DateTimeUtl.DataTimeUtl;

public class Duke {
    private Interface ui;
    private Storage storage;
    private TaskList tasks;
    public Duke(){
        ui = new Interface();
        storage = new Storage();
        storage.readFile();
        tasks = storage;
    }
    public void run() {
        ui.welcome();
        String line ;
        Scanner in = new Scanner(System.in);

        while(true) {

            line = in.nextLine();
            if(line.toUpperCase().contains("BYE")){
                System.out.println("Bye. Hope to see you again soon!");
                break;
            }
            if(line.toUpperCase().contains("LIST")){
                tasks.printTaskList();
                continue;
            }
            if(line.toUpperCase().contains("MARK") && line.toUpperCase().contains("unmark") == false ){
                String k = line.replaceAll("[^0-9]", "");
                int taskNum = Integer.parseInt(k)-1;
                tasks.getListTask(taskNum).setDone();
                System.out.println("Nice! I've marked this task as done:");
                System.out.println(tasks.getListTask(taskNum).toString());
                continue;
            }
            if(line.toUpperCase().contains("UNMARK")){
                String k = line.replaceAll("[^0-9]", "");
                int taskNum = Integer.parseInt(k)-1;
                tasks.getListTask(taskNum).setUnDone();
                System.out.println("OK, I've marked this task as not done yet:");
                System.out.println(tasks.getListTask(taskNum).toString());
                continue;
            }
            if(line.toUpperCase().contains("PRIORITY")){
                String k = line.replaceAll("[^0-9]", "");
                int taskNum = Integer.parseInt(k)-1;
                String[] priority = line.split(" " , 3);
                switch(priority[2].toUpperCase()){
                    case "HIGH":
                        tasks.getListTask(taskNum).changePriority(Task.priorityLevel.High);
                        break;
                    case "MEDIUM":
                        tasks.getListTask(taskNum).changePriority(Task.priorityLevel.High);
                        break;
                    case "LOW":
                        tasks.getListTask(taskNum).changePriority(Task.priorityLevel.High);
                        break;
                    default:
                        System.out.println("priority given is wrong. Only (high , medium , low)");
                        continue;
                }
                System.out.println("OK, I've changed this task's prioirty to: " + priority[2]);
                System.out.println(tasks.getListTask(taskNum).toString());
                continue;
            }
            if(line.toUpperCase().contains("DELETE")){
                String k = line.replaceAll("[^0-9]", "");
                int taskNum = Integer.parseInt(k)-1;
                ui.printRemovedTask(tasks.getListTask(taskNum).toString(), tasks.getListSize()-1);
                tasks.removeListTask(taskNum);
                continue;
            }
            if(line.toUpperCase().contains("FIND")){
                String[] spiltInput = line.split(" ", 2);
                System.out.println("Here are the matching tasks in your list:");
                for (int i = 0 ; i < tasks.getListSize() ; i++) {
                    if (tasks.getListTask(i).getDescription().contains(spiltInput[1])) {
                        System.out.println(tasks.getListTask(i));
                    }
                }
                continue;
            }
            if(line.toUpperCase().contains("TODO")){
                String[] spiltInput = line.split(" ", 2);
                if(spiltInput.length < 2){ // No description of task
                    DukeException exception = new DukeException("☹ OOPS!!! The description of a " + spiltInput[0].trim() + " cannot be empty.");
                    exception.printException();
                    continue;
                }
                tasks.addListTask(new Todo(spiltInput[1]));
                ui.printAddedTask(tasks.getListTask(tasks.getListSize()-1).getDescription(),tasks.getListSize());
                continue;
            }
            if(line.toUpperCase().contains("EVENT")){
                String[] spiltInput = line.split(" ", 2);
                if(line.toUpperCase().contains("/FROM") && line.toUpperCase().contains("/TO")) {
                    if(spiltInput.length < 2){
                        DukeException exception = new DukeException("☹ OOPS!!! The description of a " + spiltInput[0].trim() + " cannot be empty.");
                        exception.printException();
                        continue;
                    }
                    String[] espiltInput = spiltInput[1].split("/from",2);
                    String[] espiltInput2 = espiltInput[1].split("/to",2);
                    tasks.addListTask(new Event(espiltInput[0],
                            DataTimeUtl.convertDT(espiltInput2[0].trim()),
                            DataTimeUtl.convertDT(espiltInput2[1].trim())));
                    ui.printAddedTask(tasks.getListTask(tasks.getListSize()-1).getDescription(),tasks.getListSize());
                    continue;
                }
                else {
                    DukeException exception = new DukeException("☹ OOPS!!! command is missing /from or /to for event task");
                    exception.printException();
                    continue;
                }
            }
            if(line.toUpperCase().contains("DEADLINE")){
                String[] spiltInput = line.split(" ", 2);
                if(line.toUpperCase().contains("/BY")) {
                    if(spiltInput.length < 2){
                        DukeException exception= new DukeException("☹ OOPS!!! The description of a " + spiltInput[0].trim() + " cannot be empty.");
                        exception.printException();
                        continue;
                    }
                    String[] dspiltInput = spiltInput[1].split("/by",2);
                    tasks.addListTask(new Deadline(dspiltInput[0], DataTimeUtl.convertDT(dspiltInput[1].trim())));
                    ui.printAddedTask(tasks.getListTask(tasks.getListSize()-1).getDescription(),tasks.getListSize());
                    continue;
                }
                else {
                    DukeException exception = new DukeException("☹ OOPS!!! command is missing a /by for deadline task");
                    exception.printException();
                    continue;
                }
            }
            System.out.println("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
        }

    }
    public static void main(String[] args) {
        new Duke().run();
    }

}
