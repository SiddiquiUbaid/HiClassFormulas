package com.example.hiclassformulas.domain;

import android.graphics.drawable.Drawable;

public class SubjectData {
    String subjectName;
    Drawable subjectImage;

    public SubjectData(String subjectName, Drawable subjectImage) {
        this.subjectName = subjectName;
        this.subjectImage = subjectImage;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Drawable getSubjectImage() {
        return subjectImage;
    }

    public void setSubjectImage(Drawable subjectImage) {
        this.subjectImage = subjectImage;
    }
}
