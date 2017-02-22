package com.example.user.sps;

import android.os.AsyncTask;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
/**
 * Created by user on 2016-06-06.
 */
public class URLOutput extends AsyncTask<String, Void, Void> {
    @Override
    public Void doInBackground(String... params) {
        try {
            String url = "http://172.20.10.3/set.php";
            URL obj = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) obj.openConnection();

            conn.setReadTimeout(10000);
            conn.setConnectTimeout(15000);
            conn.setRequestMethod("POST");
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.setRequestProperty("Content-Type", "application/json");

            byte[] outputInBytes = params[0].getBytes("UTF-8");
            OutputStream os = conn.getOutputStream();
            os.write(outputInBytes);
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
