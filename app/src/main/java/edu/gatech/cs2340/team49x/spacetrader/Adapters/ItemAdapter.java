package edu.gatech.cs2340.team49x.spacetrader.Adapters;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import edu.gatech.cs2340.team49x.spacetrader.R;
import edu.gatech.cs2340.team49x.spacetrader.ViewObjects.Item;
import edu.gatech.cs2340.team49x.spacetrader.Viewmodels.MarketViewModel;

public class ItemAdapter extends ArrayAdapter<Item> {

    class ItemView extends RelativeLayout {

        private MarketViewModel viewModel = null;
        private Button tradeDecreaseBT;
        private Button tradeIncreaseBT;
        private TextView tradeCountTV;
        private TextView itemRemainTV;
        private TextView itemNameTV;
        private TextView itemPriceTV;
        private Item item = new Item(null, 0, 0);

        public ItemView(Context context) {
            super(context);
        }

        ItemView(Context context, Item item) {
            super(context);
            this.viewModel = ViewModelProviders.of((FragmentActivity) getContext()).get(MarketViewModel.class);
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            inflater.inflate(R.layout.item, this, true);

            itemNameTV = findViewById(R.id.itemNameTV);
            itemPriceTV = findViewById(R.id.itemPriceTV);
            itemRemainTV = findViewById(R.id.itemRemainTV);
            tradeCountTV = findViewById(R.id.tradeCountTV);
            tradeIncreaseBT = findViewById(R.id.tradeIncreaseBT);
            tradeDecreaseBT = findViewById(R.id.tradeDecreaseBT);
            setData(item);
        }

        void setData(Item inItem) {
            this.item = inItem;
            itemNameTV.setText(item.getName());
            itemPriceTV.setText(String.valueOf(item.getPrice()));
            update();

            tradeDecreaseBT.setOnClickListener(v -> {
                viewModel.decreaseAmount(item.getGood());
                tradeCountTV.setText(String.valueOf(viewModel.getAmountSelected(item.getGood())));
                notifyDataSetChanged();
            });

            tradeIncreaseBT.setOnClickListener(v -> {
                viewModel.increaseAmount(item.getGood());
                tradeCountTV.setText(String.valueOf(viewModel.getAmountSelected(item.getGood())));
                notifyDataSetChanged();
            });
        }

        void update() {
            this.item.setRemaining(viewModel.getCargo(item.getGood()));
            itemRemainTV.setText(String.valueOf(item.getRemaining()));
            tradeCountTV.setText(String.valueOf(viewModel.getAmountSelected(item.getGood())));
        }
    }

    public ItemAdapter(Context context, List<Item> items) {
        super(context, 0, items);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ItemView view;
        if (convertView == null) {
            view = new ItemView(getContext(), getItem(position));
        } else {
            view = (ItemView) convertView;
            view.setData(getItem(position));
        }
        return view;
    }
}