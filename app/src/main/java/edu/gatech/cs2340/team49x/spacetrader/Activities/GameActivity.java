package edu.gatech.cs2340.team49x.spacetrader.Activities;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import edu.gatech.cs2340.team49x.spacetrader.Adapters.SolarSystemAdapter;
import edu.gatech.cs2340.team49x.spacetrader.Objects.Universe.SolarSystem;
import edu.gatech.cs2340.team49x.spacetrader.R;
import edu.gatech.cs2340.team49x.spacetrader.Viewmodels.ConfigurationViewModel;

public class GameActivity extends AppCompatActivity {

    private ConfigurationViewModel viewModel;
    private ListView planetSelectLV;
    private TextView currentSystemTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        viewModel = ViewModelProviders.of(this).get(ConfigurationViewModel.class);
        planetSelectLV = findViewById(R.id.planetSelectLV);
        planetSelectLV.setAdapter(makePlanetAdapter());
        currentSystemTV = findViewById(R.id.currentSystemTV);
        currentSystemTV.setText(viewModel.getCurrentSystem().getName());

        planetSelectLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                viewModel.setCurrentSystem(viewModel.getUniverse().getSolarSystem(position));
                currentSystemTV.setText(viewModel.getCurrentSystem().getName());
            }
        });
    }

    public SolarSystemAdapter makePlanetAdapter() {
        final SolarSystemAdapter adapter = new SolarSystemAdapter(this);
        for (SolarSystem system : viewModel.getUniverse().getSolarSystems()) {
            adapter.addSolarSystem(system);
        }
        return adapter;
    }

    public void enterMarket(View view) {
        Intent intent = new Intent(GameActivity.this, MarketActivity.class);
        startActivity(intent);
    }
}