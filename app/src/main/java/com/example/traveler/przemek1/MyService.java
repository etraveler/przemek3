package com.example.traveler.przemek1;

import android.content.Intent;
import android.app.Service;
import android.os.IBinder;
import android.widget.Toast;

import com.kosalgeek.asynctask.AsyncResponse;
import com.kosalgeek.asynctask.PostResponseAsyncTask;

import java.util.HashMap;


public class MyService extends Service implements AsyncResponse{



    @Override
    public void onTaskRemoved(Intent rootIntent) {




        System.out.println("onTaskRemoved called");
        super.onTaskRemoved(rootIntent);
        HashMap postData = new HashMap();
        String token = ((tokenGlobal) this.getApplication()).getSomeVariable();
        postData.put("txtToken", token);
        PostResponseAsyncTask task = new PostResponseAsyncTask(this, postData);
        task.execute("http://traveler95.nazwa.pl/jeden/client/logout.php");
        this.stopSelf();
    }
    @Override
    public void processFinish(String result) {

    }

    @Override
    public IBinder onBind(Intent arg0) {
        // TODO Auto-generated method stub
        return null;
    }
}