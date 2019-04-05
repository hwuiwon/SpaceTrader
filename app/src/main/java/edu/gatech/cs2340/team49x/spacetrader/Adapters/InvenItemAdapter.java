package edu.gatech.cs2340.team49x.spacetrader.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import edu.gatech.cs2340.team49x.spacetrader.R;
import edu.gatech.cs2340.team49x.spacetrader.ViewObjects.InvenItem;

public class InvenItemAdapter extends BaseAdapter {

    class InvenItemView extends RelativeLayout {

        final private TextView invenNameTV;
        final private TextView invenQuantityTv;

        InvenItemView(Context context, InvenItem invenItem) {
            super(context);

            LayoutInflater inflater =
                    (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            inflater.inflate(R.layout.invenitem, this, true);
            invenNameTV = findViewById(R.id.invenNameTV);
            invenQuantityTv = findViewById(R.id.invenQuantityTV);
            setData(invenItem);
        }

        void setData(InvenItem invenItem) {
            invenNameTV.setText(invenItem.getName());
            invenQuantityTv.setText(String.valueOf(invenItem.getQuantity()));
        }
    }

    private final Context context;
    private final ArrayList<InvenItem> invenItems = new ArrayList<>();

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