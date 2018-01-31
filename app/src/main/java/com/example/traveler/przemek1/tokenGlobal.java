package com.example.traveler.przemek1;

import android.app.Application;
import android.content.Intent;
import android.widget.Toast;

import com.kosalgeek.asynctask.AsyncResponse;
import com.kosalgeek.asynctask.PostResponseAsyncTask;

import java.util.HashMap;
import java.util.UUID;

/**
 * Created by Przemek on 28.01.2018.
 */

public class tokenGlobal extends Application implements AsyncResponse {

    private String someVariable;
    private String someVariable2;

    public String getSomeVariable() {

        return someVariable;
    }
    public String getSomeVariable2() {

        return someVariable2;
    }
    public void setSomeVariable(String someVariable) {

        this.someVariable = someVariable;

    }
    public void setSomeVariable2(String someVariable2) {

        this.someVariable2 = someVariable2;

    }
    public String generateString() {

        someVariable = UUID.randomUUID().toString();
        return someVariable;

    }
    public String generateString2() {

        someVariable2 = UUID.randomUUID().toString();
        return someVariable2;

    }
    @Override
    public void processFinish(String result) {
        //  Toast.makeText(this, result, Toast.LENGTH_LONG).show();
        // result2 = result;
    }
    public String Check()
    {
        HashMap postData = new HashMap();
        postData.put("txtToken", "kotek");
        PostResponseAsyncTask task = new PostResponseAsyncTask(this, postData);
        task.execute("http://traveler95.nazwa.pl/jeden/client/tokenCheck.php");
        return someVariable;
    }

}

