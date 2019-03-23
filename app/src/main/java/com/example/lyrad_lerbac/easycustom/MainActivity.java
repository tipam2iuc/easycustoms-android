package com.example.lyrad_lerbac.easycustom;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {


    BottomNavigationView navigationView;
    FrameLayout frameLayout;
    FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigationView = findViewById(R.id.buttum_tabs);
        frameLayout = findViewById(R.id.frame_content);

        if(savedInstanceState == null && frameLayout != null){
            if(fragmentManager == null)
                fragmentManager = getSupportFragmentManager();

            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.frame_content,new HomeFragment(),null);
            transaction.commit();
        }

        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if(frameLayout == null)
                    return false;

                if(fragmentManager == null)
                    fragmentManager = getSupportFragmentManager();

                FragmentTransaction transaction = fragmentManager.beginTransaction();
                switch (item.getItemId()){
                    case R.id.ic_home:
                        transaction.replace(R.id.frame_content,new HomeFragment(),null);
                        break;
                    case R.id.ic_notifications:
                        transaction.replace(R.id.frame_content,new NotificationsFragment(),null);
                        break;
                    case R.id.ic_search:
                        transaction.replace(R.id.frame_content,new SearchFragment(),null);
                        break;
                    case R.id.ic_settings:
                        transaction.replace(R.id.frame_content,new SettingsFragment(),null);
                        break;
                }

                transaction.commit();
                return true;
            }
        });

    }
}
