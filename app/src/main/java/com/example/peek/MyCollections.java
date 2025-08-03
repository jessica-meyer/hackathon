package com.example.peek;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class MyCollections extends AppCompatActivity {

    ImageButton btnFriends, btnSearch, btnAdd, btnCollections;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_collections); // ← change to your layout filename

        // Initialize bottom bar buttons
        btnFriends = findViewById(R.id.btnFriends);
        btnSearch = findViewById(R.id.btnSearch);
        btnAdd = findViewById(R.id.btnAdd);
        btnCollections = findViewById(R.id.btnCollections);

        btnFriends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Go to PeopleActivity
                Intent intent = new Intent(MyCollections.this, FriendsActivity.class);
                startActivity(intent);
            }
        });
        
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Go to SearchActivity
                Intent intent = new Intent(MyCollections.this, SearchActivity.class);
                startActivity(intent);
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Go to AddActivity
                Intent intent = new Intent(MyCollections.this, CreateCollectionActivity.class);
                startActivity(intent);
            }
        });

        btnCollections.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Go to BoxActivity
                Intent intent = new Intent(MyCollections.this, MyCollections.class);
                startActivity(intent);
            }
        });
    }
}
