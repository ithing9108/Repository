package com.example.user.sps;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import java.io.File;

public class register extends AppCompatActivity {
    private static ImageView img;
    private static final int PICK_FROM_CAMERA = 0;
    private static final int PICK_FROM_ALBUM = 1;
    private static final int CROP_FROM_CAMERA = 2;

    private Uri mImageCaptureUri;
    private ImageView mPhotoImageView;
    private Button mButton;
    AsyncHttpClient client;
    Httpresponse httpresponse;
    private final String s ="http://172.20.10.3/uml.php";

    private EditText n;
    private Spinner c;
    private EditText cl;
    private TextView d;
    private EditText p;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        mPhotoImageView = (ImageView) findViewById(R.id.imageView);
        client = new AsyncHttpClient();
        httpresponse=new Httpresponse(this);

        n = (EditText)findViewById(R.id.editText11);
        c = (Spinner) findViewById(R.id.editText12);
        cl = (EditText)findViewById(R.id.editText13);
        d = (TextView)findViewById(R.id.editText14);
        p = (EditText)findViewById(R.id.editText15);

        d.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                showDialog(1);
            }
        });

        ArrayAdapter adapter = ArrayAdapter.createFromResource(
                this, R.array.category, R.layout.support_simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        c.setAdapter(adapter);

        // Spinner 동작처리
        c.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                String str = (String)parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });

        mPhotoImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    DialogInterface.OnClickListener cameraListener = new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialog, int which)
                        {
                            doTakePhotoAction();
                        }
                    };

                    DialogInterface.OnClickListener albumListener = new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialog, int which)
                        {
                            doTakeAlbumAction();
                        }
                    };

                    DialogInterface.OnClickListener cancelListener = new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialog, int which)
                        {
                            dialog.dismiss();
                        }
                    };

                    new AlertDialog.Builder(register.this)
                            .setTitle("Select the image to upload")
                            .setPositiveButton("Take picture", cameraListener)
                            .setNeutralButton("Choose album", albumListener)
                            .setNegativeButton("Cancel", cancelListener)
                            .show();
                }
        });

        Button buttBack = (Button) findViewById(R.id.buttBack);
        buttBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });
        Button buttComplete = (Button) findViewById(R.id.buttComplete);
        buttComplete.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                RequestParams params = new RequestParams();
                String ns = n.getText().toString();
                String cs = c.getSelectedItem().toString();
                String cls = cl.getText().toString();
                String ds = d.getText().toString();
                String ps = p.getText().toString();
//                params.put("img",new String(""));
                params.put("name",ns);
                params.put("category",cs);
                params.put("classification",cls);
                params.put("date", ds);
                params.put("price", ps);

                ////////////////////////////////////////////////////////////
                Intent intent = new Intent(register.this, MyService.class);
                startService(intent);
                //params.put("state", "request");
///// 추가되는 변수들 추가
                client.post(s, params, httpresponse);
            }
        });




    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if(resultCode != RESULT_OK)
        {
            return;
        }

        switch(requestCode)
        {
            case CROP_FROM_CAMERA:
            {

                final Bundle extras = data.getExtras();

                if(extras != null)
                {
                    Bitmap photo = extras.getParcelable("data");
                    int w = mPhotoImageView.getWidth();
                    int h = mPhotoImageView.getHeight();
                    int wp = photo.getWidth();
                    int hp = photo.getHeight();

                    Bitmap resizePhoto = Bitmap.createScaledBitmap(photo, w,h, true);
                    mPhotoImageView.setImageBitmap(resizePhoto);

                }

                // 임시 파일 삭제
                File f = new File(mImageCaptureUri.getPath());
                if(f.exists())
                {
                    String ns = n.getText().toString();
                    String cs = c.getSelectedItem().toString();
                    String cls = cl.getText().toString();
                    String ds = d.getText().toString();
                    String ps = p.getText().toString();
                    //사진 불러오는 곳
                    String url = ns+"/"+cs+"/"+cls+"/"+ds+"/"+ps+".jpg";
                    File fileNow = new File(Environment.getExternalStorageDirectory().getAbsolutePath() +"", url );
                    f.renameTo(fileNow);
//                    f.delete();
                }

                break;
            }

            case PICK_FROM_ALBUM:
            {

                mImageCaptureUri = data.getData();
            }

            case PICK_FROM_CAMERA:
            {


                Intent intent = new Intent("com.android.camera.action.CROP");
                intent.setDataAndType(mImageCaptureUri, "image/*");

                intent.putExtra("outputX",300);
                intent.putExtra("outputY",300);
                intent.putExtra("aspectX", 1);
                intent.putExtra("aspectY", 1);
                intent.putExtra("scale", true);
                intent.putExtra("return-data", true);
                startActivityForResult(intent, CROP_FROM_CAMERA);

                break;
            }
        }
    }
    private void doTakePhotoAction()
    {


        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        // 임시로 사용할 파일의 경로를 생성
        String url = "tmp_" + String.valueOf(System.currentTimeMillis()) + ".jpg";
        mImageCaptureUri = Uri.fromFile(new File(Environment.getExternalStorageDirectory(), url));

        intent.putExtra(android.provider.MediaStore.EXTRA_OUTPUT, mImageCaptureUri);
        //intent.putExtra("return-data", true);
        startActivityForResult(intent, PICK_FROM_CAMERA);
    }

    private void doTakeAlbumAction()
    {
        // 앨범 호출
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType(android.provider.MediaStore.Images.Media.CONTENT_TYPE);
        startActivityForResult(intent, PICK_FROM_ALBUM);
    }
    private class Httpresponse extends AsyncHttpResponseHandler {

        Activity activity;

        public Httpresponse(Activity activity) {
            this.activity=activity;
        }

        @Override
        public void onSuccess(String content) {
            Log.d("Result", content);
            Toast.makeText(getApplicationContext(), "Success to register", Toast.LENGTH_SHORT).show();

            String resNames = "";

            String res[] = content.split("\n");

            resNames = res[res.length-1];

            Log.d("Result",resNames);

           Intent intent=new Intent(register.this,manageLend.class);
            startActivity(intent);
        }

        @Override
        public void onFailure(int statusCode, Throwable error, String content) {
            Toast.makeText(getApplicationContext(), "Failed to register", Toast.LENGTH_SHORT).show();

        }
    }
    @Override
    @Deprecated
    protected Dialog onCreateDialog(int id) {
        switch(id){
            case 1 :
                DatePickerDialog dpd = new DatePickerDialog
                        (register.this, // 현재화면의 제어권자
                                new DatePickerDialog.OnDateSetListener() {
                                    public void onDateSet(DatePicker view,
                                                          int year, int monthOfYear,int dayOfMonth) {
                                        Toast.makeText(getApplicationContext(),
                                                dayOfMonth+","+monthOfYear+","+year+" was selected.",
                                                Toast.LENGTH_SHORT).show();
                                        String resDate = ""+year+monthOfYear+dayOfMonth;
                                        d.setText(resDate);
                                    }
                                }
                                , // 사용자가 날짜설정 후 다이얼로그 빠져나올때
                                //    호출할 리스너 등록
                                2016, 1, 1); // 기본값 연월일
                return dpd;
        }


        return super.onCreateDialog(id);
    }
}

