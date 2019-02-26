package edu.gatech.cs2340.team49x.spacetrader.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
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

        itemLV.setOnClickListener(new AdapterView.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Opens screen where user can buy selected item
            }
        });
    }

    public ItemAdapter makeItemAdapter() {
        final ItemAdapter adapter = new ItemAdapter(this);

        // Need to create items depending on resources and tech level and add them to Item[] items

        for (Item item : items) {
            adapter.addItem(item);
        }
        return adapter;
    }
}