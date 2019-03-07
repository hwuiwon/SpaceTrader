package edu.gatech.cs2340.team49x.spacetrader.Adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

import edu.gatech.cs2340.team49x.spacetrader.Objects.Universe.SolarSystem;
import edu.gatech.cs2340.team49x.spacetrader.Views.SolarSystemView;

public class SolarSystemAdapter extends BaseAdapter {

    private Context context;
    private List<SolarSystem> solarSystems = new ArrayList<>();

    public SolarSystemAdapter(Context context) {
        this.context = context;
    }

    public void addSolarSystem(SolarSystem solarSystem) {
        solarSystems.add(solarSystem);
    }

    @Override
    public int getCount() {
        return solarSystems.size();
    }

    @Override
    public Object getItem(int position) {
        return solarSystems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        SolarSystemView view;
        if (convertView == null) {
            view = new SolarSystemView(context, solarSystems.get(position));
        } else {
            view = (SolarSystemView) convertView;
            view.setData(solarSystems.get(position));
        }
        return view;
    }
}