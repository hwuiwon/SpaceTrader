package edu.gatech.cs2340.team49x.spacetrader.Activities;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.Random;

import edu.gatech.cs2340.team49x.spacetrader.Activities.Database.RegisterActivity;
import edu.gatech.cs2340.team49x.spacetrader.Model.ModelFacade;
import edu.gatech.cs2340.team49x.spacetrader.Model.PlayerInteractor;
import edu.gatech.cs2340.team49x.spacetrader.R;
import edu.gatech.cs2340.team49x.spacetrader.databinding.ActivityMiniGameBinding;

public class MiniGameActivity extends AppCompatActivity {

    private ActivityMiniGameBinding binding;
    private PlayerInteractor playerInteractor;
    private int player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        setContentView(R.layout.activity_mini_game);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_mini_game);
        playerInteractor = ModelFacade.getInstance().getPlayerInteractor();
    }

    /**
     * Picks sun
     * @param view current View
     */
    public void pickSun(View view) {
        player = 0;
        setComputer();

    }

    /**
     * Picks moon
     * @param view current View
     */
    public void pickMoon(View view) {
        player = 1;
        setComputer();
    }

    /**
     * Picks star
     * @param view current View
     */
    public void pickStar(View view) {
        player = 2;
        setComputer();
    }

    /**
     * Sets up computer
     */
    public void setComputer() {
        Random random = new Random();
        int computer = random.nextInt(3);
        playerInteractor.changeCredits(-100);

        if (player == 0) {
            if (computer == 0) {
                binding.instructionTV.setText(R.string.mg_sun_sun);
                playerInteractor.changeCredits(100);
            } else if (computer == 1) {
                binding.instructionTV.setText(R.string.mg_sun_moon);
            } else {
                binding.instructionTV.setText(R.string.mg_sun_star);
                playerInteractor.changeCredits(200);
            }
        } else if (player == 1) {
            if (computer == 0) {
                binding.instructionTV.setText(R.string.mg_moon_sun);
                playerInteractor.changeCredits(200);
            } else if (computer == 1) {
                binding.instructionTV.setText(R.string.mg_moon_moon);
                playerInteractor.changeCredits(100);
            } else {
                binding.instructionTV.setText(R.string.mg_moon_star);
            }
        } else {
            if (computer == 0) {
                binding.instructionTV.setText(R.string.mg_star_sun);
            } else if (computer == 1) {
                binding.instructionTV.setText(R.string.mg_star_moon);
                playerInteractor.changeCredits(200);
            } else {
                binding.instructionTV.setText(R.string.mg_star_star);
                playerInteractor.changeCredits(100);
            }
        }
        binding.playAgainGIF.setImageResource(R.drawable.playagain);
    }

    /**
     * Plays the game again
     * @param view current View
     */
    public void playAgain(View view) {
        binding.instructionTV.setText(R.string.mg_play_again + playerInteractor.getCredits());
        binding.playAgainGIF.setImageDrawable(null);
    }

    /**
     * Register
     * @param view current View
     */
    public void register(View view) {
        Intent intent = new Intent(MiniGameActivity.this, RegisterActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
    }
}