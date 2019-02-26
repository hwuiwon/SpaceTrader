package edu.gatech.cs2340.team49x.spacetrader.Views;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;
import edu.gatech.cs2340.team49x.spacetrader.Objects.Item;
import edu.gatech.cs2340.team49x.spacetrader.R;

public class ItemView extends RelativeLayout {

    TextView itemNameTV;
    TextView itemRemainTV;
    TextView itemPriceTV;
    CircleImageView itemCIV;

    public ItemView(Context context, Item item) {
        super(context);
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.item, this, true);

        itemNameTV = findViewById(R.id.itemNameTV);
        itemRemainTV = findViewById(R.id.itemRemainTV);
        itemPriceTV = findViewById(R.id.itemPriceTV);
        itemCIV = findViewById(R.id.itemCIV);

        setData(item);
    }

    public void setData(Item item) {
        itemNameTV.setText(item.getName());
        itemRemainTV.setText(item.getRemaining());
        itemPriceTV.setText(String.valueOf(item.getPrice()));
        itemCIV.setImageBitmap(item.getItemPic());
    }
}