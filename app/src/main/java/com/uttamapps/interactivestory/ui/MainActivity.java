package com.uttamapps.interactivestory.ui;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.uttamapps.interactivestory.R;


public class MainActivity extends ActionBarActivity {

    private EditText mNameField;
    private Button mStartButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mNameField = (EditText)findViewById(R.id.nameEditText); //creates link to text input
        mStartButton = (Button)findViewById(R.id.startButton ); //for start button

        //create anonymous class inside instead of creating a new listener object
        mStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //getText return editable text and toString then converts to string
                String name = mNameField.getText().toString();
                startStory(name);
            }
        });

    }

    //use name in method so it can be passed along from the onclicklistener
    private void startStory(String name){
        Intent intent = new Intent(this, StoryActivity.class);
        intent.putExtra(getString(R.string.key_name), name);
        startActivity(intent);

    }

    
    protected void onResume(){
        super.onResume();
        mNameField.setText("");
    }


}
