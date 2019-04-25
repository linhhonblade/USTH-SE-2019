package model;

public class Task {

    private String content;
    private String state;

    // Task constructors
    public Task(String content) {
        this.content = content;
    }

    public Task(String content, String state) {
        this.content = content;
        this.state = state;
    }

    //add new content
    public void addContent(String newContent) {
        this.content = newContent;
    }

    //get content
    public String getContent() {
        return this.content;
    }

    //set state for task
    public void setState(String currentState) {
        this.state = currentState;
    }

    // get task's state
    public String getState() {
        return this.state;
    }
}