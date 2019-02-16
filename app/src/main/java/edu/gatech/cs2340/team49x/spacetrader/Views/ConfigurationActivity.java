package edu.gatech.cs2340.team49x.spacetrader.Views;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import edu.gatech.cs2340.team49x.spacetrader.Objects.Difficulty;
import edu.gatech.cs2340.team49x.spacetrader.Objects.Player;
import edu.gatech.cs2340.team49x.spacetrader.R;
import edu.gatech.cs2340.team49x.spacetrader.Viewmodels.ConfigurationViewModel;
import edu.gatech.cs2340.team49x.spacetrader.databinding.ActivityConfigBinding;

public class ConfigurationActivity extends AppCompatActivity {

    private ConfigurationViewModel viewModel;
    ActivityConfigBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);
        viewModel = ViewModelProviders.of(this).get(ConfigurationViewModel.class);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_config);

        if (getVal(binding.pilotSkillTV) == 0) {
            binding.skill1minusBT.setEnabled(false);
        }
        if (getVal(binding.fighterSkillTV) == 0) {
            binding.skill2minusBT.setEnabled(false);
        }
        if (getVal(binding.traderSkillTV) == 0) {
            binding.skill3minusBT.setEnabled(false);
        }
        if (getVal(binding.engineerSkillTV) == 0) {
            binding.skill4minusBT.setEnabled(false);
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
            Player p = new Player(binding.pnameET.getText().toString());
            viewModel.configure(p, Difficulty.EASY);
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
        if (getVal(binding.pilotSkillTV) == 0) {
            binding.skill1minusBT.setEnabled(false);
        } else binding.skill1minusBT.setEnabled(true);
        if (getVal(binding.fighterSkillTV) == 0) {
            binding.skill2minusBT.setEnabled(false);
        } else binding.skill2minusBT.setEnabled(true);
        if (getVal(binding.traderSkillTV) == 0) {
            binding.skill3minusBT.setEnabled(false);
        } else binding.skill3minusBT.setEnabled(true);
        if (getVal(binding.engineerSkillTV) == 0) {
            binding.skill4minusBT.setEnabled(false);
        } else binding.skill4minusBT.setEnabled(true);
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
        view.setText(Integer.toString(getVal(view) - 1));
        binding.sPointsTV.setText(Integer.toString(getVal(binding.sPointsTV) + 1));
    }

    /**
     * Increases integer value of TextView by 1
     *
     * @param view TextView that will be modified
     */
    private void increase(TextView view) {
        view.setText(Integer.toString(getVal(view) + 1));
        binding.sPointsTV.setText(Integer.toString(getVal(binding.sPointsTV) - 1));
    }
}