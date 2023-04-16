package Exception;

public class DukeException extends Exception{
    private String errMsg;

    public DukeException(String s) {
        this.errMsg = s;
    }

    public void printException(){
        System.out.println(errMsg);
    }
}
