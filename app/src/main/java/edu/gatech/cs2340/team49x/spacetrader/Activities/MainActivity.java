package edu.gatech.cs2340.team49x.spacetrader.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import edu.gatech.cs2340.team49x.spacetrader.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        openSettings(findViewById(R.id.settingsBT));
    }

    /**
     * Opens Setting Activity
     *
     * @param view current View
     */
    public void openSettings(View view) {
        Intent intent = new Intent(MainActivity.this, ConfigurationActivity.class);
        startActivity(intent);
    }

    /**
     * Starts Game Activity
     *
     * @param view current View
     */
    public void startGame(View view) {
        Intent intent = new Intent(MainActivity.this, MarketActivity.class);
        startActivity(intent);
    }
}