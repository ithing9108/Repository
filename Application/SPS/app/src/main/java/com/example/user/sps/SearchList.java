package com.example.user.sps;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

public class SearchList extends AppCompatActivity {
    AsyncHttpClient client;
    HttpResponse httpResponse;
    Button buttPd1;
    private final String s5 = "http://172.20.10.3/uml5.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_list);
        String response2;
        Intent intent=getIntent();
        response2=intent.getStringExtra("response");
        //client.post(s5,params,httpResponse);

        buttPd1 = (Button) findViewById(R.id.buttPd1);
        buttPd1.setText(response2);

        buttPd1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(SearchList.this, requestProduct.class);
                startActivity(intent);
            }
        });
        Button buttPd2 = (Button) findViewById(R.id.buttPd2);

        buttPd2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(SearchList.this, requestProduct.class);
                startActivity(intent);
            }
        });
        Button buttPd3 = (Button) findViewById(R.id.buttPd3);
        buttPd3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(SearchList.this, requestProduct.class);
                startActivity(intent);
            }
        });
        Button buttPd4 = (Button) findViewById(R.id.buttPd4);
        buttPd4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(SearchList.this, requestProduct.class);
                startActivity(intent);
            }
        });
        Button buttPd5 = (Button) findViewById(R.id.buttPd5);
        buttPd5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(SearchList.this, requestProduct.class);
                startActivity(intent);
            }
        });
        Button buttPd6 = (Button) findViewById(R.id.buttPd6);
        buttPd6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(SearchList.this, requestProduct.class);
                startActivity(intent);
            }
        });
        Button buttPd7 = (Button) findViewById(R.id.buttPd7);
        buttPd7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(SearchList.this, requestProduct.class);
                startActivity(intent);
            }
        });

        Button buttBack = (Button) findViewById(R.id.buttBack);
        buttBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });

    }

    private class HttpResponse extends AsyncHttpResponseHandler {
        @Override
        public void onSuccess(String content) {
           buttPd1.setText(content);
        }

        @Override
        public void onFailure(int statusCode, Throwable error, String content) {
            super.onFailure(statusCode, error, content);
        }
    }
}
