package com.example.user.sps;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttLend = (Button)findViewById(R.id.buttLend);
        Button buttRental = (Button)findViewById(R.id.buttRental);
        Button buttReview = (Button)findViewById(R.id.buttReview);

        buttLend.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, manageLend.class);
                startActivity(intent);
            }
        });
        buttRental.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, manageRental.class);
                startActivity(intent);
            }
        });
        buttReview.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "구현하지 않았습니다.", Toast.LENGTH_SHORT).show();
            }
        });
    }


    public void onButtonReviewClicked(View V) {
    }
}
