package com.volodiachornenkyy.circleci_example;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private GreetingCreator greetingCreator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        greetingCreator = new GreetingCreator();

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView textView = (TextView) findViewById(R.id.text);
                textView.setText(greetingCreator.get(view.getContext(), "Volodia"));
            }
        });
    }
}
