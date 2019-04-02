package edu.gatech.cs2340.team49x.spacetrader.Activities;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import edu.gatech.cs2340.team49x.spacetrader.R;
import edu.gatech.cs2340.team49x.spacetrader.Viewmodels.SelectViewModel;
import edu.gatech.cs2340.team49x.spacetrader.databinding.ActivitySelectBinding;

public class SelectActivity extends AppCompatActivity {

    private SelectViewModel viewModel;
    private ActivitySelectBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        setContentView(R.layout.activity_select);

        viewModel = ViewModelProviders.of(this).get(SelectViewModel.class);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_select);

        binding.nameTV.setText(viewModel.getSystemName());
        binding.techlevelTV.setText(viewModel.getTechLevelDescription());
        binding.resourcesTV.setText(viewModel.getResourceDescription());
    }

    /**
     * Opens Travel Activity
     * @param view current View
     */
    public void startTravel(View view) {
        Intent intent = new Intent(SelectActivity.this, TravelActivity.class);
        startActivity(intent);
    }

    /**
     * Opens Setting Activity
     * @param view current View
     */
    public void openSettings(View view) {
        Intent intent = new Intent(SelectActivity.this, ConfigurationActivity.class);
        startActivity(intent);
    }

    /**
     * Opens Player Information
     * @param view current View
     */
    public void openPlayerInfo(View view) {
        Intent intent = new Intent(SelectActivity.this, InfoActivity.class);
        startActivity(intent);
    }

    /**
     * Update changed information when activity loads again
     */
    @Override
    protected void onResume() {
        super.onResume();
        binding.nameTV.setText(viewModel.getSystemName());
        binding.techlevelTV.setText(viewModel.getTechLevelDescription());
        binding.resourcesTV.setText(viewModel.getResourceDescription());
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
    }
}