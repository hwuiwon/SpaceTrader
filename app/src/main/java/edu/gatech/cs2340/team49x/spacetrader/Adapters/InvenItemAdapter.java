package edu.gatech.cs2340.team49x.spacetrader.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import edu.gatech.cs2340.team49x.spacetrader.Objects.Trading.InvenItem;
import edu.gatech.cs2340.team49x.spacetrader.R;

public class InvenItemAdapter extends BaseAdapter {

    class InvenItemView extends RelativeLayout {

        private TextView invenNameTV;
        private TextView invenQuantityTv;

        public InvenItemView(Context context, InvenItem invenItem) {
            super(context);

            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            inflater.inflate(R.layout.invenitem, this, true);
            invenNameTV = findViewById(R.id.invenNameTV);
            invenQuantityTv = findViewById(R.id.invenQuantityTV);
            setData(invenItem);
        }

        public void setData(InvenItem invenItem) {
            invenNameTV.setText(invenItem.getName());
            invenQuantityTv.setText(String.valueOf(invenItem.getQuantity()));
        }
    }

    private Context context;
    private ArrayList<InvenItem> invenItems = new ArrayList<>();

    public InvenItemAdapter(Context context) {
        this.context = context;
    }

    public void addInvenItem(InvenItem invenItem) {
        invenItems.add(invenItem);
    }

    @Override
    public int getCount() {
        return invenItems.size();
    }

    @Override
    public Object getItem(int position) {
        return invenItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        InvenItemView invenItemView;
        if (convertView == null) {
            invenItemView = new InvenItemView(context, invenItems.get(position));
        } else {
            invenItemView = (InvenItemView) convertView;
            invenItemView.setData(invenItems.get(position));
        }
        return invenItemView;
    }
}