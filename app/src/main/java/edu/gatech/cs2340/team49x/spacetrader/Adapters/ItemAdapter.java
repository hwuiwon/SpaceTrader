package edu.gatech.cs2340.team49x.spacetrader.Adapters;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import edu.gatech.cs2340.team49x.spacetrader.Objects.Item;
import edu.gatech.cs2340.team49x.spacetrader.R;
import edu.gatech.cs2340.team49x.spacetrader.Viewmodels.MarketViewModel;

public class ItemAdapter extends ArrayAdapter<Item> {

    private MarketViewModel viewModel;
    private Context context;
    private List<Item> items;
    private Button tradeDecreaseBT;
    private Button tradeIncreaseBT;
    private TextView tradeCountTV;
    private TextView itemRemainTV;
    private TextView itemNameTV;
    private TextView itemPriceTV;

    public ItemAdapter(Context context, List<Item> items) {
        super(context, 0, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        viewModel = ViewModelProviders.of((FragmentActivity) getContext()).get(MarketViewModel.class);
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext())
                    .inflate(R.layout.item,parent,false);
        }

        final Item currentItem = getItem(position);

        itemNameTV = listItemView.findViewById(R.id.itemNameTV);
        itemPriceTV = listItemView.findViewById(R.id.itemPriceTV);
        itemRemainTV = listItemView.findViewById(R.id.itemRemainTV);
        tradeCountTV = listItemView.findViewById(R.id.tradeCountTV);
        tradeIncreaseBT = listItemView.findViewById(R.id.tradeIncreaseBT);
        tradeDecreaseBT = listItemView.findViewById(R.id.tradeDecreaseBT);

        itemNameTV.setText(currentItem.getName());
        itemPriceTV.setText(String.valueOf(currentItem.getPrice()));
        itemRemainTV.setText(String.valueOf(currentItem.getRemaining()));

        tradeDecreaseBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentItem.removeQuantity();
                tradeCountTV.setText(Integer.toString(currentItem.getQuantity()));
                notifyDataSetChanged();
            }
        });

        tradeIncreaseBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentItem.addQuantity();
                tradeCountTV.setText(Integer.toString(currentItem.getQuantity()));
                notifyDataSetChanged();
            }
        });

        return listItemView;
    }
}