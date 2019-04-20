package com.todo.model;

import java.util.ArrayList;

public class List extends ArrayList<Task> {
    public void showList() {
        System.out.println("List Info:");
        for (int i = 0; i < this.size(); i++) {
            this.get(i).printContent();
        }
    }
}