package com.todo.model;

import java.util.ArrayList;

public class List extends ArrayList<Task> {
    public void showList() {
        System.out.println("List Info:");
        for (int i = 0; i < this.size(); i++) {
            this.get(i).printContent();
        }
    }
    /*public static void main(String[] args){
        List myList = new List();
        *//*Task myTask1 = new Task("Buy milk");
        Task myTask2 = new Task("Wash clothes");*//*
        myList.add(new Task("Buy milk"));
        myList.add(new Task("Wash clothes"));
        myList.showList();
    }*/
}