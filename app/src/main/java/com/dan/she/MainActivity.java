package com.dan.she;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Bundle extras = getIntent().getExtras();
//        String V1 = extras.getString(Intent.EXTRA_TEXT);
//        Log.d("NumberMainActivity", V1);

        FirebaseMessaging.getInstance().getToken()
                .addOnCompleteListener(new OnCompleteListener<String>() {
                    @Override
                    public void onComplete(@NonNull Task<String> task) {
                        if (!task.isSuccessful()) {
                            Log.w(TAG, "Fetching FCM registration token failed", task.getException());
                            return;
                        }

                        // Get new FCM registration token
                        String token = task.getResult();

                        // Log and toast
                        String msg = getString(R.string.msg_token_fmt, token);
                        Log.d(TAG, msg);
                        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                    }
                });
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Bundle extras = getIntent().getExtras();
        String V1 = extras.getString(Intent.EXTRA_TEXT);
        Log.d("NumberMainActivity", V1);
    }

    //    public void myProfile(View v){
//        Intent i = new Intent(getApplicationContext(), MyProfile.class);
//        startActivity(i);
//    }

    public void addRelative(View v){
        Intent i = new Intent(getApplicationContext(), AddRelative.class);
        startActivity(i);
    }

    public void helplineNumbers(View v){
        Intent i = new Intent(getApplicationContext(), helplineCall.class);
        startActivity(i);
    }

    public void triggers(View v){
        Intent i = new Intent(getApplicationContext(), TrigActivity.class);
        startActivity(i);
    }

    public void developedBy(View v){
        Intent i = new Intent(getApplicationContext(), DeveloperByActivity.class);
        startActivity(i);
    }

    public void HowTo(View v){
        Intent i = new Intent(getApplicationContext(), HowToSwipe.class);
        startActivity(i);
    }

    public void LogOut(View v){
        Intent i = new Intent(getApplicationContext(), Login.class);
        startActivity(i);
    }


    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {

        int key = event.getKeyCode();
        switch (key) {
            case (KeyEvent.KEYCODE_VOLUME_DOWN):
                if(event.getRepeatCount() >= 100){
                    // Do long press event here
                    Log.d("Down Pressed", event.toString());
                    Toast.makeText(getApplicationContext(),"SOS sent successfully..",Toast.LENGTH_SHORT).show();
                }

            case (KeyEvent.KEYCODE_VOLUME_UP):
                if(event.getRepeatCount() >= 100){
                    // Do long press event here
                    Log.d("Up Pressed", event.toString());
                    Toast.makeText(getApplicationContext(),"SOS sent successfully..",Toast.LENGTH_SHORT).show();
                }
        }
        return super.dispatchKeyEvent(event);
    }
}
