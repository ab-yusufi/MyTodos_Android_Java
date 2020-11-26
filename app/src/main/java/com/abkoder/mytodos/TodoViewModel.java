package com.abkoder.mytodos;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class TodoViewModel extends AndroidViewModel {
    private TodoRepository mRepository;
    private final LiveData<List<Todo>> mAllTodos;

    public TodoViewModel(Application application){
        super(application);
        mRepository = new TodoRepository(application);
        mAllTodos = mRepository.getAllTodos();
    }

    LiveData<List<Todo>> getAllTodos(){
        return mAllTodos;
    }

    void insert(Todo todo){
        mRepository.insert(todo);
    }
    void deleteAll(){mRepository.deleteAll();}
    void deleteTodo(Todo todo){mRepository.deleteTodo(todo);}
}
