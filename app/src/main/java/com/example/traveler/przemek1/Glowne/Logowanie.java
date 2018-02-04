package com.example.traveler.przemek1.Glowne;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.traveler.przemek1.R;
import com.example.traveler.przemek1.Inne.tokenGlobal;
import com.kosalgeek.asynctask.AsyncResponse;
import com.kosalgeek.asynctask.PostResponseAsyncTask;

import java.util.HashMap;

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


        if (result.equals("0") || result.equals("1") || result.equals("2") || result.equals("3"))
        {
            Intent in = new Intent(this, Menu_ladne.class);
            startActivity(in);
            finish();
        }
        else
        {
            if (result.equals("failed"))
            {
                Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(this, "Nieznany błąd", Toast.LENGTH_SHORT).show();
            }
        }

    }


    @Override
    public void onClick(View v) {





        switch (v.getId()) {
            case R.id.btnLogin:
                ((tokenGlobal) this.getApplication()).generateString();
                String token = ((tokenGlobal) this.getApplication()).getSomeVariable();
                HashMap postData = new HashMap();
                postData.put("txtUsername", etUsername.getText().toString());
                postData.put("txtPassword", etPassword.getText().toString());
                postData.put("txtToken", token);
                PostResponseAsyncTask task = new PostResponseAsyncTask(this, postData);
                task.execute("http://traveler95.nazwa.pl/jeden/client/login.php");
                break;

            case R.id.btnCreate:
                int namedl = etUsername.getText().length();
                int passdl = etPassword.getText().length();


                if (namedl==8 && passdl==1)
                {
                    Intent in1 = new Intent(this, Menu_robocze.class);
                    startActivity(in1);
                }
                else
                {
                    Intent in2 = new Intent(this, CreateAccount.class);
                    startActivity(in2);
                }
                break;
        }
    }
}
