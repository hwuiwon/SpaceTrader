package edu.gatech.cs2340.team49x.spacetrader.Activities;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import edu.gatech.cs2340.team49x.spacetrader.Adapters.InvenItemAdapter;
import edu.gatech.cs2340.team49x.spacetrader.Objects.Trading.InvenItem;
import edu.gatech.cs2340.team49x.spacetrader.R;
import edu.gatech.cs2340.team49x.spacetrader.Viewmodels.ConfigurationViewModel;
import edu.gatech.cs2340.team49x.spacetrader.databinding.ActivityInfoBinding;

public class InfoActivity extends AppCompatActivity {

    private ActivityInfoBinding binding;
    private ConfigurationViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        setContentView(R.layout.activity_info);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_info);
        viewModel = ViewModelProviders.of(this).get(ConfigurationViewModel.class);

        binding.infoNameTV.setText(viewModel.getPlayer().getName());
        if (viewModel.getPlayer().getShip().getCargo().getQuantities() != null) {
            binding.invenInfoLV.setAdapter(makeInvenItemAdapter());
        }
    }

    /**
     * Make InvenItem Adapter
     *
     * @return adapter that is created
     */
    public InvenItemAdapter makeInvenItemAdapter() {
        final InvenItemAdapter adapter = new InvenItemAdapter(this);
        for (InvenItem invenItem : viewModel.getPlayer().getShip().getCargo().getQuantities()) {
            adapter.addInvenItem(invenItem);
        }
        return adapter;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
    }
}