package edu.gatech.cs2340.team49x.spacetrader.Activities;

import android.arch.lifecycle.ViewModelProviders;
import android.content.DialogInterface;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import java.util.Random;

import edu.gatech.cs2340.team49x.spacetrader.Adapters.SolarSystemAdapter;
import edu.gatech.cs2340.team49x.spacetrader.Objects.Trading.Inventory;
import edu.gatech.cs2340.team49x.spacetrader.Objects.Trading.TradeGood;
import edu.gatech.cs2340.team49x.spacetrader.R;
import edu.gatech.cs2340.team49x.spacetrader.Viewmodels.TravelViewModel;
import edu.gatech.cs2340.team49x.spacetrader.databinding.ActivityGameBinding;

public class TravelActivity extends AppCompatActivity {

    // activity_game.xml

    private ActivityGameBinding binding;
    private TravelViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        setContentView(R.layout.activity_game);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_game);
        viewModel = ViewModelProviders.of(this).get(TravelViewModel.class);
        viewModel.init();
        binding.planetSelectLV.setAdapter(new SolarSystemAdapter(this, viewModel.getNearbySystems()));
        binding.currentSystemTV.setText(viewModel.getName());
        binding.currentFuelTV.setText(String.valueOf(viewModel.getFuel()));

        binding.planetSelectLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                final int pos = position;
                final double distance = viewModel.getDistanceTo(pos);

                if (viewModel.getFuel() >= distance) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(TravelActivity.this);
                    builder.setCancelable(true);
                    builder.setTitle("Traveling...");
                    builder.setMessage("Distance: " + distance + " km\nEstimated time: "
                            + (int) viewModel.getTimeToTravel(pos) + " seconds");
                    builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
                    final AlertDialog alertDialog = builder.create();
                    alertDialog.show();

                    final Handler handler = new Handler();
                    final Runnable runnable = new Runnable() {
                        @Override
                        public void run() {
                            if (alertDialog.isShowing()) {
                                alertDialog.dismiss();
                                viewModel.goTo(pos);
                                binding.currentSystemTV.setText(viewModel.getName());
                                binding.currentFuelTV.setText(String.valueOf(viewModel.getFuel()));
                                doRandomEvent();
                            }
                        }
                    };

                    alertDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                        @Override
                        public void onDismiss(DialogInterface dialog) {
                            handler.removeCallbacks(runnable);
                        }
                    });
                    handler.postDelayed(runnable, (int) (viewModel.getTimeToTravel(pos) * 1000));
                } else {
                    Toast.makeText(getApplicationContext(), "Not enough fuel", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    /**
     * Starts Market Activity
     *
     * @param view current View
     */
    public void enterMarket(View view) {
        Intent intent = new Intent(TravelActivity.this, MarketActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
    }

    private void doRandomEvent() {

        //Random event handling
//                    AlertDialog.Builder eventBuilder = null;
//                    switch (new Random().nextInt(10)) {
//                        case 0:
//                            viewModel.getPlayer().changeCredits(777);
//                            eventBuilder = new AlertDialog.Builder(TravelActivity.this);
//                            eventBuilder.setTitle("Congratulations!");
//                            eventBuilder.setMessage("You have found an abandoned ship!\nYou have earned" +
//                                    " 777 credits!");
//                        case 1:
//                            viewModel.getPlayer().getShip().useFuel(1000);
//                            eventBuilder = new AlertDialog.Builder(TravelActivity.this);
//                            eventBuilder.setTitle("Oops!");
//                            eventBuilder.setMessage("Meteor shower created a hole!\nYou lost 1000 extra fuel");
//                        case 2:
//                            if (viewModel.getPlayer().getShip().cargoSpaceRemaining() >= 1) {
//                                Inventory inventory = new Inventory();
//                                inventory.add(TradeGood.WATER, 1);
//                                viewModel.getPlayer().addToCargo(new Inventory());
//                            }
//                            eventBuilder = new AlertDialog.Builder(TravelActivity.this);
//                            eventBuilder.setTitle("Congratulations!");
//                            eventBuilder.setMessage("Earth is near you!\n You have obtained 1 WATER");
//                    }
        String eventTitle = viewModel.getEventTitle();
        if (eventTitle != null) {
            AlertDialog.Builder eventBuilder = new AlertDialog.Builder(TravelActivity.this);
            eventBuilder.setTitle(eventTitle);
            eventBuilder.setMessage(viewModel.getEventMessage());
            eventBuilder.setPositiveButton("Ok", ((dialog, which) -> dialog.dismiss()));
            final AlertDialog randomEvent = eventBuilder.create();
            randomEvent.show();
        }
    }
}