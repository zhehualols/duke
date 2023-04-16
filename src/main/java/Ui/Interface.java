package Ui;

public class Interface {
    private static String divider = "------------------------------------------------------------";
    public void welcome() {
        System.out.println(divider);
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println(logo);
        printCommands();
        System.out.println(divider);
        System.out.println("\tHello! I'm duke.Duke");
        System.out.println("\tWhat can I do for you?");
        System.out.println(divider);
    }

    /**
     * This method prints added task and number of tasks left in the task list.
     *
     * @param Description   Description of task added.
     * @param NumofTask     Number of task remaining in list.
     */
    public void printAddedTask(String Description , int NumofTask){
        System.out.println(divider);
        System.out.println("\tGot it. I've added this task:");
        System.out.println("\t"+ Description);
        System.out.println("\tNow you have " + NumofTask +" tasks in the list.");
        System.out.println(divider);
    }

    public void printRemovedTask(String Description , int NumofTask){
        System.out.println(divider);
        System.out.println("\tNoted. I've removed this task:");
        System.out.println("\t"+ Description);
        System.out.println("\tNow you have " + NumofTask +" tasks in the list.");
        System.out.println(divider);
    }


    public static void printDivider(){
        System.out.println(divider);
    }

    public static void printCommands() {
        printDivider();
        System.out.println("Commands you can use:");
        printDivider();
        System.out.println("1. list : list out all current task(s).");
        System.out.println("2. mark (task number) : marks task as done");
        System.out.println("3. unmark (task number) : marks task as not done");
        System.out.println("4. todo (task description) : adds a Todo task");
        System.out.println("5. deadline (task description) /by (yyyy-MM-dd) : adds a Deadline task");
        System.out.println("6. event (task description) /from (yyyy-MM-dd) /to (yyyy-MM-dd) : adds an Event task");
        System.out.println("7. delete (task number) : deletes a specific task");
        System.out.println("8. priority (task number) (high/low/medium) : changes the priority level of a specific task");
        System.out.println("9. bye - EXIT");
        printDivider();
    }
}
