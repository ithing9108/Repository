package com.example.user.sps;


import android.util.Log;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by user on 2016-06-04.
 */
public class URLConnector extends Thread {

    private String result;
    private String URL;

    public URLConnector(String url){
        URL = url;
    }

    public void run(){
        final String output = request(URL);
        result = output;
    }
    public String getResult(){
        return result;
    }

    private String request(String urlStr){
        StringBuilder output = new StringBuilder();
        try{
            java.net.URL url = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            if(conn != null){
                conn.setConnectTimeout(10000);
                conn.setRequestMethod("GET");
                conn.setDoInput(true);
                conn.setDoOutput(true);

                int resCode = conn.getResponseCode();
                if(resCode == HttpURLConnection.HTTP_OK){
                    BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
                    String line = "";
                    String line_print = "";
                    while (true) {
                        line = reader.readLine();
                        //if(line.substring(0,4)=="<li>") {
                        //Log.d("ddd", line);
                        //}
                        if(line == null){
                            break;
                        }
                        output.append(line + "\n");}

                    //Log.d("ddd", line);
                    //}
                    reader.close();
                    conn.disconnect();
                }
            }
        }
        catch(Exception ex){
            Log.e("SampleHTTP", "Exception in URL part", ex);
            ex.printStackTrace();

        }
        return output.toString();
    }

}