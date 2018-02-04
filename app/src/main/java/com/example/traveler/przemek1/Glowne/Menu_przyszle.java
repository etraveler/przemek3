package com.example.traveler.przemek1.Glowne;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.traveler.przemek1.R;
import com.example.traveler.przemek1.Nieposortowane.SearchFragment;


public class Menu_przyszle extends AppCompatActivity implements View.OnClickListener{

    private TextView mTextMessage;

    int gdzie=0;
  //  Button btnlistabusow;
   // Button btndodajbusa;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {



            Fragment selectedFragment = null;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText("Busy");
                    gdzie=1;

                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    gdzie=2;
                    selectedFragment = SearchFragment.newInstance();
               //     FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                //    transaction.replace(R.id.contentLayout, SearchFragment);
                //    transaction.commit();

                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText("Kalendarz");
                    gdzie=3;

                    return true;
                case R.id.navigation_search:
                    mTextMessage.setText("Kalendarz");
                    gdzie=4;

                    return true;
            }
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.contentLayout, selectedFragment);
            transaction.commit();

            return false;
        }
    };

    //FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
    //    transaction.replace(R.id.contentLayout, SearchFragment.newInstance());
    //    transaction.commit();


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
