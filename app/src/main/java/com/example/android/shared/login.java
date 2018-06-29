package com.example.android.shared;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.android.shared.R;

public class login extends AppCompatActivity {


    TextView savedText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        SharedPreferences sharedPreferences=getSharedPreferences("Prefs",MODE_PRIVATE);

        String displayText=sharedPreferences.getString("display","");
        savedText=(TextView)findViewById(R.id.textView);

        savedText.setText(displayText);







    }
}