package edu.gatech.cs2340.team49x.spacetrader.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import edu.gatech.cs2340.team49x.spacetrader.Objects.General.Ship;
import edu.gatech.cs2340.team49x.spacetrader.R;

public class ShipAdapter extends ArrayAdapter<Ship.ShipType> {

    class ShipView extends RelativeLayout {

        TextView shipTV;

        public ShipView(Context context) {
            super(context);
        }

        ShipView(Context context, Ship.ShipType shipType) {
            super(context);
            LayoutInflater inflater =
                    (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            inflater.inflate(R.layout.ship, this, true);
            shipTV = findViewById(R.id.shipTV);
            setData(shipType);
        }

        void setData(Ship.ShipType shipType) {
            shipTV.setText(shipType.name());
        }
    }

    /**
     * Default constructor
     * @param context context
     * @param shipTypes list of ship types
     */
    public ShipAdapter(Context context, List<Ship.ShipType> shipTypes) {
        super(context, 0, shipTypes);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        ShipView view;
        if (convertView == null) {
            view = new ShipView(getContext(), getItem(position));
        } else {
            view = (ShipView) convertView;
            view.setData(getItem(position));
        }
        return view;
    }
}