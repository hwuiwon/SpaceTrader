package edu.gatech.cs2340.team49x.spacetrader.Views;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

import edu.gatech.cs2340.team49x.spacetrader.Objects.Difficulty;
import edu.gatech.cs2340.team49x.spacetrader.Objects.Player;
import edu.gatech.cs2340.team49x.spacetrader.R;
import edu.gatech.cs2340.team49x.spacetrader.Viewmodels.ConfigurationViewModel;
import edu.gatech.cs2340.team49x.spacetrader.databinding.ActivityConfigBinding;

public class ConfigurationActivity extends AppCompatActivity {

    ActivityConfigBinding binding;
    private ConfigurationViewModel viewModel;
    public Player player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_config);
        viewModel = ViewModelProviders.of(this).get(ConfigurationViewModel.class);

        if (getIntent().getSerializableExtra("player") != null) {
            player = (Player) getIntent().getSerializableExtra("player");
            binding.pnameET.setText(player.getName());
            binding.sPointsTV.setText(String.valueOf(player.getSkillPt()));
            binding.pilotSkillTV.setText(String.valueOf(player.getPilotPt()));
            binding.fighterSkillTV.setText(String.valueOf(player.getFighterPt()));
            binding.traderSkillTV.setText(String.valueOf(player.getTradePt()));
            binding.engineerSkillTV.setText(String.valueOf(player.getEngineerPt()));
            binding.difTV.setText(getIntent().getStringExtra("difficulty"));
        }
    }

    /**
     * Creates player with values in configuration screen
     *
     * @param view current View
     */
    public void onConfirmPressed(View view) {
        String name = binding.pnameET.getText().toString().trim();
        if (name.length() == 0)
            Toast.makeText(this, "Please enter a valid name.", Toast.LENGTH_LONG).show();
        else {
            player = new Player(binding.pnameET.getText().toString(),
                    getVal(binding.sPointsTV),
                    getVal(binding.pilotSkillTV),
                    getVal(binding.fighterSkillTV),
                    getVal(binding.traderSkillTV),
                    getVal(binding.engineerSkillTV), null, null);

            Intent playerData = new Intent().putExtra("player", player)
                    .putExtra("difficulty", binding.difTV.getText().toString());

            setResult(Activity.RESULT_OK, playerData);
            viewModel.configure(player, Difficulty.valueOf(binding.difTV.getText().toString()));
            Toast.makeText(this, viewModel.printGameState(), Toast.LENGTH_LONG).show();
            finish();
        }
    }

    /**
     * Updates the value of TextView depending on the button pressed
     *
     * @param view current View
     */
    public void updateSkill(View view) {
        int points = getVal(binding.sPointsTV);
        if (points == 0) {
            Toast.makeText(this, "You have no skill points left", Toast.LENGTH_SHORT).show();
        }
        switch (view.getId()) {
            case R.id.skill1minusBT:
                decrease(binding.pilotSkillTV);
                break;
            case R.id.skill2minusBT:
                decrease(binding.fighterSkillTV);
                break;
            case R.id.skill3minusBT:
                decrease(binding.traderSkillTV);
                break;
            case R.id.skill4minusBT:
                decrease(binding.engineerSkillTV);
                break;
            case R.id.skill1plusBT:
                increase(binding.pilotSkillTV);
                break;
            case R.id.skill2plusBT:
                increase(binding.fighterSkillTV);
                break;
            case R.id.skill3plusBT:
                increase(binding.traderSkillTV);
                break;
            case R.id.skill4plusBT:
                increase(binding.engineerSkillTV);
                break;
        }
    }

    /**
     * Gets integer value
     *
     * @param view TextView that will get converted
     * @return the integer value of TextView
     */
    private int getVal(TextView view) {
        return Integer.parseInt(String.valueOf(view.getText()));
    }

    /**
     * Decreases integer value of TextView by 1
     *
     * @param view TextView that will be modified
     */
    private void decrease(TextView view) {
        if (!((getVal(view) - 1) < 0)) {
            view.setText(Integer.toString(getVal(view) - 1));
            binding.sPointsTV.setText(Integer.toString(getVal(binding.sPointsTV) + 1));
        }
    }

    /**
     * Increases integer value of TextView by 1
     *
     * @param view TextView that will be modified
     */
    private void increase(TextView view) {
        if (!(getVal(binding.sPointsTV) - 1 < 0)) {
            view.setText(Integer.toString(getVal(view) + 1));
            binding.sPointsTV.setText(Integer.toString(getVal(binding.sPointsTV) - 1));
        }
    }

    /**
     * Updates difficulty of a game
     *
     * @param view current View
     */
    public void updateDifficulty(View view) {
        switch (view.getId()) {
            case R.id.lowDifBT:
                binding.difTV.setText(
                        Difficulty.valueOf((String) binding.difTV.getText()).prev());
                break;
            case R.id.highDifBT:
                binding.difTV.setText(
                        Difficulty.valueOf((String) binding.difTV.getText()).next());
                break;
        }
    }
}