package com.example.bookrecommendationsapp;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class Homepage extends AppCompatActivity {
    private DatabaseHelper dbHelper;
    private RecyclerView recyclerView;
    private RecyclerView recyclerView1;
    private RecyclerView recyclerView2;
    private BookAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_homepage);


        //         find view (component) by its ID "button_to_signup" and store in a variable "buttonToSignUp"
        Button buttonToSignUp = findViewById(R.id.homeProfileButton);

        buttonToSignUp.setOnClickListener(new View.OnClickListener() { // set listener for the button
            @Override
            public void onClick(View v) { // if clicked
                Intent intent = new Intent(Homepage.this, Profile.class);
                startActivity(intent); // starting sign up activity
            }
        });
        dbHelper = new DatabaseHelper(this);

        recyclerView = findViewById(R.id.bookList);
        recyclerView1 = findViewById(R.id.bookList1);
        recyclerView2 = findViewById(R.id.bookList2);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView1.setLayoutManager(layoutManager1);
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView2.setLayoutManager(layoutManager2);

        displayBooks("2", recyclerView);
        displayBooks("1", recyclerView1);
        displayBooks("3", recyclerView2);
    }

    private void displayBooks(String level, RecyclerView recyclerview) {
        Cursor cursor = dbHelper.getBookByLevel(level);
////        String[] from = { "title", "author", "genre", "rating", "literature_level" }; // Include literature_level
        adapter = new BookAdapter(this, cursor);
        recyclerview.setAdapter(adapter);
//        int[] to = { R.id.titleTextView, R.id.authorTextView, R.id.genreTextView, R.id.ratingTextView, R.id.literatureLevelTextView, R.id.coverImageView }; // Bind to literatureLevelTextView

//        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.book_item, cursor, from, to, 0);
//        listView.setAdapter(adapter);
    }
}