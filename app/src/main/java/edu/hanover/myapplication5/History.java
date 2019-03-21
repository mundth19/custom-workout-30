package edu.hanover.myapplication5;

import android.support.v7.app.ActionBar;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import static edu.hanover.myapplication5.DatabaseHelper.insertHistory;

public class History extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        //create a listview for saved workouts
        ListView saved = (ListView) findViewById(R.id.SavedHistory);
        //retrieve data from previous activity
        String cardioExercise = getIntent().getStringExtra("cardioExercise");
        String liftExercise = getIntent().getStringExtra("liftExercise");
        String yogaExercise = getIntent().getStringExtra("yogaExercise");
        String notes = getIntent().getStringExtra("notes");
        String formattedDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());

        final SQLiteDatabase db = openOrCreateDatabase("saved", MODE_PRIVATE, null);

//        db.execSQL("CREATE TABLE SAVED ("
//                + "DATE TEXT, "
//                + " CARDIO TEXT, "
//                + "LIFT TEXT, "
//                + "YOGA TEXT, "
//                + "NOTES TEXT);");
        //insert history into table, then query the table
        insertHistory(db, formattedDate, cardioExercise, liftExercise, yogaExercise, notes);
        Cursor h = db.query("SAVED", new String[] {"DATE", "CARDIO", "LIFT", "YOGA"}, null, null, null, null, null);

        ArrayList ar = new ArrayList();
        while (h.moveToNext()) {
            while(h.isNull(1) && h.isLast()==false){
                h.moveToNext();
            }
            if(h.isNull(1) == false){
                ar.add(h.getString(0));
                ar.add(h.getString(1));
                ar.add(h.getString(2));
                ar.add(h.getString(3));
            }
        }

        ArrayAdapter ad = new ArrayAdapter(this, android.R.layout.simple_list_item_1, ar);
        saved.setAdapter(ad);

        ActionBar actionBar = getSupportActionBar(); //allow back button on the action bar
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    //allows action bar/back button
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    //clears the database on the click of the button
    public void onClickClearHistory(View view) {
        SQLiteDatabase db = openOrCreateDatabase("saved", MODE_PRIVATE, null);
        db.delete("saved", null, null);
        Intent intent = new Intent(this, History.class);
        startActivity(intent);
    }
}