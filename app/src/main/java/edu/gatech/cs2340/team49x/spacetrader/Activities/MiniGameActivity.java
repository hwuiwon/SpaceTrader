package edu.gatech.cs2340.team49x.spacetrader.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

import edu.gatech.cs2340.team49x.spacetrader.Activities.Database.RegisterActivity;
import edu.gatech.cs2340.team49x.spacetrader.Model.ModelFacade;
import edu.gatech.cs2340.team49x.spacetrader.Model.PlayerInteractor;
import edu.gatech.cs2340.team49x.spacetrader.R;

public class MiniGameActivity extends AppCompatActivity {

    private int player;
    private PlayerInteractor playerInteractor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        setContentView(R.layout.activity_mini_game);
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

        TextView textView = findViewById(R.id.instruction_text_view);
        pl.droidsonroids.gif.GifImageView gifImageView = findViewById(R.id.playAgain_gif_view);

        playerInteractor.changeCredits(-100);

        if (player == 0) {
            if (computer == 0) {
                textView.setText(R.string.mg_sun_sun);
                playerInteractor.changeCredits(100);
            } else if (computer == 1) {
                textView.setText(R.string.mg_sun_moon);
            } else {
                textView.setText(R.string.mg_sun_star);
                playerInteractor.changeCredits(200);
            }
        } else if (player == 1) {
            if (computer == 0) {
                textView.setText(R.string.mg_moon_sun);
                playerInteractor.changeCredits(200);
            } else if (computer == 1) {
                textView.setText(R.string.mg_moon_moon);
                playerInteractor.changeCredits(100);
            } else {
                textView.setText(R.string.mg_moon_star);
            }
        } else {
            if (computer == 0) {
                textView.setText(R.string.mg_star_sun);
            } else if (computer == 1) {
                textView.setText(R.string.mg_star_moon);
                playerInteractor.changeCredits(200);
            } else {
                textView.setText(R.string.mg_star_star);
                playerInteractor.changeCredits(100);
            }
        }
        gifImageView.setImageResource(R.drawable.playagain);
    }

    /**
     * Plays the game again
     * @param view current View
     */
    public void playAgain(View view) {
        TextView textView = findViewById(R.id.instruction_text_view);
        textView.setText(R.string.mg_play_again + playerInteractor.getCredits());
        ImageView imageView = findViewById(R.id.playAgain_gif_view);
        imageView.setImageDrawable(null);
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