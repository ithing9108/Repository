package com.example.user.sps;

import android.os.Handler;
import android.util.Log;

/**
 * Created by user on 2016-06-04.
 */
public class ServiceThread extends Thread{
    Handler handler;
    boolean isRun = true;
    int check = 0;
    String test = "http://172.20.10.3.php";
    String output[];
    String value[];
    URLConnector task;
    int i =0;
    String user = "sps1";

    public ServiceThread(Handler handler){
        this.handler = handler;
    }

    public void stopForever(){
        synchronized (this) {
            this.isRun = false;
        }
    }

    public void run(){
        //반복적으로 수행할 작업을 한다.
        while(isRun){

            task = new URLConnector(test);

            task.start();

            try{
                task.join();
            }
            catch(InterruptedException e){

            }

            String result = task.getResult();
            Log.d("ddd", result);
            output = result.split("\n");
            for(i=0; i<output.length;i++) {
                value = output[i].split(" ");
                if((value[0].equals(user)||(value[1].equals(user)))){
                    if((value[2].equals("request"))||(value[2].equals("approved"))){
                        handler.sendEmptyMessage(0);
                    }
                }
            }
            /*try{
                Thread.sleep(20000); //20초씩 쉰다.
            }catch (Exception e) {}*/
        }
    }
}