package com.example.hiclassformulas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Toast;

import com.example.hiclassformulas.adapter.FormulaPalletAdapter;
import com.example.hiclassformulas.adapter.SubjectListAdapter;
import com.example.hiclassformulas.domain.FormulaData;
import com.example.hiclassformulas.domain.SubjectData;

import java.util.ArrayList;

public class FormulaPalleteActivity extends AppCompatActivity implements FormulaPalletAdapter.OnFormulaListener {
    RecyclerView formulaPalletRecycler;
    ArrayList<String> listOfUid;

    ArrayList<FormulaData> formulaList;

    ArrayList<FormulaData> formulasSccCh1, formulasSccCh2, formulasSccCh3, formulasSccCh4, formulasSccCh5,
    formulasSccCh6, formulasSccCh7, formulasSccCh8, formulasSccCh9, formulasSccCh110, formulasSccCh11,
            formulasSccCh12, formulasSccCh13, formulasSccCh14, formulasSccCh15;

    String chapter;
    Resources getString;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formula_pallete);

        initializeData();

        getString = getApplicationContext().getResources();

        formulaList = new ArrayList<>();
        listOfUid = new ArrayList<>();


        // creating formulas for ssc ch1
        formulasSccCh1 = new ArrayList<>();
        FormulaData naturalNumber = new FormulaData(getString.getText(R.string.t_natural_numbers),
                getString.getText(R.string.f_natural_numbers),
                getString.getText(R.string.e_natural_numbers) );

        FormulaData wholeNumbers = new FormulaData(getString.getText(R.string.t_whole_numbers),
                getString.getText(R.string.f_whole_numbers),
                getString.getText(R.string.e_whole_numbers) );

        FormulaData integers = new FormulaData(getString.getText(R.string.t_integers),
                getString.getText(R.string.f_integers),
                getString.getText(R.string.e_integers) );

        FormulaData positiveIntegers = new FormulaData(getString.getText(R.string.t_positive_integers),
                getString.getText(R.string.f_positive_integers),
                getString.getText(R.string.e_positive_integers) );

        FormulaData negativeIntegers = new FormulaData(getString.getText(R.string.t_negative_integers),
                getString.getText(R.string.f_negative_integers),
                getString.getText(R.string.e_negative_integers) );

        FormulaData rationalNumbers = new FormulaData(getString.getText(R.string.t_rational_number),
                getString.getText(R.string.f_rational_number),
                getString.getText(R.string.e_rational_number) );

        FormulaData irrationalNumbers = new FormulaData(getString.getText(R.string.t_irrational_number),
                getString.getText(R.string.f_irrational_number),
                getString.getText(R.string.e_irrational_number) );

        FormulaData realNumbers = new FormulaData(getString.getText(R.string.t_real_numbers),
                getString.getText(R.string.f_real_numbers),
                getString.getText(R.string.e_real_numbers) );

        FormulaData euclidsDivisionLemma = new FormulaData(getString.getText(R.string.t_euclids_division_lemma),
                getString.getText(R.string.f_euclids_division_lemma),
                getString.getText(R.string.e_euclids_division_lemma) );

        FormulaData hcf = new FormulaData(getString.getText(R.string.t_hcf),
                getString.getText(R.string.f_hcf),
                getString.getText(R.string.e_hcf) );

        FormulaData hcfCoprimes = new FormulaData(getString.getText(R.string.t_hcf_coprimes),
                getString.getText(R.string.f_hcf_coprimes),
                getString.getText(R.string.e_hcf_coprimes) );

        FormulaData fundTheoremOfArithmetic = new FormulaData(getString.getText(R.string.t_fund_theo_of_arithmetic),
                getString.getText(R.string.f_fund_theo_of_arithmetic),
                getString.getText(R.string.e_fund_theo_of_arithmetic) );

        FormulaData impFormulaRealNumbers = new FormulaData(getString.getText(R.string.t_realnumbers_imp_formula),
                getString.getText(R.string.f_realnumbers_imp_formula),
                getString.getText(R.string.e_realnumbers_imp_formula) );

        FormulaData impConceptRationalNumber = new FormulaData(getString.getText(R.string.t_imp_concept_rational_number),
                getString.getText(R.string.f_imp_concept_rational_number),
                getString.getText(R.string.e_imp_concept_rational_number) );

        /* ssc chapter1 formula ends*/



        // adding formulas in ssc chapter1 starts
        formulasSccCh1.add(naturalNumber);
        formulasSccCh1.add(wholeNumbers);
        formulasSccCh1.add(integers);
        formulasSccCh1.add(positiveIntegers);
        formulasSccCh1.add(negativeIntegers);
        formulasSccCh1.add(rationalNumbers);
        formulasSccCh1.add(irrationalNumbers);
        formulasSccCh1.add(realNumbers);
        formulasSccCh1.add(euclidsDivisionLemma);
        formulasSccCh1.add(hcf);
        formulasSccCh1.add(hcfCoprimes);
        formulasSccCh1.add(fundTheoremOfArithmetic);
        formulasSccCh1.add(impFormulaRealNumbers);
        formulasSccCh1.add(impConceptRationalNumber);
        // adding formulas in ssc chapter1 ends








        // assign formulas list according to chapters
        switch(chapter){
            case "Ch1. Real Numbers":
                formulaList = formulasSccCh1;
                break;

            case "Ch2. Polynomials":
                formulaList = formulasSccCh2;
                break;

            case "Ch3. Pair of Linear Equations in Two Variables":
                formulaList = formulasSccCh3;
                break;

            case "Ch4. Quadratic Equations":
                formulaList = formulasSccCh4;
                break;

            case "Ch5. Arithmetic  Progression":
                formulaList = formulasSccCh5;
                break;

            case "Ch6.  Triangles":
                formulaList = formulasSccCh6;
                break;

        }








        formulaPalletRecycler=findViewById(R.id.formulaPalleteRecycler);
        FormulaPalletAdapter formulaListAdapter=new FormulaPalletAdapter(getApplicationContext(),formulaList, listOfUid, this);
        formulaPalletRecycler.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        formulaPalletRecycler.setAdapter(formulaListAdapter);
        formulaListAdapter.notifyDataSetChanged();





    }



    //method to initialize data
    public void initializeData(){
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if(bundle != null){
            chapter = bundle.getString("chapter");
        }
        else{
            chapter = "nothing";
        }

    }




    @Override
    public void onFormulaClick(int position) {

        buttonClickSound();


        Toast.makeText(getApplicationContext(), ""+formulaList.get(position).getExplanation(),
                Toast.LENGTH_SHORT).show();

    }


    public void buttonClickSound(){

        MediaPlayer player = MediaPlayer.create(FormulaPalleteActivity.this, R.raw.egg_burst_sound_effect);
        player.start();

    }


}