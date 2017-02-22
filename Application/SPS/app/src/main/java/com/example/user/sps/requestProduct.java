package com.example.user.sps;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class requestProduct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_product);

        Button buttRequest = (Button) findViewById(R.id.buttRequest);
        buttRequest.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent = new Intent(requestProduct.this, MyService.class);
                startService(intent);
                Toast.makeText(getApplicationContext(), "요청이 전송되었습니다.", Toast.LENGTH_SHORT).show();
                finish();

            }
        });

        Button buttBack = (Button) findViewById(R.id.buttBack);
        buttBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });

    }
}
