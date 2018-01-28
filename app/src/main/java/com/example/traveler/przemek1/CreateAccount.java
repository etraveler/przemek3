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

public class CreateAccount extends AppCompatActivity implements AsyncResponse, View.OnClickListener  {


    EditText createName, createUsername, createPassword;
    Button btnCreateaccount;
    Button btnBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createaccount);


        createName = (EditText) findViewById(R.id.createName);
        createUsername = (EditText) findViewById(R.id.createUsername);
        createPassword = (EditText) findViewById(R.id.createPassword);

        btnCreateaccount = (Button) findViewById(R.id.btnCreateaccount);
        btnCreateaccount.setOnClickListener(this);
        btnBack = (Button) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(this);

    }

    @Override
    public void processFinish(String result) {
        if (result.equals("success")) {
            Toast.makeText(this, "account created", Toast.LENGTH_LONG).show();
        }
    }


    @Override
    public void onClick(View v) {


        switch (v.getId()) {


            case R.id.btnCreateaccount:
                HashMap postData = new HashMap();
                postData.put("mobile2", "android2");
                postData.put("createName", createName.getText().toString());
                postData.put("createUsername", createUsername.getText().toString());
                postData.put("createPassword", createPassword.getText().toString());




                 //   String text = createName.getText().toString();
                int namedl = createName.getText().length();
                int logindl = createUsername.getText().length();
                int passdl = createPassword.getText().length();

                if (logindl<6 || passdl<6 || logindl>10 || passdl>10 ) {
                    if (namedl < 3 || namedl > 10) {
                        Toast.makeText(this, "Imię musi zawierać od 3 do 10 znaków. Login oraz hasło muszą zawierać od 6 do 10 znaków", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    Toast.makeText(this, "Login oraz hasło muszą zawierać od 6 do 10 znaków", Toast.LENGTH_SHORT).show();
                }
                else {
                    PostResponseAsyncTask task = new PostResponseAsyncTask(this, postData);
                    task.execute("http://traveler95.nazwa.pl/jeden/client/create.php");
                }
                break;

            case R.id.btnBack:
                Intent in = new Intent(this, Logowanie.class);
                startActivity(in);
                break;


        }
    }

}
