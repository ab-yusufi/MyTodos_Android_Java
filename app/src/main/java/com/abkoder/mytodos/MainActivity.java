package com.abkoder.mytodos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TodoViewModel mTodoViewModel;
    private Button mButton;
    private EditText mEditText;
    private TextView mTextView;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton = findViewById(R.id.btnAddTodo);
        mEditText = findViewById(R.id.etTodo);
        mTextView = findViewById(R.id.todo);


        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        final TodoListAdapter adapter = new TodoListAdapter(new TodoListAdapter.TodoDiff());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //Get new or existing model
        mTodoViewModel = new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication())).get(TodoViewModel.class);

        // Add an observer on the LiveData returned by getAlphabetizedWords.
        // The onChanged() method fires when the observed data changes and the activity is
        // in the foreground.
        mTodoViewModel.getAllTodos().observe(this, todos -> {
            // Update the cached copy of the words in the adapter.
            adapter.submitList(todos);
        });

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mTodo = mEditText.getText().toString();
                if(mTodo.isEmpty()){
                    Toast.makeText(getApplicationContext(), "No Input Provided", Toast.LENGTH_SHORT).show();
                } else {
                    Todo todo = new Todo(mTodo);
                    mTodoViewModel.insert(todo);
                    mEditText.setText("");
                }
            }
        });


        ItemTouchHelper helper = new ItemTouchHelper(
                new ItemTouchHelper.SimpleCallback(0,
                        ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
                    @Override
                    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                        return false;
                    }

                    @Override
                    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                        int position = viewHolder.getAdapterPosition();
                        Todo myTodo = adapter.getTodoAtPosition(position);
                        mTodoViewModel.deleteTodo(myTodo);
                        Toast.makeText(MainActivity.this, "DELETED", Toast.LENGTH_SHORT).show();
                    }
                });
        helper.attachToRecyclerView(recyclerView);

    }
}