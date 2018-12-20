package edu.hanover.myapplication5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClickIntensity(View v){
        Intent intent = new Intent(this, Intensity.class);
        startActivity(intent);
    }
    public void onClickHistory(View v){
        Intent intent = new Intent(this, History.class);
        startActivity(intent);
    }


}
