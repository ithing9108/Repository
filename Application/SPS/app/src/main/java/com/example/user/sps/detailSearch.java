package com.example.user.sps;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

public class detailSearch extends AppCompatActivity {

    AsyncHttpClient client;
    Httpresponse httpresponse;
    private final String test = "172.20.10.3/uml.php";
    RequestParams para = new RequestParams();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_search);

        client = new AsyncHttpClient();
        httpresponse = new Httpresponse(this);
        para.put("state", "request");

        Button buttRequest = (Button) findViewById(R.id.buttRequest);
        buttRequest.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent= new Intent(detailSearch.this, requestProduct.class);
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

    private class Httpresponse extends AsyncHttpResponseHandler {

        Activity activity;

        public Httpresponse(Activity activity) {
            this.activity = activity;
        }

        @Override
        public void onSuccess(String content) {

        }

        @Override
        public void onFailure(int statusCode, Throwable error, String content) {
            super.onFailure(statusCode, error, content);
            Toast.makeText(activity, "Please check your network", Toast.LENGTH_SHORT).show();
        }
    }
}
