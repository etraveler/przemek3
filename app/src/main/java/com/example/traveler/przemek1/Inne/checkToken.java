package com.example.traveler.przemek1.Inne;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.traveler.przemek1.Glowne.Logowanie;
import com.example.traveler.przemek1.R;
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

        finish();
    }

    @Override
    public void processFinish(String result) {

        if (result.equals("success")) {

        }
        else
        {
            Toast.makeText(this, "hahaha Miłosz słabiak xd", Toast.LENGTH_SHORT).show();
            Intent in = new Intent(this, Logowanie.class);
            startActivity(in);
        }
    }

}

