package com.example.myfinalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.SoundPool;
import android.net.Uri;
import android.os.Bundle;
import android.util.SparseIntArray;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //TASK: Create TextView variables
    private TextView userInstructions;

    //TASK: Create EditText variables
    private EditText userInput;

    //TASK: Create SoundPool variables
    private SoundPool randSound;

    //TASK: Create SparseIntArray variables (for sound storage)
    private SparseIntArray myMusic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TASK: Define TextView variables
        userInstructions = (TextView) findViewById(R.id.userInstructionsTextView);

        //TASK: Define EditText variables
        userInput = (EditText) findViewById(R.id.userNumInputEditText);

        //TASK: Initialize Sounds
        makeSounds();
    }

    private void makeSounds() {
        int playlistCapacity = 1;

        randSound = (new SoundPool.Builder()).build();

        myMusic = new SparseIntArray(playlistCapacity);
        myMusic.put(1, randSound.load(this, R.raw.air_whoosh, 1));
        myMusic.put(2, randSound.load(this, R.raw.crash_sound, 1));
    }

    public void goToIntro(View view) {
        Intent introIntent = new Intent(getApplicationContext(), IntroActivity.class);
        startActivity(introIntent);
    }

    public void goToWebpage(View view) {
        String handbook = "https://online.anyflip.com/ofsj/cxmj/mobile/index.html#p=1";
        Uri handbookSite = Uri.parse(handbook);

        Intent goToHandbook = new Intent(Intent.ACTION_VIEW, handbookSite);
        if (goToHandbook.resolveActivity(getPackageManager()) != null) {
            startActivity(goToHandbook);
        }
    }

    public void randomizeCharacters(View view) {
        String numCheck = userInput.getText().toString();
        int userNum;

        if (numCheck.equals("") || numCheck.equals(" ")) {
            randSound.play(2,1,1,1,0,1.0f);

            userInstructions.setText(R.string.errorInstruction);
            userInput.setText("1");
        }
        else {
            userNum = Integer.parseInt(userInput.getText().toString());
            if (userNum > 25 || userNum < 1) {
                randSound.play(2,2,2,1,0,1.0f);

                userInstructions.setText(R.string.errorInstruction);
                userInput.setText("1");
            }
            if (userNum < 26 && userNum > 0) {
                randSound.play(1,2,2,1,0,1.0f);

                Intent browseIntent = new Intent(MainActivity.this, CharacterBrowse.class);
                browseIntent.putExtra("intTransfer", userNum);
                startActivity(browseIntent);
            }
        }
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