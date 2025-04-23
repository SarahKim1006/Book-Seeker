package com.example.bookrecommendationsapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

public class Book extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_book);

        //         find view (component) by its ID "button_to_signup" and store in a variable "buttonToSignUp"
        Button buttonToSignUp = findViewById(R.id.home_button);

        buttonToSignUp.setOnClickListener(new View.OnClickListener() { // set listener for the button
            @Override
            public void onClick(View v) { // if clicked
                Intent intent = new Intent(Book.this, Homepage.class);
                startActivity(intent); // starting sign up activity
            }
        });

    }
}