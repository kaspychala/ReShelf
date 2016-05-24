package com.apps.kabzer.reshelf;

/**
 * Created by Kasper on 23.05.2016.
 */
public class Books {
    //private variables
    int id;
    String author;
    String title;

    // Empty constructor
    public Books(){

    }
    // constructor
    public Books(int id, String author, String title){
        this.id = id;
        this.author = author;
        this.title = title;
    }

    // constructor
    public Books(String author, String title){
        this.author = author;
        this.title = title;
    }
    // getting ID
    public int getID(){
        return this.id;
    }

    // setting id
    public void setID(int id){
        this.id = id;
    }

    // getting author
    public String getAuthor(){
        return this.author;
    }

    // setting author
    public void setAuthor(String author){
        this.author = author;
    }

    // getting title
    public String getTitle(){
        return this.title;
    }

    // setting title
    public void setTitle(String title){
        this.title = title;
    }
}

