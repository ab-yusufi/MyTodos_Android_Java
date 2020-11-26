package com.abkoder.mytodos;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

class TodoRepository {

    private TodoDao mTodoDao;
    private LiveData<List<Todo>> mAllTodos;

    TodoRepository(Application application){
        TodoRoomDatabase db = TodoRoomDatabase.getDatabase(application);
        mTodoDao = db.todoDao();
        mAllTodos = mTodoDao.getTodos();
    }

    LiveData<List<Todo>> getAllTodos(){
        return mAllTodos;
    }

    void insert(Todo todo){
        TodoRoomDatabase.databaseWriteExecutor.execute(() -> {
            mTodoDao.insert(todo);
        });
    }

    void deleteAll(){
        TodoRoomDatabase.databaseWriteExecutor.execute(() -> {
            mTodoDao.deleteAll();
        });
    }

    void deleteTodo(Todo todo){
        TodoRoomDatabase.databaseWriteExecutor.execute(() -> {
            mTodoDao.deleteTodo(todo);
        });

    }

}
