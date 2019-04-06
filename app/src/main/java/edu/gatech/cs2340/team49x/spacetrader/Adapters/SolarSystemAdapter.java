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

import edu.gatech.cs2340.team49x.spacetrader.Objects.Universe.SolarSystem;
import edu.gatech.cs2340.team49x.spacetrader.R;

public class SolarSystemAdapter extends ArrayAdapter<SolarSystem> {

    class SolarSystemView extends RelativeLayout {

        TextView solarSystemTV;

        public SolarSystemView(Context context) {
            super(context);
        }

        SolarSystemView(Context context, SolarSystem solarSystem) {
            super(context);
            LayoutInflater inflater =
                    (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            inflater.inflate(R.layout.solarsystem, this, true);
            solarSystemTV = findViewById(R.id.solarSystemTV);
            setData(solarSystem);
        }

        void setData(SolarSystem solarSystem) {
            solarSystemTV.setText(solarSystem.getName());
        }
    }

    public SolarSystemAdapter(Context context, List<SolarSystem> resource) {
        super(context, 0, resource);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        SolarSystemView view;
        if (convertView == null) {
            view = new SolarSystemView(getContext(), getItem(position));
        } else {
            view = (SolarSystemView) convertView;
            view.setData(getItem(position));
        }
        return view;
    }
}