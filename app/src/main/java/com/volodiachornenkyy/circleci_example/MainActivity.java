package com.volodiachornenkyy.circleci_example;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GreetingCreator greetingCreator = new GreetingCreator();

        TextView textView = (TextView) findViewById(R.id.text);
        textView.setText(greetingCreator.get(this, "Volodia"));
    }
}
