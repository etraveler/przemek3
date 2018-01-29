package com.example.traveler.przemek1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.kosalgeek.asynctask.AsyncResponse;
import com.kosalgeek.asynctask.PostResponseAsyncTask;

import java.util.HashMap;
import java.util.UUID;

public class Logowanie extends AppCompatActivity implements AsyncResponse, View.OnClickListener {


    EditText etUsername, etPassword;
    Button btnLogin;
    Button btnCreate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logowanie);

        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(this);
        btnCreate = (Button) findViewById(R.id.btnCreate);
        btnCreate.setOnClickListener(this);
    }

    @Override
    public void processFinish(String result) {

        if (result.equals("Success")) {
            Toast.makeText(this, result , Toast.LENGTH_SHORT).show();
            Intent in = new Intent(this, Menu_ladne.class);
            startActivity(in);
        } else {
            Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnLogin:
                ((tokenGlobal) this.getApplication()).generateString();
                String token = ((tokenGlobal) this.getApplication()).getSomeVariable();
                HashMap postData = new HashMap();
                postData.put("mobile", "android");
                postData.put("txtUsername", etUsername.getText().toString());
                postData.put("txtPassword", etPassword.getText().toString());
                postData.put("txtToken", token);
                PostResponseAsyncTask task = new PostResponseAsyncTask(this, postData);
                task.execute("http://traveler95.nazwa.pl/jeden/client/login.php");
                break;

            case R.id.btnCreate:
                Intent in = new Intent(this, CreateAccount.class);
                startActivity(in);
                break;
        }
    }
}
