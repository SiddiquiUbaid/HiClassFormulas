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
import com.example.hiclassformulas.domain.SubjectData;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubjectListAdapter extends RecyclerView.Adapter<SubjectListAdapter.ViewHolder> {
    Context context;
    List<SubjectData> subjectList;
    ArrayList<String> listOfUid;




    private OnSubjectListener mOnSubjectListener;

    public SubjectListAdapter(Context applicationContext, List<SubjectData> subjectList,
                            ArrayList<String> listOfUid, OnSubjectListener OnSubjectListener) {
        this.context=applicationContext;
        this.subjectList=subjectList;
        this.listOfUid = listOfUid;
        this.mOnSubjectListener = OnSubjectListener;

    }

    @NonNull

    @Override
    public ViewHolder onCreateViewHolder(@NonNull   ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.single_subject_layout,parent,false);
        return new ViewHolder(view, mOnSubjectListener);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {
        holder.subjName.setText(subjectList.get(position).getSubjectName());

        //Glide.with(context).load(subjectList.get(position).getSubjectImage()).into(holder.subjImg);
        holder.subjImg.setImageDrawable(subjectList.get(position).getSubjectImage());

        holder.subjImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mOnSubjectListener.onSubjectClick(position);

            }
        });











    }


    @Override
    public int getItemCount() {
        return subjectList.size();

    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView subjImg;
        TextView subjName;
        OnSubjectListener onSubjectListener;

        public ViewHolder(@NonNull View itemView, OnSubjectListener mOnSubjectListener) {
            super(itemView);
            subjImg=itemView.findViewById(R.id.subjectsImage);
            subjName=itemView.findViewById(R.id.subjectsName);


        }

        @Override
        public void onClick(View view) {

            // invoking item click listener
//            onHotelListener.onWishListClick(getAdapterPosition());
//            onHotelListener.onHotelClick(getAdapterPosition());


        }


    }

    public interface OnSubjectListener{
        void onSubjectClick(int position);



    }
}
