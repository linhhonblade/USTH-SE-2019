package com.todo.model;

import java.util.Scanner;

public class Task {
    private String content;
    private String state;

    // Task constructor
    public Task(String content) {
        this.content = content;
    }

    //add new content
    public void addContent(String newContent) {
        this.content = newContent;
    }

    public void addContent() {
        Scanner scan = new Scanner(System.in);
        content = scan.nextLine();
    }

    //get content
    public String getContent() {
        return this.content;
    }

    //print content in console
    public void printContent() {
        System.out.println(this.content);
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
