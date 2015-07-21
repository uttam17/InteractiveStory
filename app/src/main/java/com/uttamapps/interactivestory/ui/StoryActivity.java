package com.uttamapps.interactivestory.ui;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.uttamapps.interactivestory.R;
import com.uttamapps.interactivestory.model.Page;
import com.uttamapps.interactivestory.model.Story;


public class StoryActivity extends ActionBarActivity {



    public static final String TAG = StoryActivity.class.getSimpleName();


    private Story mStory = new Story();
    private ImageView mImageView;
    private Button mChoice1;
    private TextView mTextView;
    private Button mChoice2;
    private String mName;
    private Page mCurrentPage;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        Intent intent = getIntent();
        String mName = intent.getStringExtra(getString(R.string.key_name));


        if (mName==null){
            mName = "Friend";
        }

        Log.d(TAG, mName);

        mImageView = (ImageView) findViewById(R.id.storyImageView);
        mTextView = (TextView)findViewById(R.id.storyTextView);
        mChoice1 = (Button)findViewById(R.id.choiceButton1);
        mChoice2 = (Button)findViewById(R.id.choiceButton2);

        //load first page
        loadPage(0);


    }

    private void loadPage(int choice){
        mCurrentPage = mStory.getPage(choice);

        Drawable drawable = getResources().getDrawable(mCurrentPage.getImageID());
        mImageView.setImageDrawable(drawable);

        String pageText = mCurrentPage.getText();
        //Will add if placeholder included. Will not add if no placeholder
        pageText = String.format(pageText,mName);

        mTextView.setText(pageText);


        if (mCurrentPage.isFinal()){
            mChoice1.setVisibility(View.INVISIBLE);
            mChoice2.setText("PLAY AGAIN");
            mChoice2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }
        else{
            mChoice1.setText(mCurrentPage.getChoice1().getText());
            mChoice2.setText(mCurrentPage.getChoice2().getText());
        mChoice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int nextPage = mCurrentPage.getChoice1().getNextPage();
                loadPage(nextPage);
            }


        });
        mChoice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int nextPage =  mCurrentPage.getChoice2().getNextPage();
                loadPage(nextPage);
            }


        });
    }}

}
