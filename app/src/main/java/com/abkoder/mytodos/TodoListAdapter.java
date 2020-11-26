package com.abkoder.mytodos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;
import java.util.List;

public class TodoListAdapter extends ListAdapter<Todo, TodoViewHolder> {

    private List<Todo> mTodos;

    public TodoListAdapter(@NonNull DiffUtil.ItemCallback<Todo> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public TodoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return TodoViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull TodoViewHolder holder, int position) {
        Todo mCurrent = getItem(position);
        holder.bind(mCurrent.getTodo());
    }

    static class TodoDiff extends DiffUtil.ItemCallback<Todo> {
        @Override
        public boolean areItemsTheSame(@NonNull Todo oldItem, @NonNull Todo newItem){
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Todo oldItem, @NonNull Todo newItem){
            return oldItem.getTodo().equals(newItem.getTodo());
        }
    }

    public Todo getTodoAtPosition(int position){
        Todo mCurrent = getItem(position);
        return mCurrent;
    }

}
