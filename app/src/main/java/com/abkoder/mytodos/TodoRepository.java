package com.abkoder.mytodos;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

class TodoRepository {

    private TodoDao mTodoDao;
    private LiveData<List<Todo>> mAllTodos;
    private LiveData<List<Todo>> mUITodos;
    private LiveData<List<Todo>> mNUITodos;
    private LiveData<List<Todo>> mUNITodos;
    private LiveData<List<Todo>> mNUNITodos;

    TodoRepository(Application application){
        TodoRoomDatabase db = TodoRoomDatabase.getDatabase(application);
        mTodoDao = db.todoDao();
        mAllTodos = mTodoDao.getTodos();
        mUITodos = mTodoDao.getUITodos();
        mNUITodos = mTodoDao.getNUITodos();
        mUNITodos = mTodoDao.getUNITodos();
        mNUNITodos = mTodoDao.getNUNITodos();

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

    LiveData<List<Todo>> getUITodos(){ return mUITodos;}
    LiveData<List<Todo>> getNUITodos(){ return mNUITodos;}
    LiveData<List<Todo>> getUNITodos(){ return mUNITodos;}
    LiveData<List<Todo>> getNUNITodos(){ return mNUNITodos;}

}
