package edu.gatech.cs2340.team49x.spacetrader.Activities;

import android.arch.lifecycle.ViewModelProviders;
import android.database.DataSetObserver;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

import edu.gatech.cs2340.team49x.spacetrader.Adapters.ItemAdapter;
import edu.gatech.cs2340.team49x.spacetrader.Objects.Trading.Item;
import edu.gatech.cs2340.team49x.spacetrader.R;
import edu.gatech.cs2340.team49x.spacetrader.Viewmodels.MarketViewModel;
import edu.gatech.cs2340.team49x.spacetrader.databinding.ActivityMarketBinding;

public class MarketActivity extends AppCompatActivity {

    private ActivityMarketBinding binding;
    private MarketViewModel viewModel;
    private ArrayList<Item> items;
    private ItemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        setContentView(R.layout.activity_market);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_market);
        viewModel = ViewModelProviders.of(this).get(MarketViewModel.class);
        viewModel.init();

        items = getListItemData();
        adapter = new ItemAdapter(this, items);
        binding.itemLV.setAdapter(adapter);
        adapter.registerDataSetObserver(observer);
        binding.playerCreditTV.setText(String.valueOf(viewModel.getCredits()));
    }

    DataSetObserver observer = new DataSetObserver() {
        @Override
        public void onChanged() {
            super.onChanged();
            setPriceTotal();
        }
    };

    public void setPriceTotal() {
        binding.totalPriceTV.setText(String.valueOf(viewModel.getTotal()));
    }

    /**
     * Creates item adapter
     */
    public ArrayList<Item> getListItemData() {
        items = new ArrayList<>();
        Collections.addAll(items, viewModel.getItems());
        return items;
    }

    /**
     * Switches screen between buy and sell
     *
     * @param view current View
     */
    public void switchScreen(View view) {
        // Switch between buy and sell screen
        viewModel.toggleBuySell();
        // Update ListView with new items and change text
        refreshAdapter();
        if (viewModel.isBuying()) {
            binding.marketTV.setText(R.string.ttlCost);
            binding.switchBT.setText(R.string.switchSell);
            binding.buyBT.setText("Buy");
        } else {
            binding.marketTV.setText(R.string.ttlSale);
            binding.switchBT.setText(R.string.switchBuy);
            binding.buyBT.setText("Sell");
        }

    }

    /**
     * Check if the player can buy or sell items he/she selected and make transaction
     *
     * @param view current View
     */
    public void doTransaction(View view) {
        if (viewModel.isBuying()) {
            if (viewModel.getTotal() <= viewModel.getCredits()) {
                viewModel.done();
                refreshAdapter();
                binding.playerCreditTV.setText(String.valueOf(viewModel.getCredits()));
            } else {
                Toast.makeText(this, "Not enough credit", Toast.LENGTH_SHORT).show();
            }
        } else {
            viewModel.done();
            refreshAdapter();
            binding.playerCreditTV.setText(String.valueOf(viewModel.getCredits()));
        }
    }

    /**
     * Refreshes adapter
     */
    private void refreshAdapter() {
        adapter.clear();
        adapter.addAll(getListItemData());
        adapter.notifyDataSetChanged();
    }

    /**
     * Ends Market Activity
     *
     * @param view current View
     */
    public void done(View view) {
        finish();
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
    }
}