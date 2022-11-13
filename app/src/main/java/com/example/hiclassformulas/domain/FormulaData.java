package com.example.hiclassformulas.domain;

public class FormulaData {

    CharSequence title;
    CharSequence formula;
    CharSequence explanation;


    public FormulaData(CharSequence title, CharSequence formula, CharSequence explanation) {
        this.title = title;
        this.formula = formula;
        this.explanation = explanation;
    }


    public CharSequence getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public CharSequence getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }


    public CharSequence getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }


}
