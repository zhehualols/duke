import java.util.Scanner;

public class Duke {
    private Interface ui;
    public Duke(){
        ui = new Interface();
    }
    public void run() {
        ui.welcome();
        String[] line = new String[100];
        Scanner in = new Scanner(System.in);
        Task[] lists = new Task[100];
        DukeException[] exceptions = new DukeException[100];
        int taskCount = 0;

        for(int i=0; i< line.length ; i++) {
            line[i] = in.nextLine();
            if(line[i].contains("bye")){
                System.out.println("Bye. Hope to see you again soon!");
                break;
            }
            if(line[i].contains("list")){
                System.out.println("Here are the tasks in your list:\n");
                for(int j=1; j<=taskCount;j++) {
                    System.out.println(j + "."+lists[j-1].toString());
                }
                i--;
                continue;
            }
            if(line[i].contains("mark") && line[i].contains("unmark") == false ){
                String k = line[i].replaceAll("[^0-9]", "");
                int taskNum = Integer.parseInt(k)-1;
                lists[taskNum].setDone();
                System.out.println("Nice! I've marked this task as done:");
                System.out.println(lists[taskNum].toString());
                i--;
                continue;
            }
            if(line[i].contains("unmark")){
                String k = line[i].replaceAll("[^0-9]", "");
                int taskNum = Integer.parseInt(k)-1;
                lists[taskNum].setUnDone();
                System.out.println("OK, I've marked this task as not done yet:");
                System.out.println(lists[taskNum].toString());
                i--;
                continue;
            }
            if(line[i].contains("todo")){
                String[] spiltInput = line[i].split(" ", 2);
                if(spiltInput.length < 2){
                    exceptions[i] = new DukeException("☹ OOPS!!! The description of a " + spiltInput[0].trim() + " cannot be empty.");
                    exceptions[i].printException();
                    continue;
                }
                lists[i] = new Todo(spiltInput[1]);
                ui.printAddedTask(lists[i].getDescription(),i+1);
                taskCount++;
                continue;
            }
            if(line[i].contains("event")){
                String[] spiltInput = line[i].split(" ", 2);
                if(line[i].contains("/from") && line[i].contains("/to")) {
                    if(spiltInput.length < 2){
                        exceptions[i] = new DukeException("☹ OOPS!!! The description of a " + spiltInput[0].trim() + " cannot be empty.");
                        exceptions[i].printException();
                        continue;
                    }
                    String[] espiltInput = spiltInput[1].split("/from",2);
                    String[] espiltInput2 = espiltInput[1].split("/to",2);
                    lists[i] = new Event(espiltInput[0],espiltInput[1],espiltInput2[1]);
                    ui.printAddedTask(lists[i].getDescription(), i + 1);
                    taskCount++;
                    continue;
                }
                else {
                    exceptions[i] = new DukeException("☹ OOPS!!! command is missing /from or /to for event task");
                    exceptions[i].printException();
                    continue;
                }
            }
            if(line[i].contains("deadline")){
                String[] spiltInput = line[i].split(" ", 2);
                if(line[i].contains("/by")) {
                    if(spiltInput.length < 2){
                        exceptions[i] = new DukeException("☹ OOPS!!! The description of a " + spiltInput[0].trim() + " cannot be empty.");
                        exceptions[i].printException();
                        continue;
                    }
                    String[] dspiltInput = spiltInput[1].split("/by",2);
                    lists[i] = new Deadline(dspiltInput[0],dspiltInput[1]);
                    ui.printAddedTask(lists[i].getDescription(), i + 1);
                    taskCount++;
                    continue;
                }
                else {
                    exceptions[i] = new DukeException("☹ OOPS!!! command is missing a /by for deadline task");
                    exceptions[i].printException();
                    continue;
                }
            }
            i--;
            System.out.println("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
        }

    }
    public static void main(String[] args) {
        new Duke().run();
    }

}
