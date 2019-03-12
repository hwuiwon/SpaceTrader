package edu.gatech.cs2340.team49x.spacetrader.Activities;

import android.arch.lifecycle.ViewModelProviders;
import android.content.DialogInterface;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;

import java.util.ArrayList;

import edu.gatech.cs2340.team49x.spacetrader.Adapters.SolarSystemAdapter;
import edu.gatech.cs2340.team49x.spacetrader.Objects.Universe.SolarSystem;
import edu.gatech.cs2340.team49x.spacetrader.R;
import edu.gatech.cs2340.team49x.spacetrader.Viewmodels.ConfigurationViewModel;
import edu.gatech.cs2340.team49x.spacetrader.databinding.ActivityGameBinding;

public class TravelActivity extends AppCompatActivity {

    // activity_game.xml

    private ActivityGameBinding binding;
    private ConfigurationViewModel viewModel;
    private ArrayList<SolarSystem> solarSystems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_game);
        viewModel = ViewModelProviders.of(this).get(ConfigurationViewModel.class);
        solarSystems = getListItemData();
        binding.planetSelectLV.setAdapter(new SolarSystemAdapter(this, solarSystems));
        binding.currentSystemTV.setText(viewModel.getCurrentSystem().getName());

        binding.planetSelectLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final int pos = position;
                final double distance = viewModel.getUniverse().getSolarSystem(position).getCoordinate()
                        .getDistance(viewModel.getCurrentSystem().getCoordinate());
                AlertDialog.Builder builder = new AlertDialog.Builder(TravelActivity.this);
                builder.setCancelable(true);
                builder.setTitle("Traveling...");
                builder.setMessage("Distance: " + distance + " km\nEstimated time: "
                        + (int) distance / viewModel.getPlayer().getShip().getSpeed() + " seconds");
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                final AlertDialog alertDialog = builder.create();
                alertDialog.show();

                final Handler handler = new Handler();
                final Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        if (alertDialog.isShowing()) {
                            alertDialog.dismiss();
                            viewModel.setCurrentSystem(viewModel.getUniverse().getSolarSystem(pos));
                            binding.currentSystemTV.setText(viewModel.getCurrentSystem().getName());
                        }
                    }
                };

                alertDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialog) {
                        handler.removeCallbacks(runnable);
                    }
                });
                handler.postDelayed(runnable, (int) (distance
                        / viewModel.getPlayer().getShip().getSpeed()) * 1000);
            }
        });
    }

    /**
     * Creates SolarSystem Adapter
     */
    public ArrayList<SolarSystem> getListItemData() {
        solarSystems = new ArrayList<>();
        solarSystems.addAll(viewModel.getUniverse().getSolarSystems());
        return solarSystems;
    }

    /**
     * Starts Market Activity
     *
     * @param view current View
     */
    public void enterMarket(View view) {
        Intent intent = new Intent(TravelActivity.this, MarketActivity.class);
        startActivity(intent);
    }
}