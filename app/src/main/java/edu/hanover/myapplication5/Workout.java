package edu.hanover.myapplication5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.Manifest.permission.*;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.CursorAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;
import android.widget.SimpleCursorAdapter;



public class Workout extends AppCompatActivity {

    //String cardioholder = getIntent().getStringExtra("cardioclickvalue");
    //String intensityholder = getIntent().getStringExtra("intensityclickvalue");
    //String muscleholder = getIntent().getStringExtra("muscleclickvalue");

//    TextView textView;
//    TextView textView1;
//    private SQLiteDatabase db;
//    private Cursor cursor;
//
//    Cardio cardioclass = new Cardio();
//    Intensity intensityclass = new Intensity();
//    MuscleGroup musclegroupclass = new MuscleGroup();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);

        TextView textViewc = (TextView) findViewById(R.id.txtitemc);
        String cardioholder = getIntent().getStringExtra("cardiotext");
        textViewc.setText(cardioholder);

        TextView textViewi = (TextView) findViewById(R.id.txtitemi);
        String intensityholder = getIntent().getStringExtra("intensitytext");
        textViewi.setText(intensityholder);

        TextView textViewm = (TextView) findViewById(R.id.txtitemm);
        String muscleholder = getIntent().getStringExtra("muscletext");
        textViewm.setText(muscleholder);


      /*  String CarListView = Car.get(position).toString();
        intent.putExtra("cardioclickvalue", CarListView);
        String cardioholder = getIntent().getStringExtra("cardioclickvalue");
        */

       /*try {
            SQLiteOpenHelper cardioDatabaseHelper = new DatabaseHelper(this);
            db = cardioDatabaseHelper.getReadableDatabase();
            cursor = db.query("CARDIO", new String[]{"NAME, INTENSITY, DESCRIPTION"},
                    "NAME = ? AND INTENSITY = ?",
                    new String[]{"running", "beginner"},
                    null, null, null, null);
            CursorAdapter listAdapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_1, cursor,
                    new String[] {"NAME"}, new int[] {android.R.id.text1}, 0);
            listworkout.setAdapter(listAdapter);



       }catch (SQLiteException e){

           Toast toast = Toast.makeText(this, "Database unavailable", Toast.LENGTH_SHORT);
           toast.show();
        }
        /*public Cursor cardiocursor(){
            SQLiteOpenHelper cardioDatabaseHelper = new DatabaseHelper(this);
            SQLiteDatabase db = cardioDatabaseHelper.getReadableDatabase();
            Cursor cursor = db.query("CARDIO", new String[] {"NAME, INTENSITY, DESCRIPTION"},
                    "NAME = ? AND INTENSITY = ?",
                    new String[] {cardioholder, intensityholder},
                    null, null, null, null);
            //startManagingCursor(cursor);
            return cursor;
        }
*/


    }
/*
    @Override
    public void onDestroy(){
        super.onDestroy();
        cursor.close();
        db.close();

    }
  */
}


