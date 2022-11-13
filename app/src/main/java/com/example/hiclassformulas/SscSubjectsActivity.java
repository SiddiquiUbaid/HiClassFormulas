package com.example.hiclassformulas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Toast;

import com.example.hiclassformulas.adapter.SubjectListAdapter;
import com.example.hiclassformulas.domain.SubjectData;

import java.util.ArrayList;


public class SscSubjectsActivity extends AppCompatActivity implements SubjectListAdapter.OnSubjectListener {
    RecyclerView subjectRecycler;
    ArrayList<String> listOfUid;
    Resources getString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ssc_subjects);

        getString = getApplicationContext().getResources();

        ArrayList<SubjectData> subjectList = new ArrayList<>();
        listOfUid = new ArrayList<>();

        Drawable dAglebra = getApplicationContext().getResources().getDrawable(R.drawable.algebra);
        Drawable dGeometry = getApplicationContext().getResources().getDrawable(R.drawable.geometry);
        Drawable dTrigonometry = getApplicationContext().getResources().getDrawable(R.drawable.trigonometry);
        Drawable dCalculus = getApplicationContext().getResources().getDrawable(R.drawable.calculus);
        Drawable dFavorites = getApplicationContext().getResources().getDrawable(R.drawable.favorite_bord);
        Drawable dTest = getApplicationContext().getResources().getDrawable(R.drawable.test_yourself);

        //SubjectData subject0 = new SubjectData(getString.getString(R.string.app_name), dAglebra);
        SubjectData subject1 = new SubjectData("Algebra", dAglebra);
        SubjectData subject2 = new SubjectData("Geometry", dGeometry);
        SubjectData subject3 = new SubjectData("Trigonometry", dTrigonometry);
        SubjectData subject4 = new SubjectData("Calculus", dCalculus);
        SubjectData subject5 = new SubjectData("Favorites", dFavorites);
        SubjectData subject6 = new SubjectData("Test Yourself", dTest);

        subjectList.add(subject1);
        subjectList.add(subject2);
        subjectList.add(subject3);
        subjectList.add(subject4);
        subjectList.add(subject5);
        subjectList.add(subject6);

        listOfUid.add("subject1");
        listOfUid.add("subject2");
        listOfUid.add("subject3");
        listOfUid.add("subject4");
        listOfUid.add("subject5");
        listOfUid.add("subject6");



        subjectRecycler=findViewById(R.id.subjectsRecycler);
        SubjectListAdapter subjectListAdapter=new SubjectListAdapter(getApplicationContext(),subjectList, listOfUid, this);
        subjectRecycler.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
        subjectRecycler.setAdapter(subjectListAdapter);
        subjectListAdapter.notifyDataSetChanged();



    }

    @Override
    public void onSubjectClick(int position) {

        buttonClickSound();

        Toast.makeText(getApplicationContext(), ""+listOfUid.get(position), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getApplicationContext(), ChaptersActivity.class);
        intent.putExtra("subject", ""+listOfUid.get(position));
        startActivity(intent);

    }

    public void buttonClickSound(){

        MediaPlayer player = MediaPlayer.create(SscSubjectsActivity.this, R.raw.water_bubble_sound_effect);
        player.start();

    }

}