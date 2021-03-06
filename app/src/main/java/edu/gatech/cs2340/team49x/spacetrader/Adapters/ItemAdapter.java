package edu.gatech.cs2340.team49x.spacetrader.Adapters;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.support.annotation.NonNull;
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
import edu.gatech.cs2340.team49x.spacetrader.ViewModels.MarketViewModel;
import edu.gatech.cs2340.team49x.spacetrader.ViewObjects.Item;

/**
 * Adapter for item ListView in MarketActivity
 */
public class ItemAdapter extends ArrayAdapter<Item> {

    class ItemView extends RelativeLayout {

        private MarketViewModel viewModel;
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
            this.viewModel = ViewModelProviders.of(
                    (FragmentActivity) getContext()).get(MarketViewModel.class);
            LayoutInflater inflater =
                    (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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
                viewModel.decreaseAmount(item.getName());
                tradeCountTV.setText(String.valueOf(viewModel.getAmountSelected(item.getName())));
                notifyDataSetChanged();
            });

            tradeIncreaseBT.setOnClickListener(v -> {
                viewModel.increaseAmount(item.getName());
                tradeCountTV.setText(String.valueOf(viewModel.getAmountSelected(item.getName())));
                notifyDataSetChanged();
            });
        }

        void update() {
            this.item.setRemaining(viewModel.getCargo(item.getName()));
            itemRemainTV.setText(String.valueOf(item.getRemaining()));
            tradeCountTV.setText(String.valueOf(viewModel.getAmountSelected(item.getName())));
        }
    }

    /**
     * Default constructor
     * @param context context
     * @param items list of items
     */
    public ItemAdapter(Context context, List<Item> items) {
        super(context, 0, items);
    }

    @NonNull
    @Override
    public View getView(final int position, View convertView, @NonNull ViewGroup parent) {
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