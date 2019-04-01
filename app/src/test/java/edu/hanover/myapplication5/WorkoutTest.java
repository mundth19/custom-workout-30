package edu.hanover.myapplication5;
import org.junit.Assert;
import org.junit.Test;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import static org.junit.Assert.assertThat;

public class WorkoutTest {

    @Test
    public void onCreate() {
        //testing cursor and seeing if it is pulling accurate, correct info
        //from database
        String muscleholder = "Upper Body";
        SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase("workouts", null, null);
        Cursor yc = db.query("YOGA", new String[]{"NAME", "DESCRIPTION"},
                "NAME = ?", new String[]{muscleholder}, null, null, null);
        if (yc.moveToFirst()) {
            String ydescriptionText = yc.getString(1);
            assert ydescriptionText == yc.getString(1);
        }
    }
}