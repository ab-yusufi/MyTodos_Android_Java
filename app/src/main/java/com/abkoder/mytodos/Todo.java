package com.abkoder.mytodos;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "todo_table")
public class Todo {



    @PrimaryKey()
    @NonNull()
    @ColumnInfo(name = "todo")
    private String todo;

    @ColumnInfo(name = "isui")
    private String isUI;

    public Todo(@NonNull String todo, @NonNull String isUI){
        this.todo = todo;
        this.isUI = isUI;
    }

    //GETTERS


    public String getTodo() {
        return todo;
    }

    public void setmTodo(@NonNull String mTodo) {
        this.todo = mTodo;
    }

    public String getIsUI() {
        return isUI;
    }

    public void setIsUI(String UI) {
        isUI = UI;
    }


    //SETTERS







}
