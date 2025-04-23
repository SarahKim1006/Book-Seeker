package com.example.bookrecommendationsapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bookrecommendationsapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    EditText mainUsername, mainPassword;
    Button SignInButton, button_to_sign_up;

    // Used to load the 'bookrecommendationsapp' library on application startup.
    static {
        System.loadLibrary("bookrecommendationsapp");
    }

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_main);

        mainUsername = findViewById(R.id.mainUsername);
        mainPassword = findViewById(R.id.mainPassword);

        //         find view (component) by its ID "button_to_signup" and store in a variable "buttonToSignUp"
        Button buttonToSignIn = findViewById(R.id.SignInButton);

        buttonToSignIn.setOnClickListener(new View.OnClickListener() { // set listener for the button
            @Override
            public void onClick(View v) { // if clicked
//                Intent intent = new Intent(MainActivity.this, Book.class);
//                startActivity(intent); // starting sign up activity
                String username = mainUsername.getText().toString();
                String password = mainPassword.getText().toString();

                if(username.equals("SarahKim09#") && password.equals("1234!")) {
                    // Successful login
                    Intent intent = new Intent(MainActivity.this, Homepage.class);
                    startActivity(intent); // starting sign up activity
                    Toast.makeText(MainActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                } else {
                    // Failed login
                    Toast.makeText(MainActivity.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
                }
            }
        });

//         find view (component) by its ID "button_to_signup" and store in a variable "buttonToSignUp"
        Button buttonToSignUp = findViewById(R.id.button_to_sign_up);

        buttonToSignUp.setOnClickListener(new View.OnClickListener() { // set listener for the button
            @Override
            public void onClick(View v) { // if clicked
                Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
                startActivity(intent); // starting sign up activity
            }
        });

        // Implement authentication logic here

//         Example of a call to a native method
//        TextView tv = binding.sampleText;
//        tv.setText(stringFromJNI());
    }

    /**
     * A native method that is implemented by the 'bookrecommendationsapp' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}