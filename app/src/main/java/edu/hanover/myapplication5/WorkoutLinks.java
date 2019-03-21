package edu.hanover.myapplication5;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class WorkoutLinks extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);

        //add link to exercises
        TextView liftvids = (TextView) findViewById(R.id.textView3);
        liftvids.setClickable(true);
        liftvids.setMovementMethod(LinkMovementMethod.getInstance());
        String text = "https://www.youtube.com/playlist?list=PLyP03Zd31OhMJWdIkpZBhq5MsUix3qHJU";
        liftvids.setText("Lifting Tutorials  ");
        liftvids.append(Html.fromHtml(text));

        //add link for stretches
        TextView stretchvids = (TextView) findViewById(R.id.textView6);
        stretchvids.setClickable(true);
        stretchvids.setMovementMethod(LinkMovementMethod.getInstance());
        String link = "https://www.youtube.com/playlist?list=PLyP03Zd31OhMJWdIkpZBhq5MsUix3qHJU";
        stretchvids.setText("Stretching Tutorials  ");
        stretchvids.append(Html.fromHtml(link));
    }
}
