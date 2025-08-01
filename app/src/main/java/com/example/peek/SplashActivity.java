package com.example.peek;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    private static final int SPLASH_DURATION = 2000; // 2 seconds

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(() -> {
            // Go to main screen
            Intent intent = new Intent(SplashActivity.this, FriendsActivity.class);
            startActivity(intent);
            finish(); // close splash screen so user can't return to it
        }, SPLASH_DURATION);
    }
}
