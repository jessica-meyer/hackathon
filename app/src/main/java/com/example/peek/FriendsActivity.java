package com.example.peek;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.peek.R;

import java.util.ArrayList;
import java.util.List;

import backend.Database;
import backend.user;

public class FriendsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FriendAdapter adapter;
    private List<Friend> friendList;

    ImageButton btnFriends, btnSearch, btnAdd, btnCollections;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends); // your layout with RecyclerView

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // backend stuff
        Database db = new Database();
        db.readAll(this);
        friendList = new ArrayList<>();
        friendList.add(new Friend("Bob", "legofan55", R.drawable.lego_placeholder, false));
        friendList.add(new Friend("Clover", "cavoodleClover", R.drawable.clover_placeholder, false));
        friendList.add(new Friend("Aroha Kiri", "fruitSalad", R.drawable.aroha_placeholder, false));
        friendList.add(new Friend("Labubu Lover", "skibidiRizzler", R.drawable.skibidi_placeholder, false));

        adapter = new FriendAdapter(this, friendList);
        recyclerView.setAdapter(adapter);

        // Initialize bottom bar buttons
        btnFriends = findViewById(R.id.btnFriends);
        btnSearch = findViewById(R.id.btnSearch);
        btnAdd = findViewById(R.id.btnAdd);
        btnCollections = findViewById(R.id.btnCollections);

        btnFriends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Go to PeopleActivity
                Intent intent = new Intent(FriendsActivity.this, FriendsActivity.class);
                startActivity(intent);
            }
        });

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Go to SearchActivity
                Intent intent = new Intent(FriendsActivity.this, SearchActivity.class);
                startActivity(intent);
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Go to AddActivity
                Intent intent = new Intent(FriendsActivity.this, CreateCollectionActivity.class);
                startActivity(intent);
            }
        });

        btnCollections.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Go to BoxActivity
                Intent intent = new Intent(FriendsActivity.this, MyCollections.class);
                startActivity(intent);
            }
        });
    }
}