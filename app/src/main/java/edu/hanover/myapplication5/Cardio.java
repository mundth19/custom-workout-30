package edu.hanover.myapplication5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Cardio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardio);
    }

    public void onClickRunning(View v){
        Intent intent = new Intent(this, MuscleGroup.class);
        startActivity(intent);
    }
    public void onClickBiking(View v){
        Intent intent = new Intent(this, MuscleGroup.class);
        startActivity(intent);
    }
    public void onClickElliptical(View v){
        Intent intent = new Intent(this, MuscleGroup.class);
        startActivity(intent);
    }
}
