package edu.hanover.myapplication5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.Manifest.permission.*;
import android.content.Intent;


public class Workout extends AppCompatActivity {

    //String cardioholder = getIntent().getStringExtra("cardioclickvalue");
    //String intensityholder = getIntent().getStringExtra("intensityclickvalue");
    //String muscleholder = getIntent().getStringExtra("muscleclickvalue");

    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);

        textView = (TextView) findViewById(R.id.txtitem);
        String muscleholder = getIntent().getStringExtra("muscleclickvalue");
        textView.setText(muscleholder);

      /*  String CarListView = Car.get(position).toString();
        intent.putExtra("cardioclickvalue", CarListView);
        String cardioholder = getIntent().getStringExtra("cardioclickvalue");
        */

       /* try {
            SQLiteOpenHelper cardioDatabaseHelper = new DatabaseHelper(this);
            SQLiteDatabase db = cardioDatabaseHelper.getReadableDatabase();
            Cursor cursor = db.query("CARDIO", new String[]{"NAME, INTENSITY, DESCRIPTION"},
                    "NAME = ? AND INTENSITY = ?",
                    new String[]{cardioholder, intensityholder},
                    null, null, null, null);


        cursor.close();
        db.close();
    } catch (SQLiteException e){
          Toast toast = Toast.makeText(this, "Database unavailable", Toast.LENGTH_SHORT);
            toast.show();
        } */
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


    }}

