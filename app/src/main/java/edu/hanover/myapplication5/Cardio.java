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
import android.widget.TextView;
import android.widget.Toast;
import android.widget.SimpleCursorAdapter;

import java.util.ArrayList;
import java.util.List;

import static edu.hanover.myapplication5.Intensity.Iar;

public class Cardio extends Intensity {
    ListView lv;
    SQLiteDatabase db;
    ArrayList Car = new ArrayList();
    TextView textViewi;
    //int intpos = Integer.parseInt(getIntent().getStringExtra("intensityclickvalue"));
    //public int intensitypos = Iar.indexOf(getIntent().getStringExtra("intensityclickvalue"));



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_cardio_items);

        textViewi = (TextView)findViewById(R.id.txtitem1);
        String intensityholder = getIntent().getStringExtra("intensityclickvalue");
        textViewi.setText(intensityholder);

        lv = (ListView)findViewById(R.id.listview1);
        db = openOrCreateDatabase("workouts",MODE_PRIVATE,null);
        Cursor c = db.rawQuery("select name from cardio", null);
        //ArrayList ar = new ArrayList();
        while (c.moveToNext()) {
            if (!(Car.contains(c.getString(0)))){
                Car.add(c.getString(0));
            }
        }


        ArrayAdapter ad = new ArrayAdapter(this, android.R.layout.simple_list_item_1,Car);
        lv.setAdapter(ad);

        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Cardio.this, MuscleGroup.class);


                String CarListView = Car.get(position).toString();
                intent.putExtra("cardioclickvalue", CarListView);

                //String cardioWorkout = (CarListView) parent.getItemAtPosition(position);

                startActivity(intent);

            }
        };
        lv.setOnItemClickListener(itemClickListener);
    }

    /*String text = textView.getText().toString();
    public String getIntensity(){
        if (text == "Beginner"){
            return String.valueOf(Iar.get(0));
        }
        else if (text == "Intermediate"){
            return String.valueOf(Iar.get(1));
        }
        else {
            return String.valueOf(Iar.get(2));
        }

    }
    */
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

