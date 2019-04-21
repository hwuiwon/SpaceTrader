package edu.gatech.cs2340.team49x.spacetrader.Activities;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import edu.gatech.cs2340.team49x.spacetrader.Adapters.ShipAdapter;
import edu.gatech.cs2340.team49x.spacetrader.Objects.General.Ship;
import edu.gatech.cs2340.team49x.spacetrader.R;
import edu.gatech.cs2340.team49x.spacetrader.ViewModels.ShipViewModel;
import edu.gatech.cs2340.team49x.spacetrader.databinding.ActivityShipBinding;

public class ShipActivity extends AppCompatActivity {

    private ActivityShipBinding binding;
    private ShipViewModel viewModel;
    private Ship.ShipType shipType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        setContentView(R.layout.activity_ship);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_ship);
        viewModel = ViewModelProviders.of(this).get(ShipViewModel.class);
        binding.shipSelectLV.setAdapter(new ShipAdapter(this, viewModel.getShipList()));
        binding.currentShipTV.setText(viewModel.getShipType().name());
        binding.currentCreditTV.setText(String.valueOf(viewModel.getCredits()));
        binding.shipSelectLV.setOnItemClickListener((parent, view, position, id) ->
                onItemClicked(position));
    }

    private void onItemClicked(int position) {
        shipType = (Ship.ShipType) binding.shipSelectLV.getItemAtPosition(position);
    }

    public void buyShip(View view) {
        viewModel.setShipType(shipType);
        viewModel.maxFuel();
        binding.currentShipTV.setText(viewModel.getShipType().name());
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
    }
}