package edu.gatech.cs2340.team49x.spacetrader.Views;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import edu.gatech.cs2340.team49x.spacetrader.Objects.Difficulty;
import edu.gatech.cs2340.team49x.spacetrader.Objects.Player;
import edu.gatech.cs2340.team49x.spacetrader.R;
import edu.gatech.cs2340.team49x.spacetrader.Viewmodels.ConfigurationViewModel;

public class ConfigurationActivity extends AppCompatActivity {
    private ConfigurationViewModel viewModel;
    private EditText nameField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);
        viewModel = ViewModelProviders.of(this).get(ConfigurationViewModel.class);
        nameField = findViewById(R.id.pnameET);
    }

    public void onConfirmPressed(View view) {
        String name = nameField.getText().toString().trim();
        if (name == null || name.length() == 0)
            Toast.makeText(this, "Please enter a valid name.", Toast.LENGTH_LONG).show();
        else {
            Player p = new Player(nameField.getText().toString());
            viewModel.configure(p, Difficulty.EASY);

            Toast.makeText(this, viewModel.printGameState(), Toast.LENGTH_LONG).show();
            finish();
        }
    }
}
