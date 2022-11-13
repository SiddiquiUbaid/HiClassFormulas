package com.example.hiclassformulas.adapter;



import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.example.hiclassformulas.ChaptersActivity;
import com.example.hiclassformulas.R;
import com.example.hiclassformulas.domain.FormulaData;
import com.example.hiclassformulas.domain.SubjectData;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FormulaPalletAdapter extends RecyclerView.Adapter<FormulaPalletAdapter.ViewHolder> {
    Context context;
    List<FormulaData> formulaList;
    ArrayList<String> listOfUid;




    private OnFormulaListener mOnFormulaListener;

    public FormulaPalletAdapter(Context applicationContext, List<FormulaData> formulaList,
                              ArrayList<String> listOfUid, OnFormulaListener mOnFormulaListener) {
        this.context=applicationContext;
        this.formulaList=formulaList;
        this.listOfUid = listOfUid;
        this.mOnFormulaListener = mOnFormulaListener;

    }

    @NonNull

    @Override
    public ViewHolder onCreateViewHolder(@NonNull   ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.single_formula_item_layout,parent,false);
        return new ViewHolder(view, mOnFormulaListener);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {
        holder.title.setText(formulaList.get(position).getTitle());

        //Glide.with(context).load(subjectList.get(position).getSubjectImage()).into(holder.subjImg);
        holder.formula.setText(formulaList.get(position).getFormula());

        holder.formula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mOnFormulaListener.onFormulaClick(position);

            }
        });











    }


    @Override
    public int getItemCount() {
        return formulaList.size();

    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView title;
        TextView formula;
        OnFormulaListener onFormulaListener;

        public ViewHolder(@NonNull View itemView, OnFormulaListener mOnFormulaListener) {
            super(itemView);
            formula=itemView.findViewById(R.id.formulaText);
            title=itemView.findViewById(R.id.formulaTitle);


        }

        @Override
        public void onClick(View view) {

            // invoking item click listener
//            onHotelListener.onWishListClick(getAdapterPosition());
//            onHotelListener.onHotelClick(getAdapterPosition());


        }


    }

    public interface OnFormulaListener{
        void onFormulaClick(int position);



    }
}
