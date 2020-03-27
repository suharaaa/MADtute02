package com.example.intentsproj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.IntentsProj.MESSAGE";
    public static final String EXTRA_MESSAGE2 = "com.example.IntentsProj.MESSAGE2";

    Button btnok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        btnok = (Button) findViewById(R.id.ok);
        btnok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSecondActivity();
            }
        });




    }

    public void openSecondActivity(){

        Intent intent1 = new Intent(this, SecondActivity.class);


        EditText text1 =(EditText) findViewById(R.id.input1);
        EditText text2 = (EditText) findViewById(R.id.input2);

        String num1 =text1.getText().toString();
        String num2 = text2.getText().toString();

        intent1.putExtra(EXTRA_MESSAGE, num1);
        intent1.putExtra(EXTRA_MESSAGE2, num2);


        Context context = getApplicationContext();
        //The context to use. Usually your Application or Activity object
        CharSequence message = "You just clicked the OK button";
        //Display string
        int duration = Toast.LENGTH_SHORT;
        //How long the toast message will lasts
        Toast toast = Toast.makeText(context, message, duration); toast.show();

        toast.setGravity(Gravity.TOP|Gravity.LEFT, 0, 0);


        startActivity(intent1);

    }

}


