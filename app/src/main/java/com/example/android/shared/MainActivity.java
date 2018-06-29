package com.example.android.shared;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.android.shared.R;

public class MainActivity extends AppCompatActivity {

    TextView welcome;
    EditText username,password;
    Button regBtn,logBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        welcome=(TextView)findViewById(R.id.welcomeText);
        username=(EditText)findViewById(R.id.username);
        password=(EditText)findViewById(R.id.password);
        regBtn=(Button)findViewById(R.id.register);
        logBtn=(Button)findViewById(R.id.login);

        logBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user=username.getText().toString();
                String pass=password.getText().toString();

                SharedPreferences sharedPreferences=getSharedPreferences("Prefs",MODE_PRIVATE);
                String details= sharedPreferences.getString(user + pass + "data"  ,"incorrect details" );

                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString("display",details);

                editor.commit();
                Intent i=new Intent(MainActivity.this,login.class);
                startActivity(i);
            }
        });


        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2=new Intent(MainActivity.this,registration.class);
                startActivity(i2);
            }
        });
    }
}