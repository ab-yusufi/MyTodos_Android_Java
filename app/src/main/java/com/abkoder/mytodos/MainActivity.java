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
import android.content.Intent;
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

    private Button btnUI;
    private Button btnNUI;
    private Button btnUNI;
    private Button btnNUNI;
    public static String checkIt = "";

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnUI = findViewById(R.id.btnUI);
        btnNUI = findViewById(R.id.btnNUI);
        btnUNI = findViewById(R.id.btnUNI);
        btnNUNI = findViewById(R.id.btnNUNI);

        btnUI.setOnClickListener(this::openUrgentImportant);
        btnNUI.setOnClickListener(this::openNotUrgentImportant);
        btnUNI.setOnClickListener(this::openUrgentNotImportant);
        btnNUNI.setOnClickListener(this::openNotUrgentNotImportant);

    }

    public void openUrgentImportant(View v){
        checkIt = "UI";
        Intent intent = new Intent(getApplicationContext(), UrgentImportant.class);
        startActivity(intent);
    }

    public void openNotUrgentImportant(View v){
        checkIt = "NUI";
        Intent intent = new Intent(getApplicationContext(), UrgentImportant.class);
        startActivity(intent);
    }

    public void openUrgentNotImportant(View v){
        checkIt = "UNI";
        Intent intent = new Intent(getApplicationContext(), UrgentImportant.class);
        startActivity(intent);
    }

    public void openNotUrgentNotImportant(View v){
        checkIt = "NUNI";
        Intent intent = new Intent(getApplicationContext(), UrgentImportant.class);
        startActivity(intent);
    }

}