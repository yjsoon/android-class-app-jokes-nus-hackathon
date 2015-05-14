package com.yjsoon.jokes;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    int mJokeNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView jokeQuestionText = (TextView) findViewById(R.id.joke_question_text);
        final Button showPunchlineButton = (Button) findViewById(R.id.show_punchline_button);
        final TextView punchlineText = (TextView) findViewById(R.id.punchline_text);
        final Button showNextJokeButton = (Button) findViewById(R.id.show_next_joke_button);

        jokeQuestionText.setText("Dad, did you get a haircut?");
        punchlineText.setText("No, I got them all cut.");

        showPunchlineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                punchlineText.setVisibility(View.VISIBLE);
                showNextJokeButton.setVisibility(View.VISIBLE);
            }
        });

        showNextJokeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("YJ", "Show next joke!!!");

                mJokeNumber++; // we increment the joke number each time this is pressed
                String joke = "", punchline = ""; // define first, set in the if statement

                // could probably use a switch statement instead...
                if (mJokeNumber == 1) {
                    joke = "Why couldn't the bicycle stand up by itself?";
                    punchline = "Because it was two tired";
                } else if (mJokeNumber == 2) {
                    joke = "Can February March?";
                    punchline = "No, but April May!";
                } else {
                    joke = "There are no more jokes.";
                    punchline = "Life is tough.";
                }

                jokeQuestionText.setText(joke);
                punchlineText.setText(punchline);
                punchlineText.setVisibility(View.INVISIBLE);
                showNextJokeButton.setVisibility(View.INVISIBLE);
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
