package android.studies.minhaideia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends AppCompatActivity {

    int microseconds = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //method call to switch screens
        changeScreen();
    }

    private void changeScreen() {

        new Handler().postDelayed(() -> {
            //I get the activity I am and I get the activity I want to go
            Intent switchScreens = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(switchScreens);
            finish();
        },microseconds);

    }
}