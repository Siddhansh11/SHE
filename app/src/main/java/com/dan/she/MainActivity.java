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
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.installations.FirebaseInstallations;
import com.google.firebase.installations.InstallationTokenResult;
import com.google.firebase.messaging.FirebaseMessaging;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Bundle extras = getIntent().getExtras();
//        String V1 = extras.getString(Intent.EXTRA_TEXT);
//        Log.d("NumberMainActivity", V1);

        FirebaseMessaging.getInstance().subscribeToTopic("all");
        updateToken();
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

    public void invokeSoS(){
        FcmNotificationsSender notificationsSender = new FcmNotificationsSender("/topics/all", "SHE", "Help please...!!", getApplicationContext(), MainActivity.this);

        notificationsSender.SendNotifications();
    }

    private void updateToken(){
        FirebaseInstallations.getInstance().getToken(false).addOnCompleteListener(new OnCompleteListener<InstallationTokenResult>() {
            @Override
            public void onComplete(@NonNull Task<InstallationTokenResult> task) {
                if(!task.isSuccessful()){
                    return;
                }
                // Get new Instance ID token
                TokenHelper token = new TokenHelper(task.getResult().getToken());
                Log.d("Update token : ", token.getToken());
                Map<String, Object> t = new HashMap<>();
                t.put("token", token.getToken());
                FirebaseDatabase.getInstance().getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).updateChildren(t);
            }
        });
    }


    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {

        int key = event.getKeyCode();
        switch (key) {
            case (KeyEvent.KEYCODE_VOLUME_DOWN):
                if(event.getRepeatCount() == 100){
                    // Do long press event here
                    invokeSoS();
//                    Log.d("Down Pressed", event.toString());
                    Toast.makeText(getApplicationContext(),"SOS sent successfully..",Toast.LENGTH_SHORT).show();
                }

            case (KeyEvent.KEYCODE_VOLUME_UP):
                if(event.getRepeatCount() == 100){
                    // Do long press event here
                    invokeSoS();
//                    Log.d("Up Pressed", event.toString());
                    Toast.makeText(getApplicationContext(),"SOS sent successfully..",Toast.LENGTH_SHORT).show();
                }
        }
        return super.dispatchKeyEvent(event);
    }
}
