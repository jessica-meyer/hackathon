package com.example.peek;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class IndividualCollections extends AppCompatActivity {
    ImageButton btnFriends, btnSearch, btnAdd, btnCollections;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.collection_individual); // ← change to your layout filename

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);  // ← shows the arrow
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        // Initialize bottom bar buttons
        btnFriends = findViewById(R.id.btnFriends);
        btnSearch = findViewById(R.id.btnSearch);
        btnAdd = findViewById(R.id.btnAdd);
        btnCollections = findViewById(R.id.btnCollections);

        btnFriends.bringToFront();
        btnSearch.bringToFront();
        btnAdd.bringToFront();
        btnCollections.bringToFront();

        btnFriends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Go to PeopleActivity
                Intent intent = new Intent(IndividualCollections.this, FriendsActivity.class);
                startActivity(intent);
            }
        });

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Go to SearchActivity
                Intent intent = new Intent(IndividualCollections.this, SearchActivity.class);
                startActivity(intent);
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Go to AddActivity
                Intent intent = new Intent(IndividualCollections.this, CreateCollectionActivity.class);
                startActivity(intent);
            }
        });

        btnCollections.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Go to BoxActivity
                Intent intent = new Intent(IndividualCollections.this, MyCollections.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish(); // 👈 Go back one screen
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
