package edu.hanover.myapplication5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.view.View;
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
import java.util.List;

public class Intensity extends AppCompatActivity {

    ListView lv;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_intensity_items);
        lv = (ListView)findViewById(R.id.listview2);
        db = openOrCreateDatabase("workouts",MODE_PRIVATE,null);
        Cursor c = db.rawQuery("select intensity from cardio", null);
        ArrayList ar = new ArrayList();
        while (c.moveToNext()) {
            if (!(ar.contains(c.getString(0)))){
                ar.add(c.getString(0));
            }
        }
        ArrayAdapter ad = new ArrayAdapter(this, android.R.layout.simple_list_item_1,ar);
        lv.setAdapter(ad);

    }
    //public void onListItemClick() {
        //Intent intent = new Intent(Intensity.this, Cardio.class);
        //startActivity(intent);
    }//}
    /*
    public void onClickBeginner(View v){
        Intent intent = new Intent(this, Cardio.class);
        startActivity(intent);
    }
    public void onClickIntermediate(View v){
        Intent intent = new Intent(this, Cardio.class);
        startActivity(intent);
    }
    public void onClickAdvanced(View v){
        Intent intent = new Intent(this, Cardio.class);
        startActivity(intent);
    }
    */
