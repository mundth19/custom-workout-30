package edu.hanover.myapplication5;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import org.junit.Test;

import static android.content.Context.MODE_PRIVATE;
import static edu.hanover.myapplication5.DatabaseHelper.insertHistory;
import static org.junit.Assert.*;

public class HistoryTest {

    @Test
    public void onCreate() {
        SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase("saved",
                null, null);
        insertHistory(db, "date", "running", "lifting", "yoga",
                "notes");
        Cursor h = db.query("SAVED", new String[] {"DATE", "CARDIO", "LIFT", "YOGA"},
                null, null, null, null, null);
        assert (h.moveToFirst() == true); //the first entry will be successfully stored in the database


    }

    @Test
    public void onClickClearHistory() {
        SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase("saved",
                null, null);
        db.delete("saved", null, null);
        Cursor h = db.query("SAVED", new String[] {"DATE", "CARDIO", "LIFT", "YOGA"},
                null, null, null, null, null);
        assert(h.moveToFirst() == false); //this means the database will be empty
    }
}