public class Interface {
    public void welcome() {
        System.out.println("------------------------------------------------------------");
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println(logo);
        System.out.println("------------------------------------------------------------");
        System.out.println("\tHello! I'm duke.Duke");
        System.out.println("\tWhat can I do for you?");
        System.out.println("------------------------------------------------------------");
    }

    public void printAddedTask(String Description , int NumofTask){
        System.out.println("------------------------------------------------------------");
        System.out.println("\tGot it. I've added this task:");
        System.out.println("\t"+ Description);
        System.out.println("\tNow you have " + NumofTask +" tasks in the list.");
        System.out.println("------------------------------------------------------------");
    }
}
