package com.example.peek;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import backend.Database;
import backend.user;
import backend.Item;
import backend.MyCollection;

public class CreateCollectionActivity extends AppCompatActivity {

    private EditText editTitle, editDescription;
    private FrameLayout imagePickerArea;
    private Button btnDone;

    private ActivityResultLauncher<String> imagePickerLauncher;
    ImageButton btnFriends, btnSearch, btnAdd, btnCollections;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_collection);




        editTitle = findViewById(R.id.editTitle);
        editDescription = findViewById(R.id.editDescription);
        imagePickerArea = findViewById(R.id.imagePickerArea);
        btnDone = findViewById(R.id.btnDone);

        // Initialize image picker launcher
        imagePickerLauncher = registerForActivityResult(
                new ActivityResultContracts.GetContent(),
                uri -> {
                    if (uri != null) {
                        Toast.makeText(this, "Image selected: " + uri.toString(), Toast.LENGTH_SHORT).show();
                    }
                }
        );

        imagePickerArea.setOnClickListener(v -> {
            imagePickerLauncher.launch("image/*");
        });

        btnDone.setOnClickListener(v -> {
            editTitle.setText("");
            editDescription.setText("");
            Toast.makeText(this, "Collection cleared.", Toast.LENGTH_SHORT).show();
        });


        // Initialize bottom bar buttons
        btnFriends = findViewById(R.id.btnFriends);
        btnSearch = findViewById(R.id.btnSearch);
        btnAdd = findViewById(R.id.btnAdd);
        btnCollections = findViewById(R.id.btnCollections);

        btnFriends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Go to PeopleActivity
                Intent intent = new Intent(CreateCollectionActivity.this, FriendsActivity.class);
                startActivity(intent);
            }
        });

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Go to SearchActivity
                Intent intent = new Intent(CreateCollectionActivity.this, SearchActivity.class);
                startActivity(intent);
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Go to AddActivity
                Intent intent = new Intent(CreateCollectionActivity.this, CreateCollectionActivity.class);
                startActivity(intent);
            }
        });

        btnCollections.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Go to BoxActivity
                Intent intent = new Intent(CreateCollectionActivity.this, MyCollections.class);
                startActivity(intent);
            }
        });
    }


}
