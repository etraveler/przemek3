package com.example.traveler.przemek1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.kosalgeek.asynctask.AsyncResponse;
import com.kosalgeek.asynctask.PostResponseAsyncTask;

import java.util.HashMap;

public class checkToken extends AppCompatActivity implements AsyncResponse {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_token);
        String token = ((tokenGlobal) this.getApplication()).getSomeVariable();
        HashMap postData = new HashMap();
        postData.put("txtToken", token);
        PostResponseAsyncTask task = new PostResponseAsyncTask(this, postData);
        task.execute("http://traveler95.nazwa.pl/jeden/client/tokenCheck.php");
        String token2 = ((tokenGlobal) this.getApplication()).getSomeVariable2();
        Toast.makeText(this, token2, Toast.LENGTH_LONG).show();
        // finish();
    }

    @Override
    public void processFinish(String result) {
        if (result == "success") {
            ((tokenGlobal) this.getApplication()).setSomeVariable2("1");
        } else {
            ((tokenGlobal) this.getApplication()).setSomeVariable2("0");
        }
    }
}