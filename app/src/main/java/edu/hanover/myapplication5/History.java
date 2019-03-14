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
    //DatabaseHelper db = new DatabaseHelper(this);
    //SQLiteDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);


        //below works
        ListView saved = (ListView) findViewById(R.id.SavedHistory);
//        String cardioExercise = getIntent().getStringExtra("cardioExercise");
//        String liftExercise = getIntent().getStringExtra("liftExercise");
//        String yogaExercise = getIntent().getStringExtra("yogaExercise");
//        String notes = getIntent().getStringExtra("notes");
//        String formattedDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());

        SQLiteDatabase db = openOrCreateDatabase("saved", MODE_PRIVATE, null);


//        db.execSQL("CREATE TABLE SAVED ("
//                + "DATE TEXT, "
//                + " CARDIO TEXT, "
//                + "LIFT TEXT, "
//                + "YOGA TEXT, "
//                + "NOTES TEXT);");

        //insertHistory(db, formattedDate, cardioExercise, liftExercise, yogaExercise, notes);
        Cursor h = db.query("SAVED", new String[] {"DATE", "CARDIO", "LIFT", "YOGA"}, null, null, null, null, null);

        ArrayList ar = new ArrayList();
        while (h.moveToNext() && h.isNull(1)==false) {

            ar.add(h.getString(0));
            ar.add(h.getString(1));
            ar.add(h.getString(2));
            ar.add(h.getString(3));

        }


            ArrayAdapter ad = new ArrayAdapter(this, android.R.layout.simple_list_item_1, ar);
            saved.setAdapter(ad);
            //insertHistory(db, formattedDate, cardioExercise, liftExercise, yogaExercise, notes);


        }}
//    //above works//
//        ListView history = (ListView) findViewById(R.id.SavedHistory);
//
//        SQLiteDatabase db = openOrCreateDatabase("workouthistory",MODE_PRIVATE,null);
//
//        insertHistory(db, formattedDate, cardioExercise, liftExercise, yogaExercise);
//
//        history = (ListView)findViewById(R.id.SavedHistory);
//        //db = openOrCreateDatabase("workouts",MODE_PRIVATE,null);
//
//        ArrayList ar = new ArrayList();
//        //ArrayList ar = new ArrayList();
//        while (h.moveToNext() && h.isNull(1)==false) {
//            if (!(ar.contains(h.getString(0)))){
//                ar.add(h.getString(0));
//                ar.add(h.getString(1));
//                ar.add(h.getString(2));
//                ar.add(h.getString(3));
//
//            }
//            ArrayAdapter ad = new ArrayAdapter(this, android.R.layout.simple_list_item_1,ar);
//            history.setAdapter(ad);
//
//
//    }
//    TextView tv = findViewById(R.id.textView4);
//        tv.setText(notes);
//    }}

//        String formattedDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
//        //TextView tv = (TextView) findViewById(R.id.textView4);
//        //tv.setMovementMethod(new ScrollingMovementMethod());
//
//        String cardioExercise = getIntent().getStringExtra("cardioExercise");
//        String liftExercise = getIntent().getStringExtra("liftExercise");
//        String yogaExercise = getIntent().getStringExtra("yogaExercise");
//        final SQLiteDatabase db = openOrCreateDatabase("workouthistory", MODE_PRIVATE, null);
////        db.execSQL("CREATE TABLE HISTORYWITHDATE ("
////                + "DATE TEXT, "
////                + " CARDIO TEXT, "
////                + "LIFT TEXT, "
////                + "YOGA TEXT);");
//
//
////
//        insertHistory(db, formattedDate, cardioExercise, liftExercise, yogaExercise);
//        ListView history = (ListView) findViewById(R.id.SavedHistory);
////
//        Cursor h = db.query("HISTORYWITHDATE", new String[]{"DATE", "CARDIO", "LIFT", "YOGA"}, null, null, null, null, null);
////        if(h.moveToFirst()){
////            String date = h.getString(0);
////            String cardio = h.getString(1);
////            String lift = h.getString(2);
////            String yoga = h.getString(3);
////            tv.setText(date +"\n");
////            tv.append(cardio + "\n"+ "\n");
////            tv.append(lift);
////            tv.append(yoga +"\n" +"\n");
////        }
////
////        if (h.moveToNext()){
////            String date = h.getString(0);
////            String cardio = h.getString(1);
////            String lift = h.getString(2);
////            String yoga = h.getString(3);
////            tv.append(date +"\n");
////            tv.append(cardio+ "\n"+ "\n");
////            tv.append(lift);
////            tv.append(yoga +"\n" +"\n");
////        }
////        if (h.moveToNext()){
////            String date = h.getString(0);
////            String cardio = h.getString(1);
////            String lift = h.getString(2);
////            String yoga = h.getString(3);
////            tv.append(date +"\n");
////            tv.append(cardio+ "\n"+ "\n");
////            tv.append(lift);
////            tv.append(yoga +"\n" +"\n");
////        }
////
////        if (h.moveToNext()){
////            String date = h.getString(0);
////            String cardio = h.getString(1);
////            String lift = h.getString(2);
////            String yoga = h.getString(3);
////            tv.append(date +"\n");
////            tv.append(cardio+ "\n"+ "\n");
////            tv.append(lift);
////            tv.append(yoga +"\n" +"\n");
////        }
//
////        if (h.moveToNext()){
////            String date = h.getString(0);
////            String cardio = h.getString(1);
////            String lift = h.getString(2);
////            String yoga = h.getString(3);
////            tv.append(date +"\n");
////            tv.append(cardio);
////            tv.append(lift);
////            tv.append(yoga +"\n" +"\n");
////        }
//
////
//        ArrayList ar = new ArrayList();
//        while (h.moveToNext() && h.isNull(1) == false) {
//            if (!(ar.contains(h.getString(0)))) {
//                ar.add(h.getString(0));
//                ar.add(h.getString(1));
//                ar.add(h.getString(2));
//                ar.add(h.getString(3));
//
//            }
//
//
//            ArrayAdapter ad = new ArrayAdapter(this, android.R.layout.simple_list_item_1, ar);
//            history.setAdapter(ad);
//
////        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
//            //@Override
//            //public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
////                Cursor h1 = db.query("HISTORYWITHDATE", new String[] {"DATE", "CARDIO", "LIFT","YOGA"},"DATE = ?", new String[]{h.getString(0)}, null,null,null);
////                while (h1.moveToNext()) {
////                    String cardioname = h1.getString(1);
////                    String liftname = h1.getString(2);
////                    String yoganame = h1.getString(3);
////                    desc.setText(cardioname);
////
////                }
////////                Intent intent = new Intent(History.this, HistoryDescription.class);
//////                //intent.putExtra("currentdate", ar.get(1).toString());
//////                String val =(String) parent.getItemAtPosition(position);
//////                intent.putExtra("current_date", val);
//////                startActivity(intent);
////            }
////        };
////        history.setOnItemClickListener(itemClickListener);
//
//            //h.close();
//            db.close();
//
//            //} //end
//        }
//        ;
//    };}
//    public void onClickClear(View v){
//        super.onCreate(null);
//    }}

