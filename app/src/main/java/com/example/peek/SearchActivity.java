package com.example.peek;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class SearchActivity extends AppCompatActivity {

    private EditText searchBox;
    private LinearLayout collectionContainer;
    private Button btnDone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        EditText searchBox = findViewById(R.id.searchBox);
        LinearLayout collectionContainer = findViewById(R.id.collectionContainer);
        Button btnDone = findViewById(R.id.btnDone);

        // Initially hide the collection container
        collectionContainer.setVisibility(View.GONE);

        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchBox.setText("");
                collectionContainer.setVisibility(View.VISIBLE);
            }
        });
    }
}
