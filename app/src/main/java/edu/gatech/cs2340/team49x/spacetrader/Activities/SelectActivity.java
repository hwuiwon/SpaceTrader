package edu.gatech.cs2340.team49x.spacetrader.Activities;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import edu.gatech.cs2340.team49x.spacetrader.R;
import edu.gatech.cs2340.team49x.spacetrader.Viewmodels.SelectViewModel;
import edu.gatech.cs2340.team49x.spacetrader.databinding.ActivityMarketBinding;

public class SelectActivity extends AppCompatActivity {
    private SelectViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = ViewModelProviders.of(this).get(SelectViewModel.class);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        setContentView(R.layout.activity_select);
    }

    /**
     * Opens Travel Activity
     *
     * @param view current View
     */
    public void startTravel(View view) {
        Intent intent = new Intent(SelectActivity.this, TravelActivity.class);
        startActivity(intent);
    }

    /**
     * Opens Setting Activity
     *
     * @param view current View
     */
    public void openSettings(View view) {
        Intent intent = new Intent(SelectActivity.this, ConfigurationActivity.class);
        startActivity(intent);
    }

    /**
     * Opens Player Information
     *
     * @param view current View
     */
    public void openPlayerInfo(View view) {
        Intent intent = new Intent(SelectActivity.this, InfoActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
    }
}