package edu.hanover.myapplication5;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

/**
 * The WorkoutLinks class is a simple class to display the links of videos to workouts
 *
 * @author Hannah Mundt
 * @version 1.0
 * @since 4/5/2019
 *
 */

public class WorkoutLinks extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);

        //add link to exercises
        TextView liftvids = (TextView) findViewById(R.id.textViewLiftingVids);
        liftvids.setClickable(true);
        liftvids.setMovementMethod(LinkMovementMethod.getInstance());
        String text = "https://www.youtube.com/playlist?list=PLyP03Zd31OhMJWdIkpZBhq5MsUix3qHJU";
        liftvids.setText("Lifting Tutorials  ");
        liftvids.append(Html.fromHtml(text));

        //add link for stretches
        TextView stretchvids = (TextView) findViewById(R.id.textViewStretchingVids);
        stretchvids.setClickable(true);
        stretchvids.setMovementMethod(LinkMovementMethod.getInstance());
        String link = "https://www.youtube.com/playlist?list=PLyP03Zd31OhMJWdIkpZBhq5MsUix3qHJU";
        stretchvids.setText("Stretching Tutorials  ");
        stretchvids.append(Html.fromHtml(link));
    }
}
