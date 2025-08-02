package com.example.peek;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Toast;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CreateCollectionActivity extends AppCompatActivity {

    private EditText editTitle, editDescription;
    private FrameLayout imagePickerArea;
    private Button btnDone;

    private ActivityResultLauncher<String> imagePickerLauncher;

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
    }
}
