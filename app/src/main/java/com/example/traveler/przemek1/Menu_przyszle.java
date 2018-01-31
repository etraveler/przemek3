package com.example.traveler.przemek1;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class Menu_przyszle extends AppCompatActivity implements View.OnClickListener{

    private TextView mTextMessage;

    int gdzie=0;
  //  Button btnlistabusow;
   // Button btndodajbusa;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText("Busy");
                    gdzie=1;

                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    gdzie=2;

                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText("Kalendarz");
                    gdzie=3;

                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_przyszle);

       // btnlistabusow = (Button) findViewById(R.id.btnlistabusow);
      //  btnlistabusow.setOnClickListener(this);
      //  btndodajbusa = (Button) findViewById(R.id.btndodajbusa);
       // btndodajbusa.setOnClickListener(this);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }

    @Override
    public void onClick(View view) {


    }
}
