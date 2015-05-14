package com.yjsoon.jokes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    int mJokeNumber = 0;
    ArrayList<Joke> mJokeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView jokeQuestionText = (TextView) findViewById(R.id.joke_question_text);
        final Button showPunchlineButton = (Button) findViewById(R.id.show_punchline_button);
        final TextView punchlineText = (TextView) findViewById(R.id.punchline_text);
        final Button showNextJokeButton = (Button) findViewById(R.id.show_next_joke_button);
        final Button lolButton = (Button) findViewById(R.id.lol_button);

        mJokeList = new ArrayList<Joke>();
        mJokeList.add(new Joke("Dad, did you get a haircut?", "No, I got them all cut."));
        mJokeList.add(new Joke("Why couldn't the bicycle stand up by itself?", "Because it was two tired"));
        mJokeList.add(new Joke("Can February March?", "No, but April May!"));

        jokeQuestionText.setText(mJokeList.get(0).getJoke());
        punchlineText.setText(mJokeList.get(0).getPunchline());

        showPunchlineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                punchlineText.setVisibility(View.VISIBLE);
                showNextJokeButton.setVisibility(View.VISIBLE);
                lolButton.setVisibility(View.VISIBLE);
            }
        });

        showNextJokeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("YJ", "Show next joke!!!");

                if (mJokeNumber < mJokeList.size() - 1) {
                    mJokeNumber++; // we increment the joke number each time this is pressed
                    jokeQuestionText.setText(mJokeList.get(mJokeNumber).getJoke());
                    punchlineText.setText(mJokeList.get(mJokeNumber).getPunchline());
                    punchlineText.setVisibility(View.INVISIBLE);
                } else {
                    jokeQuestionText.setText("No more jokes. Life is sad.");
                    punchlineText.setText("Very very sad.");
                    showPunchlineButton.setVisibility(View.INVISIBLE);
                }

                showNextJokeButton.setVisibility(View.INVISIBLE);
            }
        });

        lolButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LolActivity.class);
                startActivity(intent);
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
