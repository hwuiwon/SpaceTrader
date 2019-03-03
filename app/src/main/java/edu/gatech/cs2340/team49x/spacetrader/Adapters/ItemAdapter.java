package edu.gatech.cs2340.team49x.spacetrader.Adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

import edu.gatech.cs2340.team49x.spacetrader.Objects.Item;
import edu.gatech.cs2340.team49x.spacetrader.Views.ItemView;

public class ItemAdapter extends BaseAdapter {

    private Context context;
    private List<Item> items = new ArrayList<>();

    public ItemAdapter(Context context) {
        this.context = context;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ItemView itemView;
        if (convertView == null) {
            itemView = new ItemView(context, items.get(position));
        } else {
            itemView = (ItemView) convertView;
            itemView.setData(items.get(position));
        }
        return itemView;
    }
}