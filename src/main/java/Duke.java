import java.util.Scanner;
public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello! I'm \n" + logo + "\nWhat can I do for you?");

        String[] line = new String[100];
        Scanner in = new Scanner(System.in);
        Task[] lists = new Task[100];
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
                    boolean checkMark = lists[j-1].isDone();
                    if (checkMark) {
                        System.out.println(j + "." + "   [X] " + lists[j-1].getDescription());
                    } else {
                        System.out.println(j + "." + "   [ ] " + lists[j-1].getDescription());
                    }
                }
                i--;
                continue;
            }
            if(line[i].contains("mark") && line[i].contains("unmark") == false ){
                String k = line[i].replaceAll("[^0-9]", "");
                int taskNum = Integer.parseInt(k)-1;
                System.out.println("Nice! I've marked this task as done:");
                System.out.println("   [X] " +lists[taskNum].getDescription());
                lists[taskNum].setDone(true);
                i--;
                continue;
            }
            if(line[i].contains("unmark")){
                String k = line[i].replaceAll("[^0-9]", "");
                int taskNum = Integer.parseInt(k)-1;
                System.out.println("OK, I've marked this task as not done yet:");
                System.out.println("   [ ] " +lists[taskNum].getDescription());
                lists[taskNum].setDone(false);
                i--;
                continue;
            }
            System.out.println("-----------------------------\n" + "added: "+line[i] + "\n-----------------------------");
            lists[i] = new Task(line[i]);
            taskCount++;
        }

    }

}
