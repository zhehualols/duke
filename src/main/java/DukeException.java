public class DukeException {
    private String errmsg;

    public DukeException(String message){
        this.errmsg = message;
    }

    public void printException(){
        System.out.println(errmsg);
    }
}
