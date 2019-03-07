package edu.gatech.cs2340.team49x.spacetrader.Activities;

import android.arch.lifecycle.ViewModelProviders;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import edu.gatech.cs2340.team49x.spacetrader.Adapters.ItemAdapter;
import edu.gatech.cs2340.team49x.spacetrader.Objects.Item;
import edu.gatech.cs2340.team49x.spacetrader.Objects.Trading.Inventory;
import edu.gatech.cs2340.team49x.spacetrader.R;
import edu.gatech.cs2340.team49x.spacetrader.Viewmodels.ConfigurationViewModel;
import edu.gatech.cs2340.team49x.spacetrader.Viewmodels.MarketViewModel;

public class MarketActivity extends AppCompatActivity {

    private ConfigurationViewModel configurationViewModel;
    private MarketViewModel viewModel;
    private ArrayList<Item> items;
    private ListView itemLV;
    private TextView totalPriceTV;
    private TextView playerCreditTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market);

        viewModel = ViewModelProviders.of(this).get(MarketViewModel.class);
        viewModel.init();
        configurationViewModel = ViewModelProviders.of(this).get(ConfigurationViewModel.class);

        itemLV = findViewById(R.id.itemLV);
        items = getListItemData();
        ItemAdapter adapter = new ItemAdapter(this, items);
        itemLV.setAdapter(adapter);
        adapter.registerDataSetObserver(observer);
        totalPriceTV = findViewById(R.id.totalPriceTV);
        playerCreditTV = findViewById(R.id.playerCreditTV);
        playerCreditTV.setText(String.valueOf(configurationViewModel.getPlayer().getCredits()));
    }

    DataSetObserver observer = new DataSetObserver() {
        @Override
        public void onChanged() {
            super.onChanged();
            setPriceTotal();
        }
    };

    public void setPriceTotal() {
        totalPriceTV.setText(String.valueOf(calculateTotalPrice()));
    }

    public int calculateTotalPrice() {
        int total = 0;
        for (Item item : items) {
            total += item.getPrice() * item.getQuantity();
        }
        viewModel.setTotal(total);
        return total;
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
    }

    /**
     * Check if the player can buy items he/she selected and make transaction
     *
     * @param view current View
     */
    public void buy(View view) {
        if (viewModel.getTotal()
                <= configurationViewModel.getPlayer().getCredits()) {
            Inventory inventory = new Inventory();
            for (Item item : items) {
                if (item.getQuantity() != 0) {
                    inventory.add(item.getName(), item.getQuantity());
                }
            }
            viewModel.setSelectedGoods(inventory);
            viewModel.done();
            finish();
        } else {
            Toast.makeText(this, "Not enough credit", Toast.LENGTH_SHORT).show();
        }
    }
}