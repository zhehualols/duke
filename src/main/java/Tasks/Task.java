package Tasks;

public class Task {
    protected boolean isDone;
    protected String description;
    protected priorityLevel priority;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
        this.priority = priorityLevel.Low;
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

    public String priorityCheck(){
        return priority.toString();
    }
    @Override
    public String toString(){
        return statusCheck() + " " + description + " Priority: " + priorityCheck();
    }


    public enum priorityLevel {
        High,
        Medium,
        Low
    }


    public void changePriority(priorityLevel priority){
        this.priority = priority;
    }
}
