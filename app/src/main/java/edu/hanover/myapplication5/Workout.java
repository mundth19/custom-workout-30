package edu.hanover.myapplication5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.CheckBox;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import static edu.hanover.myapplication5.DatabaseHelper.insertHistory;

public class Workout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);

        String cardioholder = getIntent().getStringExtra("cardiotext");
        String intensityholder = getIntent().getStringExtra("intensitytext");
        String muscleholder = getIntent().getStringExtra("muscletext");

        CheckBox checkBoxCardio = (CheckBox) findViewById(R.id.checkBox);
        CheckBox checkBoxLift = (CheckBox) findViewById(R.id.checkBox2);
        CheckBox checkBoxYoga = (CheckBox) findViewById(R.id.checkBox3);

       //get Cardio method - should be a function, but app kept crashing when making functions
        SQLiteDatabase db = openOrCreateDatabase("workouts",MODE_PRIVATE,null);
        Cursor cc = db.query("CARDIO", new String[] {"NAME", "INTENSITY", "DESCRIPTION"},
                "NAME = ? AND INTENSITY = ?", new String [] {cardioholder, intensityholder},
                null,null,null);

        if (cc.moveToFirst()){
            String cdescriptionText = cc.getString(2);
            checkBoxCardio.setText(cdescriptionText);
        }
        cc.close();

        //add link to exercises
        TextView liftvids = (TextView) findViewById(R.id.textView3);
        liftvids.setClickable(true);
        liftvids.setMovementMethod(LinkMovementMethod.getInstance());
        String text = "https://www.youtube.com/playlist?list=PLyP03Zd31OhMJWdIkpZBhq5MsUix3qHJU";
        liftvids.setText("Lifting Tutorials  ");
        liftvids.append(Html.fromHtml(text));
        //get lifting method - should be a function, but app kept crashing when making functions
        Cursor lc = db.query("LIFTING", new String[] {"NAME", "INTENSITY", "DESCRIPTION"},
                "NAME = ? AND INTENSITY = ?", new String[]{muscleholder, intensityholder},
                null,null,null);

        List<String> lifts = new ArrayList<String>();
        if (lc.moveToFirst()) {
            String ldescriptionText = lc.getString(2);
            lifts.add(ldescriptionText);
        }
        while (lc.moveToNext()){
            String ldescriptionText = lc.getString(2);
            lifts.add(ldescriptionText);
            Collections.shuffle(lifts); //shuffles list of workouts
        }
        checkBoxLift.setText(lifts.get(0) + "\n"+ "\n");
        checkBoxLift.append(lifts.get(1));
        checkBoxLift.append(lifts.get(2)); //randomly selects the first 2 workouts after being shuffled

        lc.close();
        //add link for stretches
        TextView stretchvids = (TextView) findViewById(R.id.textView6);
        stretchvids.setClickable(true);
        stretchvids.setMovementMethod(LinkMovementMethod.getInstance());
        String link = "https://www.youtube.com/playlist?list=PLyP03Zd31OhMJWdIkpZBhq5MsUix3qHJU";
        stretchvids.setText("Stretching Tutorials  ");
        stretchvids.append(Html.fromHtml(link));
        ////get yoga method - should be a function, but app kept crashing when making functions
        Cursor yc = db.query("YOGA", new String[] {"NAME", "DESCRIPTION"},
                "NAME = ?", new String[]{muscleholder}, null, null,null);
        if (yc.moveToFirst()) {
            String ydescriptionText = yc.getString(1);
            checkBoxYoga.setText(ydescriptionText +"\n"+"\n");
        }
        while (yc.moveToNext()){
            String ydescriptionText = yc.getString(1);
            checkBoxYoga.append(ydescriptionText+"\n"+"\n");
        }
        yc.close();
        db.close();
    }

    public void onClickSave(View view) {
        Intent intent = new Intent(this, History.class);
        String formattedDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
        SQLiteDatabase db = openOrCreateDatabase("saved", MODE_PRIVATE, null);
        CheckBox checkboxC = (CheckBox) findViewById(R.id.checkBox);
        CheckBox checkboxL = (CheckBox) findViewById(R.id.checkBox2);
        CheckBox checkboxY = (CheckBox) findViewById(R.id.checkBox3);
        EditText editT = (EditText) findViewById(R.id.editText2);
        insertHistory(db, formattedDate, checkboxC.getText().toString(), checkboxL.getText().toString(), checkboxY.getText().toString(),
                editT.getText().toString());
        startActivity(intent);
    }
}