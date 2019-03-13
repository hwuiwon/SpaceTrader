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
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        setContentView(R.layout.activity_select);
    }

    /**
     * Opens Travel Activity
     *
     * @param view current View
     */
    public void startTravel(View view) {
        Intent intent = new Intent(SelectActivity.this, TravelActivity.class);
        startActivity(intent);
    }

    /**
     * Opens Setting Activity
     *
     * @param view current View
     */
    public void openSettings(View view) {
        Intent intent = new Intent(SelectActivity.this, ConfigurationActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
    }
}