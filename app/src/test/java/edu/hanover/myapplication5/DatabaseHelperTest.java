package edu.hanover.myapplication5;

import android.database.sqlite.SQLiteDatabase;
import android.test.AndroidTestCase;
import android.util.Log;

import org.junit.Assert;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import static org.junit.Assert.*;

public class DatabaseHelperTest extends AndroidTestCase {
    SQLiteDatabase db;

    @Test
    public void onCreateTest() {
        DatabaseHelper databaseHelper = new DatabaseHelper(mContext);
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        databaseHelper.onCreate(db);
        assertTrue(db.isOpen());
        db.close();
        Log.d("onCreatePassed", "dbTest1Passed");
    }

    @Test
    public void onUpgradeTest() {
        DatabaseHelper databaseHelper = new DatabaseHelper(mContext);
        databaseHelper.onUpgrade(db, 1, 2);
        assertTrue(databaseHelper.DB_VERSION == 2);
    }

    @Test
    public void insertHistoryTest() {
        DatabaseHelper databaseHelper = new DatabaseHelper(mContext);
        databaseHelper.insertHistory(db, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime()),
                "cardio", "lift", "yoga", "notes");
        assertNotNull(db);
    }
}