package edu.gatech.cs2340.team49x.spacetrader.Views;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import edu.gatech.cs2340.team49x.spacetrader.Objects.Difficulty;
import edu.gatech.cs2340.team49x.spacetrader.Objects.Player;
import edu.gatech.cs2340.team49x.spacetrader.R;
import edu.gatech.cs2340.team49x.spacetrader.Viewmodels.ConfigurationViewModel;

public class MainActivity extends AppCompatActivity {

    public Player player;
    private ConfigurationViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        viewModel = ViewModelProviders.of(this).get(ConfigurationViewModel.class);

        // Launch configuration activity when app starts
        Intent intent = new Intent(MainActivity.this, ConfigurationActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(MainActivity.this, ConfigurationActivity.class);
            intent.putExtra("name", player.getName())
                    .putExtra("skillPt", player.getSkillPt())
                    .putExtra("pilotPt", player.getPilotPt())
                    .putExtra("fighterPt", player.getFighterPt())
                    .putExtra("tradePt", player.getTradePt())
                    .putExtra("engineerPt", player.getEngineerPt())
                    .putExtra("difficulty", viewModel.getDifficulty().toString());
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        player = new Player(data.getStringExtra("name"),
                data.getIntExtra("skillPt", 0),
                data.getIntExtra("pilotPt", 0),
                data.getIntExtra("fighterPt", 0),
                data.getIntExtra("tradePt", 0),
                data.getIntExtra("engineerPt", 0), null, null);
        viewModel.configure(player, Difficulty.valueOf(data.getStringExtra("difficulty")));
        Toast.makeText(this, viewModel.printGameState(), Toast.LENGTH_LONG).show();
    }
}