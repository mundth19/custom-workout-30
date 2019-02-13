package edu.hanover.myapplication5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
import android.widget.AdapterView;
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
import android.widget.TextView;
import android.widget.Toast;
import android.widget.SimpleCursorAdapter;

import java.util.ArrayList;
import java.util.List;

public class MuscleGroup extends Cardio {

    ListView lv;
    SQLiteDatabase db;
    TextView textView;
    ArrayList Mar = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_muscle_group_items);

        textView = (TextView)findViewById(R.id.txtitem2);
        String cardioholder = getIntent().getStringExtra("cardioclickvalue");
        textView.setText(cardioholder);

        lv = (ListView)findViewById(R.id.listview3);
        db = openOrCreateDatabase("workouts",MODE_PRIVATE,null);
        Cursor c = db.rawQuery("select name from lifting", null);
        //ArrayList ar = new ArrayList();
        while (c.moveToNext()) {
            if (!(Mar.contains(c.getString(0)))){
                Mar.add(c.getString(0));
            }
        }
        ArrayAdapter ad = new ArrayAdapter(this, android.R.layout.simple_list_item_1,Mar);
        lv.setAdapter(ad);

        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MuscleGroup.this, Workout.class);

                String MusListView = Mar.get(position).toString();
                intent.putExtra("muscleclickvalue", MusListView);

                startActivity(intent);
            }
        };
        lv.setOnItemClickListener(itemClickListener);

    }
    }
