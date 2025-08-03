package com.example.peek;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.appcompat.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class FriendsActivity extends Fragment  {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_freinds, container, false);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // backend stuff
        Database db = new Database();
        db.readAll(this);
        friendList = new ArrayList<>();
        for(user u: db.getallUsers()){
            friendList.add(Database.userToFriend(u));

        Toolbar toolbar = view.findViewById(R.id.toolbar);
        if (getActivity() instanceof AppCompatActivity) {
            ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        }

        // DATABASE VARIABLES
        String userName = "username placeholder";
        String name = "name placeholder";

        TextView textViewUsername = view.findViewById(R.id.textViewUsername);
        textViewUsername.setText(userName);

        TextView textViewName = view.findViewById(R.id.textViewName);
        textViewName.setText(name);

        ImageButton imageButton = view.findViewById(R.id.imageButton);
        final boolean[] isToggled = {false};

        imageButton.setOnClickListener(v -> {
            if (isToggled[0]) {
                imageButton.setImageResource(R.drawable.ic_star_outline); // back to first image
            } else {
                imageButton.setImageResource(R.drawable.stars_for_now); // change to second image
            }
            isToggled[0] = !isToggled[0];
        });

        ViewCompat.setOnApplyWindowInsetsListener(view.findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        return view;
    }
}