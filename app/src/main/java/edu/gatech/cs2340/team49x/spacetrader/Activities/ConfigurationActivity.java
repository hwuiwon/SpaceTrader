package edu.gatech.cs2340.team49x.spacetrader.Activities;

import android.annotation.SuppressLint;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import edu.gatech.cs2340.team49x.spacetrader.Objects.Difficulty;
import edu.gatech.cs2340.team49x.spacetrader.Objects.General.Player;
import edu.gatech.cs2340.team49x.spacetrader.R;
import edu.gatech.cs2340.team49x.spacetrader.Viewmodels.ConfigurationViewModel;
import edu.gatech.cs2340.team49x.spacetrader.databinding.ActivityConfigBinding;

@SuppressLint("SetTextI18n")
public class ConfigurationActivity extends AppCompatActivity {

    ActivityConfigBinding binding;
    private ConfigurationViewModel viewModel;
    private Player player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_config);
        viewModel = ViewModelProviders.of(this).get(ConfigurationViewModel.class);

        player = viewModel.getPlayer();
        Difficulty difficulty = viewModel.getDifficulty();
        if (player == null) {
            player = new Player("");
        }
        if (difficulty == null) {
            difficulty = Difficulty.EASY;
        }
        binding.pnameET.setText(player.getName());
        binding.sPointsTV.setText(String.valueOf(player.getSkillPt()));
        binding.pilotSkillTV.setText(String.valueOf(player.getPilotPt()));
        binding.fighterSkillTV.setText(String.valueOf(player.getFighterPt()));
        binding.traderSkillTV.setText(String.valueOf(player.getTradePt()));
        binding.engineerSkillTV.setText(String.valueOf(player.getEngineerPt()));
        binding.difTV.setText(difficulty.toString());
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
        else if (getVal(binding.sPointsTV) > 0)
            Toast.makeText(this, "You have unused skill points.", Toast.LENGTH_LONG).show();
        else {
            player.setName(binding.pnameET.getText().toString());
            player.setSkillPt(getVal(binding.sPointsTV));
            player.setPilotPt(getVal(binding.pilotSkillTV));
            player.setFighterPt(getVal(binding.fighterSkillTV));
            player.setTradePt(getVal(binding.traderSkillTV));
            player.setEngineerPt(getVal(binding.engineerSkillTV));

            viewModel.configure(player, Difficulty.valueOf(binding.difTV.getText().toString()));
            viewModel.printGameState();
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