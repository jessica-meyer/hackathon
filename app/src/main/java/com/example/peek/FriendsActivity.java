package com.example.peek;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.appcompat.widget.Toolbar;

public class FriendsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_freinds);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // DATABASE VARIABLES
        String userName = "username placeholder";
        String name = "name placeholder";

        TextView textViewUsername = findViewById(R.id.textViewUsername);
        textViewUsername.setText(userName);

        TextView textViewName = findViewById(R.id.textViewName);
        textViewName.setText(name);

        ImageButton imageButton = findViewById(R.id.imageButton);
        final boolean[] isToggled = {false};

        imageButton.setOnClickListener(v -> {
            if (isToggled[0]) {
                imageButton.setImageResource(R.drawable.ic_star_outline); // back to first image
            } else {
                imageButton.setImageResource(R.drawable.stars_for_now); // change to second image
            }
            isToggled[0] = !isToggled[0];
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}