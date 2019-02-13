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

public class Intensity extends AppCompatActivity {

    ListView lv;
    SQLiteDatabase db;

    public static ArrayList getIar() {
        return Iar;
    }

    public static void setIar(ArrayList iar) {
        Iar = new ArrayList();
    }

    public static ArrayList Iar = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_intensity_items);
        lv = (ListView)findViewById(R.id.listview2);
        db = openOrCreateDatabase("workouts",MODE_PRIVATE,null);
        Cursor c = db.rawQuery("select intensity from cardio", null);
        //ArrayList ar = new ArrayList();
        while (c.moveToNext()) {
            if (!(Iar.contains(c.getString(0)))){
                Iar.add(c.getString(0));
            }
        }
        ArrayAdapter ad = new ArrayAdapter(this, android.R.layout.simple_list_item_1,Iar);
        lv.setAdapter(ad);



        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //TextView textView = (TextView) view.findViewById(R.id.txtitem2);
                //String text = textView.getText().toString();
                Toast.makeText(getApplicationContext(), ((TextView) view).getText(),
                        Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Intensity.this, Cardio.class);

                String IntListView = Iar.get(position).toString();
                intent.putExtra("intensityclickvalue", IntListView);


                startActivity(intent);
            }
        };
        lv.setOnItemClickListener(itemClickListener);


    }
   // public void getIntensity(TextView tv){
//        db = openOrCreateDatabase("workouts",MODE_PRIVATE,null);
//        Cursor c = db.rawQuery("select intensity, cardio from cardio", null);
//        //ArrayList ar = new ArrayList();
//        while (c.moveToNext()) {
//            if (!(Iar.contains(c.getString(0)))){
//                Iar.add(c.getString(0));
//            }
//        Cursor res = this.getReadableDatabase().rawQuery("select intenisty from "+CARDIO+"",null);
//        tv.setText("");
//        while (res.moveToNext()) {
//            tv.append(res.getString(1));
//        }
   // }

    //public static String getIntensity(){
        //String intensityholder = getIntent().getStringExtra("intensityclickvalue");
        //return intensityholder;
        //return null;
    //}



}