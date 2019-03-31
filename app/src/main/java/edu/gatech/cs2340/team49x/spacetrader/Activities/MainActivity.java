package edu.gatech.cs2340.team49x.spacetrader.Activities;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import java.io.IOException;

import edu.gatech.cs2340.team49x.spacetrader.R;
import edu.gatech.cs2340.team49x.spacetrader.Viewmodels.MainViewModel;

public class MainActivity extends AppCompatActivity {

    private MainViewModel viewModel;
    private static final int CONFIG_COMPLETE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        setContentView(R.layout.activity_main);
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
        if (viewModel.gameConfigured()) {
            viewModel.saveGame();
            launchGame();
        } else {
            try {
                viewModel.loadGame();
            } catch (IOException e){
                Log.d("GAME", "No save file found.");
            } catch (ClassNotFoundException e) {
                Log.e("GAME", "Invalid save file.", e);
            }
            if (viewModel.gameConfigured()) {
                launchGame();
            } else {
                launchNewGame();
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == CONFIG_COMPLETE) {
            if (resultCode == RESULT_OK) {
                viewModel.saveGame();
                launchGame();
            }
        }
    }

    private void launchNewGame() {
        Intent intent = new Intent(MainActivity.this, ConfigurationActivity.class);
        startActivityForResult(intent, CONFIG_COMPLETE);
    }

    private void launchGame() {
        Intent intent = new Intent(MainActivity.this, SelectActivity.class);
        startActivity(intent);
    }
}