package edu.hanover.myapplication5;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class HistoryDescription extends AppCompatActivity {

    //DatabaseHelper db = new DatabaseHelper(this);

    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_description);

        TextView historydescription = (TextView) findViewById(R.id.textView2);
        String date = getIntent().getStringExtra("current_date");

        //historydescription.setText(date);


        SQLiteDatabase db = openOrCreateDatabase("workouts",MODE_PRIVATE,null);
//        db.execSQL("CREATE TABLE HISTORYWITHDATE ("
//                + "DATE TEXT, "
//                + " CARDIO TEXT, "
//                + "LIFT TEXT, "
//                + "YOGA TEXT);");
        Cursor cc = db.query("HISTORYWITHDATE", new String[] {"DATE", "CARDIO", "LIFT", "YOGA"},"DATE = date", null, null, null, null);
        historydescription.setText(String.valueOf(cc.getCount()));

        if (cc != null && cc.moveToFirst()){
//            String thedate = cc.getString(0);
            String cnameText = cc.getString(1);
            String cintensityText = cc.getString(2);
            String cdescriptionText = cc.getString(3);
            historydescription.setText(cnameText);
            historydescription.append(cintensityText);
            historydescription.append(cdescriptionText);
            cc.close();
        }
        db.close();
    }
    }
