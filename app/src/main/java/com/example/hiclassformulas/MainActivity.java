package com.example.hiclassformulas;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {
    //TextView button10th, button12th;
    ImageView logoOnHome;
    MaterialButton mb10th, mb12th;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mb10th = findViewById(R.id.button10th);
        mb12th = findViewById(R.id.button12th);
        logoOnHome = findViewById(R.id.logoOnHome);

        // changing color of system bottom navigation bar
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            getWindow().setNavigationBarColor(getResources().getColor(R.color.light_pink));


        }





        ObjectAnimator animationSSC = ObjectAnimator.ofFloat(mb10th, "translationX", 700f);
        animationSSC.setDuration(2000);
        animationSSC.start();

        ObjectAnimator animationHSC = ObjectAnimator.ofFloat(mb12th, "translationX", -700f);
        animationHSC.setDuration(2000);
        animationHSC.start();


        // To add move animation
//        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move_animation);
//        button10th.startAnimation(animation);

        // To add move animation
        Animation logoOnHomeAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_animation);
        logoOnHome.startAnimation(logoOnHomeAnimation);



        mb10th.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                buttonClickSound();


                Intent intent = new Intent(getApplicationContext(), SscSubjectsActivity.class);
                startActivity(intent);
            }
        });


        mb12th.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                buttonClickSound();


//                Intent intent = new Intent(getApplicationContext(), SscSubjectsActivity.class);
//                startActivity(intent);
            }
        });







    }


    public void buttonClickSound(){

        MediaPlayer player = MediaPlayer.create(MainActivity.this, R.raw.button_click_sound);
        player.start();

    }




}