package edu.hanover.myapplication5;

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
import android.widget.Toast;
import android.widget.SimpleCursorAdapter;

import java.util.ArrayList;
import java.util.List;

public class Cardio extends AppCompatActivity {
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
            if (!(ar.contains(c.getString(0)))){
                ar.add(c.getString(0));
            }
        }
        ArrayAdapter ad = new ArrayAdapter(this, android.R.layout.simple_list_item_1,ar);
        lv.setAdapter(ad);

        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Cardio.this, MuscleGroup.class);
                startActivity(intent);
            }
        };
        lv.setOnItemClickListener(itemClickListener);

    }
}


        //ListActivity {private SQLiteDatabase db; private Cursor cursor;
    //private static final String DB_NAME = "workouts";
    //DatabaseHelper db;
    //ArrayList<String> listItem;
    //ArrayAdapter adapter;
    //ListView cardioList;


   /* @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardio);
    }
    */

        //db = new DatabaseHelper(this);
        //listItem = new ArrayList<>();

        
        //viewData();
        /*ListView listCardio = getListView();


        try {
            SQLiteOpenHelper DatabaseHelper = new DatabaseHelper(this);
            db = DatabaseHelper.getReadableDatabase();
            cursor = db.query("CARDIO",
                    new String[]{"NAME", "INTENSITY"},
                    "INTENSITY = ?",
                    new String[]{"Beginner"},
                    null, null, null);
            CursorAdapter listAdapter = new SimpleCursorAdapter(this,
                    android.R.layout.simple_list_item_1, cursor,
                    new String[]{"NAME"}, new int[]{android.R.id.text1}, 0);
            //ListView listView = getListView();
            listCardio.setAdapter(listAdapter);
        } catch(SQLiteException e) {
            Toast toast = Toast.makeText(this, "Database Unavailable", Toast.LENGTH_SHORT);
            toast.show();
        }

    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        cursor.close();
        db.close();
    }
        //@Override
        //public void onListItemClick(ListView listView, View itemView, int position, long id){
        //Intent intent = new Intent(this, MuscleGroup.class);
        //startActivity(intent);
        //}
*/
      /*  public void onClickRunning (View v){
            Intent intent = new Intent(this, MuscleGroup.class);
            startActivity(intent);
        }
        public void onClickBiking (View v){
            Intent intent = new Intent(this, MuscleGroup.class);
            startActivity(intent);
        }
        public void onClickElliptical (View v){
            Intent intent = new Intent(this, MuscleGroup.class);
            startActivity(intent);
        }
    }
    */
/*
    private void viewData() {
        Cursor cursor = db.viewData();

        if (cursor.getCount() == 0) {
            Toast.makeText(this, "no data", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()){
                listItem.add(cursor.getString(1));
            }

            adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listItem);
        }


    }
    */

