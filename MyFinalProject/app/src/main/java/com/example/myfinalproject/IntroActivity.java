package com.example.myfinalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class IntroActivity extends AppCompatActivity {

    private boolean buttonOn = true;
    private boolean buttonOff = false;

    //TASK: Create Button variables
    private Button explainAppBtn;
    private Button explainClassBtn;
    private Button explainRaceBtn;
    private Button explainAbScoreBtn;
    private Button returnToAppBtn;

    //TASK: Create TextView variables
    private TextView explainTopicHeader;
    private TextView explainTopicText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        //TASK: Define Buttons
        explainAppBtn = (Button) findViewById(R.id.explainAppBtn);
        explainClassBtn = (Button) findViewById(R.id.explainClassBtn);
        explainRaceBtn = (Button) findViewById(R.id.explainRaceBtn);
        explainAbScoreBtn = (Button) findViewById(R.id.explainAbScoresBtn);
        returnToAppBtn = (Button) findViewById(R.id.returnToAppBtn);

        //TASK: Define TextViews
        explainTopicHeader = (TextView) findViewById(R.id.whatIsAppTextView);
        explainTopicText = (TextView) findViewById(R.id.appExplanationTextView);

        //TASK: Set the TextView variables' text to default values
        explainTopicHeader.setText(R.string.whatIsAppText);
        explainTopicText.setText(R.string.appExplanationText);

        //TASK: Set which Buttons are not active
        explainAppBtn.setEnabled(buttonOff);
    }

    public void explainApp(View view) {
        //TASK: Set which buttons are active
        explainAppBtn.setEnabled(buttonOff);
        explainClassBtn.setEnabled(buttonOn);
        explainRaceBtn.setEnabled(buttonOn);
        explainAbScoreBtn.setEnabled(buttonOn);
        returnToAppBtn.setEnabled(buttonOn);

        //TASK: Set the TextView variables' text to appropriate values
        explainTopicHeader.setText(R.string.whatIsAppText);
        explainTopicText.setText(R.string.appExplanationText);
    }

    public void explainClass(View view) {
        //TASK: Set which buttons are active
        explainAppBtn.setEnabled(buttonOn);
        explainClassBtn.setEnabled(buttonOff);
        explainRaceBtn.setEnabled(buttonOn);
        explainAbScoreBtn.setEnabled(buttonOn);
        returnToAppBtn.setEnabled(buttonOn);

        //TASK: Set the TextView variables' text to appropriate values
        explainTopicHeader.setText(R.string.whatIsClassText);
        explainTopicText.setText(R.string.explainClassText);
    }

    public void explainRace(View view) {
        //TASK: Set which buttons are active
        explainAppBtn.setEnabled(buttonOn);
        explainClassBtn.setEnabled(buttonOn);
        explainRaceBtn.setEnabled(buttonOff);
        explainAbScoreBtn.setEnabled(buttonOn);
        returnToAppBtn.setEnabled(buttonOn);

        //TASK: Set the TextView variables' text to appropriate values
        explainTopicHeader.setText(R.string.whatIsRaceText);
        explainTopicText.setText(R.string.explainRaceText);
    }

    public void explainAbScores(View view) {
        //TASK: Set which buttons are active
        explainAppBtn.setEnabled(buttonOn);
        explainClassBtn.setEnabled(buttonOn);
        explainRaceBtn.setEnabled(buttonOn);
        explainAbScoreBtn.setEnabled(buttonOff);
        returnToAppBtn.setEnabled(buttonOn);

        //TASK: Set the TextView variables' text to appropriate values
        explainTopicHeader.setText(R.string.whatIsAbScoresText);
        explainTopicText.setText(R.string.explainAbScoresText);
    }

    public void returnToApp(View view) {
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.myNameMenu) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}