package com.abkoder.mytodos;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class TodoViewModel extends AndroidViewModel {
    private TodoRepository mRepository;
    private final LiveData<List<Todo>> mAllTodos;
    private final LiveData<List<Todo>> mUITodos;
    private final LiveData<List<Todo>> mNUITodos;
    private final LiveData<List<Todo>> mUNITodos;
    private final LiveData<List<Todo>> mNUNITodos;


    public TodoViewModel(Application application){
        super(application);
        mRepository = new TodoRepository(application);
        mAllTodos = mRepository.getAllTodos();
        mUITodos = mRepository.getUITodos();
        mNUITodos = mRepository.getNUITodos();
        mUNITodos = mRepository.getUNITodos();
        mNUNITodos = mRepository.getNUNITodos();

    }

    LiveData<List<Todo>> getAllTodos(){
        return mAllTodos;
    }

    void insert(Todo todo){
        mRepository.insert(todo);
    }
    void deleteAll(){mRepository.deleteAll();}
    void deleteTodo(Todo todo){mRepository.deleteTodo(todo);}
    LiveData<List<Todo>> getUITodos(){return mUITodos;}
    LiveData<List<Todo>> getNUITodos(){return mNUITodos;}
    LiveData<List<Todo>> getUNITodos(){return mUNITodos;}
    LiveData<List<Todo>> getNUNITodos(){return mNUNITodos;}

}
