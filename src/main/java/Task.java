public class Task {
    protected boolean isDone;
    protected String description;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public void setDone() {
        isDone = true;
    }

    public void setUnDone() {
        isDone = false;
    }

    public String statusCheck(){
        return (isDone ? "[X]" : "[ ]");
    }
    @Override
    public String toString(){
        return statusCheck() + " " + description;
    }

    public boolean isDone() {
        return isDone;
    }
}
