package edu.gatech.cs2340.team49x.spacetrader.Views;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;

import edu.gatech.cs2340.team49x.spacetrader.Objects.Universe.SolarSystem;
import edu.gatech.cs2340.team49x.spacetrader.R;

public class SolarSystemView extends RelativeLayout {

    TextView solarSystemTV;

    public SolarSystemView(Context context) {
        super(context);
    }

    public SolarSystemView(Context context, SolarSystem solarSystem) {
        super(context);
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.solarsystem, this, true);
        solarSystemTV = findViewById(R.id.solarSystemTV);
        setData(solarSystem);
    }

    public void setData(SolarSystem solarSystem) {
        solarSystemTV.setText(solarSystem.getName());
    }
}