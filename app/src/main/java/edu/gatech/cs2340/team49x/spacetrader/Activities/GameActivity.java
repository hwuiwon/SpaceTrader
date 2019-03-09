package edu.gatech.cs2340.team49x.spacetrader.Activities;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;

import java.util.ArrayList;

import edu.gatech.cs2340.team49x.spacetrader.Adapters.SolarSystemAdapter;
import edu.gatech.cs2340.team49x.spacetrader.Objects.Universe.SolarSystem;
import edu.gatech.cs2340.team49x.spacetrader.R;
import edu.gatech.cs2340.team49x.spacetrader.Viewmodels.ConfigurationViewModel;
import edu.gatech.cs2340.team49x.spacetrader.databinding.ActivityGameBinding;

public class GameActivity extends AppCompatActivity {

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
                viewModel.setCurrentSystem(viewModel.getUniverse().getSolarSystem(position));
                binding.currentSystemTV.setText(viewModel.getCurrentSystem().getName());
            }
        });
    }

    /**
     * Creates SolarSystem Adapter
     */
    public ArrayList<SolarSystem> getListItemData() {
        solarSystems = new ArrayList<>();
        for (SolarSystem system : viewModel.getUniverse().getSolarSystems()) {
            solarSystems.add(system);
        }
        return solarSystems;
    }

    /**
     * Starts Market Activity
     *
     * @param view current View
     */
    public void enterMarket(View view) {
        Intent intent = new Intent(GameActivity.this, MarketActivity.class);
        startActivity(intent);
    }
}