package com.example.mesut.todolist.core;

/**
 * Created by Janik on 29.01.2018.
 */

public class Category {

    private int id;
    private String name;

    public Category(){
    }

    @Override
    public String toString(){
        String s = id + "-" + name;
        return s;
    }


    public int getId() {
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
