package edu.hanover.myapplication5;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class Workout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);

        //TextView textViewc = (TextView) findViewById(R.id.txtitemc);
        String cardioholder = getIntent().getStringExtra("cardiotext");

        //TextView textViewi = (TextView) findViewById(R.id.txtitemi);
        String intensityholder = getIntent().getStringExtra("intensitytext");

        //TextView textViewm = (TextView) findViewById(R.id.txtitemm);
        String muscleholder = getIntent().getStringExtra("muscletext");

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
            checkBox.setText(cdescriptionText);

        }
        cc.close();



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

}


