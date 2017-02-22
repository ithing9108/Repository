package com.example.user.sps;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
public class detailLend extends AppCompatActivity {
    private Product pro;
    private TextView textView1,textView2,textView3,textView4,textView5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_lend);
        Intent getIntent=getIntent();
        pro=(Product)getIntent.getSerializableExtra("product");

        textView1=(TextView)findViewById(R.id.editText11);
        textView2=(TextView)findViewById(R.id.editText16);
        textView3=(TextView)findViewById(R.id.editText17);
        textView4=(TextView)findViewById(R.id.editText18);
        textView5=(TextView)findViewById(R.id.editText19);

        Log.d("ddd",pro.date);
        textView1.setText(pro.state);
        textView2.setText(pro.date);
        textView3.setText(pro.price);
        textView4.setText(pro.loanee);
        textView5.setText(pro.pw);


        Button buttDelete = (Button) findViewById(R.id.buttDelete);
        buttDelete.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                /////////////// 삭제버튼 누르면 상태확인 후 디비 접근 해서 목록 삭제//////////////

                Toast.makeText(getApplicationContext(), "삭제되었습니다.", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        Button buttComplete = (Button) findViewById(R.id.buttComplete);


        buttComplete.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                /////////////////  디비에서 transaction state 변경///////////////////
                Intent intent = new Intent(detailLend.this, MyService.class);
                startService(intent);
                Toast.makeText(getApplicationContext(),"거래가 승인되었습니다.",Toast.LENGTH_SHORT).show();
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
