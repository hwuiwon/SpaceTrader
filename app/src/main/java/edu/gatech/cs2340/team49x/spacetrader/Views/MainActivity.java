package edu.gatech.cs2340.team49x.spacetrader.Views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import edu.gatech.cs2340.team49x.spacetrader.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        openSettings(findViewById(R.id.settingsBT));
    }

    public void openSettings(View view) {
        Intent intent = new Intent(MainActivity.this, ConfigurationActivity.class);
        startActivity(intent);
    }

    public void startGame(View view) {
        // Starts game activity
        Toast.makeText(this, "Play Button Pressed", Toast.LENGTH_LONG).show();
    }
}