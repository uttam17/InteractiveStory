package com.uttamapps.interactivestory.model;

/**
 * Created by uttam_000 on 7/14/2015.
 */
public class Page {
    private int mImageID;
    private String mText;
    private Choice mChoice1;
    private Choice mChoice2;
    private boolean mIsFinal = false;

    public boolean isFinal() {
        return mIsFinal;
    }

    public void setFinal(boolean isFinal) {
        mIsFinal = isFinal;
    }



    public Page(int imageID, String Text, Choice choice1, Choice choice2){

        mImageID = imageID;
        mText = Text;
        mChoice1 = choice1;
        mChoice2 = choice2;
    }

    public Page(int imageID, String text){
        mImageID = imageID;
        mText = text;
        mChoice1 = null;
        mChoice2 = null;
        mIsFinal = true;
    }

    public int getImageID() {
        return mImageID;
    }

    public void setImageID(int imageID) {
        mImageID = imageID;
    }

    public String getText() {
        return mText;
    }

    public void setText(String text) {
        mText = text;
    }

    public Choice getChoice1() {
        return mChoice1;
    }

    public void setChoice1(Choice choice1) {
        mChoice1 = choice1;
    }

    public Choice getChoice2() {
        return mChoice2;
    }

    public void setChoice2(Choice choice2) {
        mChoice2 = choice2;
    }
}
