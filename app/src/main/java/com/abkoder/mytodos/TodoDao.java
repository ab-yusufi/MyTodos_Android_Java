package com.abkoder.mytodos;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface TodoDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Todo todo);

    @Query("DELETE FROM todo_table")
    void deleteAll();

    @Query("SELECT * FROM todo_table")
    LiveData<List<Todo>> getTodos();

    @Delete
    void deleteTodo(Todo todo);
}
