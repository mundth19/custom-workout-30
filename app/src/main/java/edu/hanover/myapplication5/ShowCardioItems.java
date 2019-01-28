package edu.hanover.myapplication5;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ShowCardioItems extends AppCompatActivity {

    ListView lv;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_cardio_items);
        lv = (ListView)findViewById(R.id.listview1);
        db = openOrCreateDatabase("workouts",MODE_PRIVATE,null);
        Cursor c = db.rawQuery("select name from cardio", null);
        ArrayList ar = new ArrayList();
        while (c.moveToNext()) {

            ar.add(c.getString(0));
        }
        ArrayAdapter ad = new ArrayAdapter(this, android.R.layout.simple_list_item_1,ar);
        lv.setAdapter(ad);

    }
}
