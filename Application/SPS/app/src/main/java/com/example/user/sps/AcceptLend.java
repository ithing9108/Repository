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

public class AcceptLend extends AppCompatActivity {
    AsyncHttpClient client;
    Httpresponse httpresponse;
    private final String test = "172.20.10.3/uml.php";
    RequestParams para = new RequestParams();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accept_lend);

        client = new AsyncHttpClient();
        httpresponse = new Httpresponse(this);
        para.put("state", "approved");



        Button buttDeny = (Button) findViewById(R.id.buttDeny);
        buttDeny.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                ////////////////////디비에 접근해서 transactionSate 변경//////////////////
                Toast.makeText(getApplicationContext(), "요청을 거절하였습니다.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(AcceptLend.this, MainActivity.class);
                startActivity(intent);

            }
        });
        Button buttAccept = (Button) findViewById(R.id.buttAccept);
        buttAccept.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


                client.post(test,para, httpresponse);
                ////////////////////디비에 접근해서 transactionSate 변경//////////////////
                Toast.makeText(getApplicationContext(), "요청을 수락하였습니다.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(AcceptLend.this, MainActivity.class);
                startActivity(intent);
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
