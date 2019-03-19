package edu.hanover.myapplication5;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.security.spec.PSSParameterSpec;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import static edu.hanover.myapplication5.DatabaseHelper.insertHistory;
import static javax.xml.datatype.DatatypeConstants.DATETIME;

public class History extends AppCompatActivity {

    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        //below works
        ListView saved = (ListView) findViewById(R.id.SavedHistory);
        String cardioExercise = getIntent().getStringExtra("cardioExercise");
        String liftExercise = getIntent().getStringExtra("liftExercise");
        String yogaExercise = getIntent().getStringExtra("yogaExercise");
        String notes = getIntent().getStringExtra("notes");
        String formattedDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());

        SQLiteDatabase db = openOrCreateDatabase("saved", MODE_PRIVATE, null);

//        db.execSQL("CREATE TABLE SAVED ("
//                + "DATE TEXT, "
//                + " CARDIO TEXT, "
//                + "LIFT TEXT, "
//                + "YOGA TEXT, "
//                + "NOTES TEXT);");

        insertHistory(db, formattedDate, cardioExercise, liftExercise, yogaExercise, notes);
        Cursor h = db.query("SAVED", new String[] {"DATE", "CARDIO", "LIFT", "YOGA"}, null, null, null, null, null);

        ArrayList ar = new ArrayList();

        while (h.moveToNext()) {
            while(h.isNull(1) && h.isLast()==false){
                h.moveToNext();
            }
            if(h.isNull(1) == false){
                ar.add(h.getString(0));
                ar.add(h.getString(1));
                ar.add(h.getString(2));
                ar.add(h.getString(3));
            }
        }

            ArrayAdapter ad = new ArrayAdapter(this, android.R.layout.simple_list_item_1, ar);
            saved.setAdapter(ad);

        }}

