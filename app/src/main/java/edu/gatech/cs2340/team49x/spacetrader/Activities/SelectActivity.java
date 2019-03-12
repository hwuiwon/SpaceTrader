package edu.gatech.cs2340.team49x.spacetrader.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import edu.gatech.cs2340.team49x.spacetrader.R;

public class SelectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
    }

    public void startTravel(View view) {
        Intent intent = new Intent(SelectActivity.this, TravelActivity.class);
        startActivity(intent);
    }
}