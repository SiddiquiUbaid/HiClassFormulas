package com.example.hiclassformulas;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

import com.example.hiclassformulas.adapter.SubjectListAdapter;
import com.example.hiclassformulas.domain.SubjectData;

import java.util.ArrayList;
import java.util.List;

@RequiresApi(api = Build.VERSION_CODES.R)
public class ChaptersActivity extends AppCompatActivity implements SubjectListAdapter.OnSubjectListener {
    RecyclerView subjectRecycler;
    ArrayList<String> listOfUid;
    ArrayList<SubjectData> chapterList;
    String subject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapters);

        // initialize data
        initializeData();

        listOfUid = new ArrayList<>();
        Drawable dChapter = getApplicationContext().getResources().getDrawable(R.drawable.openbookpurple);

        //SSC MATH CHAPTERS
        SubjectData sscCh1 = new SubjectData("Ch1. Real Numbers", dChapter);
        SubjectData sscCh2 = new SubjectData("Ch2. Polynomials", dChapter);
        SubjectData sscCh3 = new SubjectData("Ch3. Pair of Linear Equations in Two Variables", dChapter);
        SubjectData sscCh4 = new SubjectData("Ch4. Quadratic Equations", dChapter);
        SubjectData sscCh5 = new SubjectData("Ch5. Arithmetic  Progression", dChapter);
        SubjectData sscCh6 = new SubjectData("Ch6.  Triangles", dChapter);
        SubjectData sscCh7 = new SubjectData("Ch7. Coordinate Geometry", dChapter);
        SubjectData sscCh8 = new SubjectData("Ch8. Introduction to Trigonometry", dChapter);
        SubjectData sscCh9 = new SubjectData("Ch9. Some Applications of Trigonometry", dChapter);
        SubjectData sscCh10 = new SubjectData("Ch10. Circles", dChapter);
        SubjectData sscCh11 = new SubjectData("Ch11. Constructions", dChapter);
        SubjectData sscCh12 = new SubjectData("Ch12. Area Related to Circles", dChapter);
        SubjectData sscCh13 = new SubjectData("Ch13. Surface Area and Volumes", dChapter);
        SubjectData sscCh14 = new SubjectData("Ch14. Statistics", dChapter);
        SubjectData sscCh15 = new SubjectData("Ch15. Probability", dChapter);



        ArrayList<SubjectData> sscAlgebra = new ArrayList<>();
        sscAlgebra.add(sscCh1);
        sscAlgebra.add(sscCh2);
        sscAlgebra.add(sscCh3);
        sscAlgebra.add(sscCh4);
        sscAlgebra.add(sscCh5);

        ArrayList<SubjectData> sscGeometry = new ArrayList<>();
        sscGeometry.add(sscCh6);
        sscGeometry.add(sscCh7);
        sscGeometry.add(sscCh10);
        sscGeometry.add(sscCh11);

        ArrayList<SubjectData> sscTrigonometry = new ArrayList<>();
        sscTrigonometry.add(sscCh8);
        sscTrigonometry.add(sscCh9);


        ArrayList<SubjectData> sscMensuration = new ArrayList<>();
        sscMensuration.add(sscCh12);
        sscMensuration.add(sscCh13);

        ArrayList<SubjectData> sscProbability = new ArrayList<>();
        sscProbability.add(sscCh14);
        sscProbability.add(sscCh15);

        // assign chapter list according to subject
        switch(subject){
            case "subject1":
                chapterList = sscAlgebra;
                break;

            case "subject2":
                chapterList = sscGeometry;
                break;

            case "subject3":
                chapterList = sscTrigonometry;
                break;

            case "subject4":
                chapterList = sscMensuration;
                break;

            case "subject5":
                chapterList = sscProbability;
                break;

            case "subject6":
                chapterList = sscAlgebra;
                break;

        }


        //set adapter with chapter list
        subjectRecycler=findViewById(R.id.chaptersRecycler);
        SubjectListAdapter subjectListAdapter=new SubjectListAdapter(getApplicationContext(),chapterList, listOfUid, this);
        subjectRecycler.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
        subjectRecycler.setAdapter(subjectListAdapter);
        subjectListAdapter.notifyDataSetChanged();








    }

    //method to initialize data
    public void initializeData(){
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if(bundle != null){
            subject = bundle.getString("subject");
        }
        else{
            subject = "nothing";
        }

    }

    // method to create uid list from subjectlist
    public ArrayList<String> getListOfUid(ArrayList<SubjectData> selectedSubject){
        for(int i = 0; i < selectedSubject.size(); i++ ){
            listOfUid.add(selectedSubject.get(i).getSubjectName());

        }
        return listOfUid;
    }


    @Override
    public void onSubjectClick(int position) {

        buttonClickSound();


        Toast.makeText(getApplicationContext(), ""+chapterList.get(position).getSubjectName(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getApplicationContext(), FormulaPalleteActivity.class);
        intent.putExtra("chapter", ""+chapterList.get(position).getSubjectName());
        startActivity(intent);

    }

    public void buttonClickSound(){

        MediaPlayer player = MediaPlayer.create(ChaptersActivity.this, R.raw.water_bubble_sound_effect);
        player.start();

    }

}