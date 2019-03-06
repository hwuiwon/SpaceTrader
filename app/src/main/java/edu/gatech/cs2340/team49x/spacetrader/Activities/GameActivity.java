package edu.gatech.cs2340.team49x.spacetrader.Activities;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import edu.gatech.cs2340.team49x.spacetrader.Adapters.SolarSystemAdapter;
import edu.gatech.cs2340.team49x.spacetrader.Objects.Universe.SolarSystem;
import edu.gatech.cs2340.team49x.spacetrader.R;
import edu.gatech.cs2340.team49x.spacetrader.Viewmodels.ConfigurationViewModel;

public class GameActivity extends AppCompatActivity {

    private ListView planetSelectLV;
    private ConfigurationViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        viewModel = ViewModelProviders.of(this).get(ConfigurationViewModel.class);
        planetSelectLV = findViewById(R.id.planetSelectLV);
        planetSelectLV.setAdapter(makePlanetAdapter());
    }

    public SolarSystemAdapter makePlanetAdapter() {
        final SolarSystemAdapter adapter = new SolarSystemAdapter(this);
        for (SolarSystem system : viewModel.getUniverse().getSolarSystems()) {
            adapter.addSolarSystem(system);
        }
        return adapter;
    }
}