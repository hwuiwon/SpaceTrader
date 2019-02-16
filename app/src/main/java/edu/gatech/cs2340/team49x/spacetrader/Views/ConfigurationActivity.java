package edu.gatech.cs2340.team49x.spacetrader.Views;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

import edu.gatech.cs2340.team49x.spacetrader.Objects.Difficulty;
import edu.gatech.cs2340.team49x.spacetrader.R;
import edu.gatech.cs2340.team49x.spacetrader.databinding.ActivityConfigBinding;

public class ConfigurationActivity extends AppCompatActivity {

    ActivityConfigBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_config);
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
            setResult(Activity.RESULT_OK, new Intent()
                    .putExtra("name", binding.pnameET.getText())
                    .putExtra("skillPt", getVal(binding.sPointsTV))
                    .putExtra("pilotPt", getVal(binding.pilotSkillTV))
                    .putExtra("fighterPt", getVal(binding.fighterSkillTV))
                    .putExtra("tradePt", getVal(binding.traderSkillTV))
                    .putExtra("engineerPt", getVal(binding.engineerSkillTV))
                    .putExtra("difficulty", (String) binding.difTV.getText()));

            Toast.makeText(this, "Player{" +
                    "name='" + binding.pnameET.getText() + '\'' +
                    ", skillPt=" + getVal(binding.sPointsTV) +
                    ", pilotPt=" + getVal(binding.pilotSkillTV) +
                    ", fighterPt=" + getVal(binding.fighterSkillTV) +
                    ", tradePt=" + getVal(binding.traderSkillTV) +
                    ", engineerPt=" + getVal(binding.engineerSkillTV) +
                    ", difficulty=" + binding.difTV.getText() +
                    '}', Toast.LENGTH_LONG).show();
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