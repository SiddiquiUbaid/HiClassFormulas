package com.example.hiclassformulas;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getSupportActionBar().hide();

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            getWindow().setNavigationBarColor(getResources().getColor(R.color.purple_smooth));


        }

       /*
        Thread thread = new Thread() {

            public void run(){

                try{
                    sleep(2000);
                }
                catch (Exception e){
                  e.printStackTrace();
                }
                finally {
                    Intent intent = new Intent(Splash.this, MainActivity.class);
                    Bundle b = ActivityOptions.makeSceneTransitionAnimation(Splash.this).toBundle();
                    startActivity(intent, b);
                    finish();
                }

            }



        };

        thread.start();

        */



        /* New Handler to start the Menu-Activity
         * and close this Splash-Screen after some seconds.*/
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                Intent mainIntent = new Intent(Splash.this,MainActivity.class);
                Bundle b = ActivityOptions.makeSceneTransitionAnimation(Splash.this).toBundle();
                Splash.this.startActivity(mainIntent, b);
                Splash.this.finish();
            }
        }, 2000);
    }







}