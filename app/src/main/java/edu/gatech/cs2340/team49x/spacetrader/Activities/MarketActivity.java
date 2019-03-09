package edu.gatech.cs2340.team49x.spacetrader.Activities;

import android.arch.lifecycle.ViewModelProviders;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import edu.gatech.cs2340.team49x.spacetrader.Adapters.ItemAdapter;
import edu.gatech.cs2340.team49x.spacetrader.Objects.Item;
import edu.gatech.cs2340.team49x.spacetrader.R;
import edu.gatech.cs2340.team49x.spacetrader.Viewmodels.ConfigurationViewModel;
import edu.gatech.cs2340.team49x.spacetrader.Viewmodels.MarketViewModel;

public class MarketActivity extends AppCompatActivity {

    private MarketViewModel viewModel;
    private ArrayList<Item> items;
    private ListView itemLV;
    private ItemAdapter adapter;
    private TextView totalPriceTV;
    private TextView playerCreditTV;
    private TextView totalTextTV;
    private Button switchBT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market);

        viewModel = ViewModelProviders.of(this).get(MarketViewModel.class);
        viewModel.init();

        itemLV = findViewById(R.id.itemLV);
        items = getListItemData();
        adapter = new ItemAdapter(this, items);
        itemLV.setAdapter(adapter);
        adapter.registerDataSetObserver(observer);
        totalPriceTV = findViewById(R.id.totalPriceTV);
        totalTextTV = findViewById(R.id.marketTV);
        switchBT = findViewById(R.id.switchBT);
        playerCreditTV = findViewById(R.id.playerCreditTV);
        playerCreditTV.setText(String.valueOf(viewModel.getCredits()));
    }

    DataSetObserver observer = new DataSetObserver() {
        @Override
        public void onChanged() {
            super.onChanged();
            setPriceTotal();
        }
    };

    public void setPriceTotal() {
        totalPriceTV.setText(String.valueOf(viewModel.getTotal()));
    }

    /**
     * Creates item adapter
     */
    public ArrayList<Item> getListItemData() {
        items = new ArrayList<>();
        for (Item item : viewModel.getItems()) {
            items.add(item);
        }
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
            totalTextTV.setText("Total Cost:\t");
            switchBT.setText("Switch to Sell");
        } else {
            totalTextTV.setText("Total Sale:\t");
            switchBT.setText("Switch to Buy");
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
                playerCreditTV.setText(String.valueOf(viewModel.getCredits()));
            } else {
                Toast.makeText(this, "Not enough credit", Toast.LENGTH_SHORT).show();
            }
        } else {
            // Selling function
            viewModel.done();
            refreshAdapter();
            playerCreditTV.setText(String.valueOf(viewModel.getCredits()));
        }
    }

    private void refreshAdapter() {
        adapter.clear();
        adapter.addAll(getListItemData());
        adapter.notifyDataSetChanged();
    }
}