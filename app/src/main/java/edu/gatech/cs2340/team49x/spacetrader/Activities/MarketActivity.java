package edu.gatech.cs2340.team49x.spacetrader.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import edu.gatech.cs2340.team49x.spacetrader.Adapters.ItemAdapter;
import edu.gatech.cs2340.team49x.spacetrader.Objects.Item;
import edu.gatech.cs2340.team49x.spacetrader.R;

public class MarketActivity extends AppCompatActivity {

    private ListView itemLV;
    private Item[] items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market);
        itemLV = findViewById(R.id.itemLV);
        itemLV.setAdapter(makeItemAdapter());
    }

    /**
     * Creates item adapter
     */
    public ItemAdapter makeItemAdapter() {
        final ItemAdapter adapter = new ItemAdapter(this);

        // Need to create items depending on resources and tech level and add them to Item[] items

        for (Item item : items) {
            adapter.addItem(item);
        }
        return adapter;
    }

    /**
     * Switches screen between buy and sell
     *
     * @param view current View
     */
    public void switchScreen(View view) {
        // Switch between buy and sell screen
        // Update Listview with new items and change text
    }

    /**
     * Check if the player can buy items he/she selected and make transaction
     *
     * @param view current View
     */
    public void buy(View view) {
        // Buy items if player has enough credits
    }
}