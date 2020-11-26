package com.abkoder.mytodos;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class TodoViewHolder extends RecyclerView.ViewHolder {
    private final TextView wordItemView;

    private TodoViewHolder(View itemView){
        super(itemView);
        wordItemView = itemView.findViewById(R.id.todo);
    }

    public void bind(String text){
        wordItemView.setText(text);
    }

    static TodoViewHolder create(ViewGroup parent){
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.wordlist_item, parent, false);
        return new TodoViewHolder(view);
    }
}

