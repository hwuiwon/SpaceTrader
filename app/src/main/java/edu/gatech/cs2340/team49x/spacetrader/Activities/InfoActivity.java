package edu.gatech.cs2340.team49x.spacetrader.Activities;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import edu.gatech.cs2340.team49x.spacetrader.Adapters.InvenItemAdapter;
import edu.gatech.cs2340.team49x.spacetrader.ViewObjects.InvenItem;
import edu.gatech.cs2340.team49x.spacetrader.R;
import edu.gatech.cs2340.team49x.spacetrader.Viewmodels.InfoViewModel;
import edu.gatech.cs2340.team49x.spacetrader.databinding.ActivityInfoBinding;

public class InfoActivity extends AppCompatActivity {

    private InfoViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        setContentView(R.layout.activity_info);

        ActivityInfoBinding binding =
                DataBindingUtil.setContentView(this, R.layout.activity_info);
        viewModel = ViewModelProviders.of(this).get(InfoViewModel.class);
        viewModel.init();

        binding.infoNameTV.setText(viewModel.getName());
        binding.invenInfoLV.setAdapter(makeInvenItemAdapter());
        binding.totalInvenTV.setText(String.valueOf(viewModel.getPlayer().getCredits()));
    }

    /**
     * Make InvenItem Adapter
     *
     * @return adapter that is created
     */
    private InvenItemAdapter makeInvenItemAdapter() {
        final InvenItemAdapter adapter = new InvenItemAdapter(this);
        for (InvenItem invenItem : viewModel.getInvenItems()) {
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