package com.example.peek;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.peek.R;

import java.util.ArrayList;
import java.util.List;

public class FriendsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FriendAdapter adapter;
    private List<Friend> friendList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends); // your layout with RecyclerView

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Example dummy data
        friendList = new ArrayList<>();
        friendList.add(new Friend("Jessica Meyer", "jessica123", R.drawable.placeholder, false));
        friendList.add(new Friend("John Doe", "john_doe", R.drawable.placeholder, false));
        friendList.add(new Friend("Alice Smith", "alice_s", R.drawable.placeholder, false));
        friendList.add(new Friend("Alice Smith", "alice_s", R.drawable.placeholder, false));

        adapter = new FriendAdapter(this, friendList);
        recyclerView.setAdapter(adapter);
    }
}
