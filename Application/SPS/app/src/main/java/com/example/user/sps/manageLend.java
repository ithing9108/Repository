package com.example.user.sps;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

public class manageLend extends AppCompatActivity implements View.OnClickListener {
      private static int REGISTER_ACTION = 100;
    AsyncHttpClient client, client2,client3;
    Httpresponse httpresponse;
    Httpresponse2 httpresponse2;
    Httpresponse3 httpresponse3;
    private final String s = "http://172.20.10.3/uml3.php"; // 변경
    private final String s2 = "http://172.20.10.3/uml2.php";
    private final String s3 = "http://172.20.10.3/uml4.php";

    Button[] buttPd = new Button[5];
    TextView[] textViews =new TextView[5];
    String[] result = {};
    String[] result2 = {};
    String[] result3 = {};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_lend);

        client = new AsyncHttpClient();
        client2 = new AsyncHttpClient();
        client3 = new AsyncHttpClient();
        httpresponse = new Httpresponse(this);
        httpresponse2 = new Httpresponse2(this);
        httpresponse3 = new Httpresponse3(this);
        RequestParams para = new RequestParams();
        para.put("id", "sps1");

        client2.post(s2, para, httpresponse2);
        client3.post(s3, para, httpresponse3);
        buttPd[0] = (Button) findViewById(R.id.buttPd1);
        buttPd[0].setOnClickListener(this);
        buttPd[1] = (Button) findViewById(R.id.buttPd2);
        buttPd[1].setOnClickListener(this);
        buttPd[2] = (Button) findViewById(R.id.buttPd3);
        buttPd[2].setOnClickListener(this);
        buttPd[3] = (Button) findViewById(R.id.buttPd4);
        buttPd[3].setOnClickListener(this);
        buttPd[4] = (Button) findViewById(R.id.buttPd5);
        buttPd[4].setOnClickListener(this);

        textViews[0] = (TextView) findViewById(R.id.editText);
        textViews[1] = (TextView) findViewById(R.id.editText2);
        textViews[2] = (TextView) findViewById(R.id.editText3);
        textViews[3] = (TextView) findViewById(R.id.editText4);
        textViews[4] = (TextView) findViewById(R.id.editText5);

        Button buttRegister = (Button) findViewById(R.id.buttRegister);
        buttRegister.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(manageLend.this, register.class);
                startActivityForResult(intent, REGISTER_ACTION);
            }
        });

        Button buttBack = (Button) findViewById(R.id.buttBack);
        buttBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void onClick(View v) {

        RequestParams params = new RequestParams();

        switch (v.getId()) {
            case R.id.buttPd1:
                params.put("name", buttPd[0].getText().toString().trim());
                client.post(s, params, httpresponse);
                break;
            case R.id.buttPd2:
                params.put("name", buttPd[1].getText().toString().trim());
                client.post(s, params, httpresponse);
                break;
            case R.id.buttPd3:
                params.put("name", buttPd[2].getText().toString().trim());
                client.post(s, params, httpresponse);
                break;
            case R.id.buttPd4:
                params.put("name", buttPd[3].getText().toString().trim());
                client.post(s, params, httpresponse);
                break;
            case R.id.buttPd5:
                params.put("name", buttPd[4].getText().toString().trim());
                client.post(s, params, httpresponse);
                break;
        }
    }

    private class Httpresponse extends AsyncHttpResponseHandler {

        Activity activity;

        public Httpresponse(Activity activity) {
            this.activity = activity;
        }

        @Override
        public void onSuccess(String content) {
            Log.d("Result", content);
            result = content.split("/");
            System.out.print("~~~~~~"+result);
            String state = result[0];
            String date = result[1];
            String price = result[2];
            String loanee = result[3];
            String pw = result[4];
            Product product =new Product(state,date,price,loanee,pw);
            Intent intent=new Intent(manageLend.this,detailLend.class);
           intent.putExtra("product",product);
            startActivity(intent);
        }

        @Override
        public void onFailure(int statusCode, Throwable error, String content) {
            super.onFailure(statusCode, error, content);
            Toast.makeText(activity, "Please check your network", Toast.LENGTH_SHORT).show();
        }
    }



    private class Httpresponse2 extends AsyncHttpResponseHandler{
        Activity activity;
        String a ="";
        public Httpresponse2(Activity activity) {
            this.activity = activity;
        }
        @Override
        public void onSuccess(String content) {
            System.out.print("!!!!" + content);
            result2=content.split("/");
            int length=result2.length;
            for(int i=0;i<length;i++){
                buttPd[i].setText(result2[i]);
            }
        }

        @Override
        public void onFailure(int statusCode, Throwable error, String content) {

        }
    }

    private class Httpresponse3 extends AsyncHttpResponseHandler{
        Activity activity;
        public Httpresponse3(Activity activity) {
            this.activity = activity;
        }
        @Override
        public void onSuccess(String content) {
            System.out.print("!!!!"+content);
            result3=content.split("/");
           textViews[0].setText(result3[0]);
            //textViews[1].setText(result3[1]);
            //textViews[2].setText(result3[2]);
            //textViews[3].setText(result3[3]);
            //buttPd[4].setText(result2[4]);
        }

        @Override
        public void onFailure(int statusCode, Throwable error, String content) {
        }
    }
}
