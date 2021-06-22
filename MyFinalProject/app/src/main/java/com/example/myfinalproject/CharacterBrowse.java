package com.example.myfinalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class CharacterBrowse extends AppCompatActivity implements
        GestureDetector.OnDoubleTapListener,
        GestureDetector.OnGestureListener {

    private TextView nameText;
    private TextView classText;
    private TextView raceText;
    private TextView strengthText;
    private TextView dexterityText;
    private TextView constitutionText;
    private TextView intelligenceText;
    private TextView wisdomText;
    private TextView charismaText;

    //TASK: Create Object variables
    private NameGenerator userNames;
    private ClassGenerator userClasses;
    private RaceGenerator userRaces;

    private AbilityScoreGenerator strengthAS;
    private AbilityScoreGenerator dexterityAS;
    private AbilityScoreGenerator constitutionAS;
    private AbilityScoreGenerator intelligenceAS;
    private AbilityScoreGenerator wisdomAS;
    private AbilityScoreGenerator charismaAS;

    //TASK: Create GestureDetector variables
    private GestureDetector myGesture;

    //TASK: Create userNum variable
    private int userNumber;

    //TASK: Create count variable
    private int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_browse);

        //TASK: Define Intent variables and values received from Intent
        Intent inBrowse = getIntent();
        userNumber = inBrowse.getIntExtra("intTransfer",0);

        myGesture = new GestureDetector(this, this);
        myGesture.setOnDoubleTapListener(this);

        createTextViews();
        createObjects();
        fillArrays(userNumber);

        setInitialText();

        count = 0;
    }

    private void createTextViews() {
        //TASK: Define TextView variables
        nameText = (TextView) findViewById(R.id.nameText);
        classText = (TextView) findViewById(R.id.classText);
        raceText = (TextView) findViewById(R.id.raceText);

        strengthText = (TextView) findViewById(R.id.strengthText);
        dexterityText = (TextView) findViewById(R.id.dexterityText);
        constitutionText = (TextView) findViewById(R.id.constitutionText);
        intelligenceText = (TextView) findViewById(R.id.intelligenceText);
        wisdomText = (TextView) findViewById(R.id.wisdomText);
        charismaText = (TextView) findViewById(R.id.charismaText);
    }

    private void createObjects() {
        //TASK: Define Object variables
        userNames = new NameGenerator();
        userClasses = new ClassGenerator();
        userRaces = new RaceGenerator();

        strengthAS = new AbilityScoreGenerator();
        dexterityAS = new AbilityScoreGenerator();
        constitutionAS = new AbilityScoreGenerator();
        intelligenceAS = new AbilityScoreGenerator();
        wisdomAS = new AbilityScoreGenerator();
        charismaAS = new AbilityScoreGenerator();

        //TASK: Create and Define minimum and maximum name lengths
        int minName = 3;
        int maxName = 8;

        //TASK: Set the minimum and maximum name lengths for the NameGenerator object variable
        userNames.setMinNameLength(minName);
        userNames.setMaxNameLength(maxName);
    }

    private void fillArrays(int useNum) {
        //TASK: Fill Array with requested number of entries
        userNames.generateAllNames(useNum);
        userClasses.generateAllClasses(useNum);
        userRaces.generateAllRaces(useNum);

        strengthAS.generateAllAbilityScores(useNum);
        dexterityAS.generateAllAbilityScores(useNum);
        constitutionAS.generateAllAbilityScores(useNum);
        intelligenceAS.generateAllAbilityScores(useNum);
        wisdomAS.generateAllAbilityScores(useNum);
        charismaAS.generateAllAbilityScores(useNum);
    }

    private void setInitialText() {
        //TASK: Set initial character TextViews
        nameText.setText(userNames.getName(0));
        classText.setText(userClasses.getClassName(0));
        raceText.setText(userRaces.getRaceName(0));

        strengthText.setText("" + strengthAS.getAbilityScore(0));
        dexterityText.setText("" + dexterityAS.getAbilityScore(0));
        constitutionText.setText("" + constitutionAS.getAbilityScore(0));
        intelligenceText.setText("" + intelligenceAS.getAbilityScore(0));
        wisdomText.setText("" + wisdomAS.getAbilityScore(0));
        charismaText.setText("" + charismaAS.getAbilityScore(0));
    }

    private void setDesiredText(int desiredText) {
        //TASK: Set desired character TextViews
        nameText.setText(userNames.getName(desiredText));
        classText.setText(userClasses.getClassName(desiredText));
        raceText.setText(userRaces.getRaceName(desiredText));

        strengthText.setText("" + strengthAS.getAbilityScore(desiredText));
        dexterityText.setText("" + dexterityAS.getAbilityScore(desiredText));
        constitutionText.setText("" + constitutionAS.getAbilityScore(desiredText));
        intelligenceText.setText("" + intelligenceAS.getAbilityScore(desiredText));
        wisdomText.setText("" + wisdomAS.getAbilityScore(desiredText));
        charismaText.setText("" + charismaAS.getAbilityScore(desiredText));
    }

    public void goToMain(View view) {
        finish();
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        myGesture.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onDown(MotionEvent e) {

        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        return false;
    }



    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        if (count == userNumber - 1) {
            count = 0;
            setDesiredText(count);
        }
        else {
            count = count + 1;
            setDesiredText(count);
        }
        return false;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        return false;
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