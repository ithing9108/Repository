package com.example.user.homespital;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bt = (Button) findViewById(R.id.button);

        bt.setOnClickListener(
                Intent intent = new Intent(this.MainAct, Sub.class);
                startActivity(intent);

        );
    }
}
