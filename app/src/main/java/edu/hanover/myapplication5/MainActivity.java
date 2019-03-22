package edu.hanover.myapplication5;

//main activity to start the app, user will be taken to different class depending on what they wish to do

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //on click, takes user to create a workout
    public void onClickNewWorkout(View v){
        Intent intent = new Intent(this, ExerciseSelect.class);
        startActivity(intent);
    }
    //on click, takes user to view history
    public void onClickHistory(View v){
        Intent intent = new Intent(this, History.class);
        startActivity(intent);
    }


}
