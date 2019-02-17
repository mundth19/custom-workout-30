package edu.hanover.myapplication5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
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

import java.util.ArrayList;


public class Workout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);

        TextView textViewc = (TextView) findViewById(R.id.txtitemc);
        String cardioholder = getIntent().getStringExtra("cardiotext");
        //textViewc.setText(cardioholder);

        TextView textViewi = (TextView) findViewById(R.id.txtitemi);
        String intensityholder = getIntent().getStringExtra("intensitytext");
        //textViewi.setText(intensityholder);

        TextView textViewm = (TextView) findViewById(R.id.txtitemm);
        String muscleholder = getIntent().getStringExtra("muscletext");
        //textViewm.setText(muscleholder);

          ListView lv = (ListView)findViewById(R.id.lvcardio);
        //TextView tcar = (TextView) findViewById(R.id.txtitemc);
//        SQLiteDatabase db = openOrCreateDatabase("workouts",MODE_PRIVATE,null);
//        Cursor c = db.rawQuery("select name from cardio", null);
//        int cardioindex = c.getColumnIndex("name");
//        int intensityindex = c.getColumnIndex("intensity");
//        int descriptionindex = c.getColumnIndex("description");
//        ArrayList car = new ArrayList();
//        while (c.moveToNext()) {
//            if (!(car.contains(c.getString(0)))){
//                car.add(c.getString(0));
//            }
//        }
//        car.add(cardioholder);
//        ArrayAdapter ad = new ArrayAdapter(this, android.R.layout.simple_list_item_1,car);
//        //tcar.setText((CharSequence) ad);
//        lv.setAdapter(ad);

       //getCardio method
        SQLiteDatabase db = openOrCreateDatabase("workouts",MODE_PRIVATE,null);
        Cursor c = db.query("CARDIO", new String[] {"NAME", "INTENSITY", "DESCRIPTION"},
                "NAME = ? AND INTENSITY = ?", new String [] {cardioholder, intensityholder},
                null,null,null);
        //ArrayList car = new ArrayList();
        if (c.moveToFirst()){
            String nameText = c.getString(0);
            String intensityText = c.getString(1);
            String descriptionText = c.getString(2);
            textViewc.setText(nameText);
            textViewi.setText(intensityText);
            textViewm.setText(descriptionText);

        }
        c.close();
        db.close();
        //car.add(cardioholder);
        //ArrayAdapter ad = new ArrayAdapter(this, android.R.layout.simple_list_item_1,car);
        //tcar.setText((CharSequence) ad);
        //lv.setAdapter(ad);



//       try {
//            SQLiteOpenHelper cardioDatabaseHelper = new DatabaseHelper(this);
//            SQLiteDatabase db = cardioDatabaseHelper.getReadableDatabase();
//            Cursor cursor = db.query("CARDIO", new String[]{"NAME, INTENSITY, DESCRIPTION"},
//                    "NAME = ? AND INTENSITY = ?",
//                    new String[]{cardioholder, intensityholder},
//                    null, null, null, null);
//            int cardioindex = cursor.getColumnIndex("name");
//            int intensityindex = cursor.getColumnIndex("intensity");
//            int descriptionindex = cursor.getColumnIndex("description");
//
//            String cardio = cursor.getString(cardioindex);
//            String intensity = cursor.getString(intensityindex);
//            String description = cursor.getString(descriptionindex);
//            CursorAdapter listAdapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_1, cursor,
//                    new String[] {"NAME"}, new int[] {android.R.id.text1}, 0);
//
//           if (cursor !=null && cursor.moveToFirst()){
//               TextView textViewc = (TextView) findViewById(R.id.txtitemc);
//               textViewc.setText(cardio);
//
//               TextView textViewi = (TextView) findViewById(R.id.txtitemi);
//               textViewi.setText(intensity);
//
//               TextView textViewm = (TextView) findViewById(R.id.txtitemm); //using to see if description works
//               textViewm.setText(description);
//
//               cursor.close();
//           }
////           cursor.close();
//           db.close();
//
//       }catch (SQLiteException e){
//
//           Toast toast = Toast.makeText(this, "Database unavailable", Toast.LENGTH_SHORT);
//           toast.show();
//        }
//
//
//
//    }

   /* @Override
    public void onDestroy(){
        super.onDestroy();
        cursor.close();
        db.close();

    }
  */
    }
  
}


