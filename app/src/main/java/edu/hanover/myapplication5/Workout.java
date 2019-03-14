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
import java.util.Calendar;

import static edu.hanover.myapplication5.DatabaseHelper.insertHistory;

public class Workout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);

        String cardioholder = getIntent().getStringExtra("cardiotext");

        String intensityholder = getIntent().getStringExtra("intensitytext");

        String muscleholder = getIntent().getStringExtra("muscletext");
        String formattedDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());

        CheckBox checkBox = (CheckBox) findViewById(R.id.checkBox);
        CheckBox checkBox2 = (CheckBox) findViewById(R.id.checkBox2);
        CheckBox checkBox3 = (CheckBox) findViewById(R.id.checkBox3);

       //get Cardio method
        SQLiteDatabase db = openOrCreateDatabase("workouts",MODE_PRIVATE,null);
        Cursor cc = db.query("CARDIO", new String[] {"NAME", "INTENSITY", "DESCRIPTION"},
                "NAME = ? AND INTENSITY = ?", new String [] {cardioholder, intensityholder},
                null,null,null);
        if (cc.moveToFirst()){
            String cnameText = cc.getString(0);
            String cintensityText = cc.getString(1);
            String cdescriptionText = cc.getString(2);
            checkBox.setText(formattedDate);
            checkBox.append(cdescriptionText);

        }
        cc.close();

        TextView liftvids = (TextView) findViewById(R.id.textView3);
        liftvids.setClickable(true);
        liftvids.setMovementMethod(LinkMovementMethod.getInstance());
        String text = "https://www.youtube.com/playlist?list=PLyP03Zd31OhMJWdIkpZBhq5MsUix3qHJU";
        liftvids.setText("Lifting Tutorials  ");
        liftvids.append(Html.fromHtml(text));

        Cursor lc = db.query("LIFTING", new String[] {"NAME", "INTENSITY", "DESCRIPTION"},
                "NAME = ? AND INTENSITY = ?", new String[]{muscleholder, intensityholder},
                null,null,null);
        if (lc.moveToFirst()) {
            String lnameText = lc.getString(0);
            String lintensityText = lc.getString(1);
            String ldescriptionText = lc.getString(2);
            checkBox2.setText(ldescriptionText +"\n"+"\n");
        }
        while (lc.moveToNext()){
            String ldescriptionText = lc.getString(2);
            checkBox2.append(ldescriptionText+"\n"+"\n");
        }
        lc.close();

        TextView stretchvids = (TextView) findViewById(R.id.textView6);
        stretchvids.setClickable(true);
        stretchvids.setMovementMethod(LinkMovementMethod.getInstance());
        String link = "https://www.youtube.com/playlist?list=PLyP03Zd31OhMJWdIkpZBhq5MsUix3qHJU";
        stretchvids.setText("Stretching Tutorials  ");
        stretchvids.append(Html.fromHtml(link));

        Cursor yc = db.query("YOGA", new String[] {"NAME", "DESCRIPTION"},
                "NAME = ?", new String[]{muscleholder}, null, null,null);
        if (yc.moveToFirst()) {
            String lnameText = yc.getString(0);
            String ydescriptionText = yc.getString(1);
            checkBox3.setText(ydescriptionText +"\n"+"\n");
        }
        while (yc.moveToNext()){
            String ydescriptionText = yc.getString(1);
            checkBox3.append(ydescriptionText+"\n"+"\n");
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
//        intent.putExtra("cardioExercise", checkboxC.getText().toString());
//        intent.putExtra("liftExercise", checkboxL.getText().toString());
//        intent.putExtra("yogaExercise", checkboxY.getText().toString());
//        intent.putExtra("notes", editT.getText().toString());
        insertHistory(db, formattedDate, checkboxC.getText().toString(), checkboxL.getText().toString(), checkboxY.getText().toString(),
                editT.getText().toString());
        startActivity(intent);
    }
}


