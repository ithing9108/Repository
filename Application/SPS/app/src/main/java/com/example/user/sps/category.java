package com.example.user.sps;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

public class category extends AppCompatActivity implements View.OnClickListener {

    AsyncHttpClient client;
    HttpResponse httpResponse;
    private final String s5 = "172.20.10.3/uml5.php";
    String response;
    RequestParams params;
    String category,id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        client=new AsyncHttpClient();
        httpResponse=new HttpResponse();
        params = new RequestParams();

        Button buttBook = (Button) findViewById(R.id.buttBook);
        buttBook.setOnClickListener(this);
        Button buttElec = (Button) findViewById(R.id.buttElec);
        buttElec.setOnClickListener(this);
        Button buttFurni = (Button) findViewById(R.id.buttFurni);
        buttFurni.setOnClickListener(this);
        Button buttLeisure = (Button) findViewById(R.id.buttLeisure);
        buttLeisure.setOnClickListener(this);


        Button buttBack = (Button) findViewById(R.id.buttBack);
        buttBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttBook:
                params.put(category, "Book");
                client.post(s5, params, httpResponse);
                break;
            case R.id.buttElec:
                params.put(category, "Appliance");
                client.post(s5, params, httpResponse);
                break;
            case R.id.buttFurni:
                params.put(category, "Furniture");
                client.post(s5, params, httpResponse);
                break;
            case R.id.buttLeisure:
                params.put(category, "Leisure");
                client.post(s5, params, httpResponse);
                break;

        }
    }

    private class HttpResponse extends AsyncHttpResponseHandler{
        @Override
        public void onSuccess(String content) {
            Log.d("dddd",content);
            response=content;
            Intent intent = new Intent(category.this, SearchList.class);
            intent.putExtra("response",response);
            startActivity(intent);
        }
    }
}
