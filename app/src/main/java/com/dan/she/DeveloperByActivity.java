package com.dan.she;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class DeveloperByActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developer_by);
    }

    public void Dan(View v){
        Intent implicit = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/sakshigoyal-19"));
        startActivity(implicit);
    }

    public void Ary(View v){
        Intent implicit = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/siddhansh-jatale-ba5264190"));
        startActivity(implicit);

    }

    public void Him(View v){
        Intent implicit = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/shubhanshi-makwana-26128b18b"));
        startActivity(implicit);

    }
    public void xyz(View v){
        Intent implicit = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/tanishkatelang-017"));
        startActivity(implicit);

    }
}
