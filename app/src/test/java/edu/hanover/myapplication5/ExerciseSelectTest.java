package edu.hanover.myapplication5;

import android.widget.ArrayAdapter;
import android.widget.Spinner;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class ExerciseSelectTest {

    @Test
    public void onCreate() {
        //testing the add method used in ExerciseSelect class
        ArrayList<String> adapter = new ArrayList<>();
        adapter.add("Running");
        adapter.add("Biking");
        adapter.add("Elliptical");
        assert(adapter.get(0).equals("Running"));
        assert(adapter.get(1).equals("Biking"));
        assert(adapter.get(2).equals("Elliptical"));

    }
}