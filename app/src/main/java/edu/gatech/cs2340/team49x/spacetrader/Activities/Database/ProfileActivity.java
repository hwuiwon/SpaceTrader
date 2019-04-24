package edu.gatech.cs2340.team49x.spacetrader.Activities.Database;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

import edu.gatech.cs2340.team49x.spacetrader.Model.ModelFacade;
import edu.gatech.cs2340.team49x.spacetrader.Model.PlayerInteractor;
import edu.gatech.cs2340.team49x.spacetrader.R;
import edu.gatech.cs2340.team49x.spacetrader.databinding.ActivityProfileBinding;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityProfileBinding binding;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;
    private PlayerInteractor playerInteractor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        setContentView(R.layout.activity_profile);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_profile);
        playerInteractor = ModelFacade.getInstance().getPlayerInteractor();
        firebaseAuth = FirebaseAuth.getInstance();

        if (firebaseAuth.getCurrentUser() == null) {
            finish();
            startActivity(new Intent(this, LoginActivity.class));
        }
        databaseReference = FirebaseDatabase.getInstance().getReference();

        FirebaseUser user = firebaseAuth.getCurrentUser();
        String[] parts = Objects.requireNonNull(user.getEmail()).split("@");
        binding.userEmailTV.setText(parts[0]);
        binding.logoutBT.setOnClickListener(this);
        binding.saveBT.setOnClickListener(this);
    }

    /**
     * Saves user information
     */
    private void saveUserInformation() {
        UserInformation userInfo = new UserInformation(playerInteractor.getName(),
                playerInteractor.getFuel(), playerInteractor.getSpeed(),
                playerInteractor.getMaxTravelDistance(), playerInteractor.getCredits(),
                playerInteractor.getCargoRemaining(), playerInteractor.getPilotPt(),
                playerInteractor.getTradePt());

        FirebaseUser user = firebaseAuth.getCurrentUser();
        if (user != null) {
            databaseReference.child(user.getUid()).setValue(userInfo);
        }
        Toast.makeText(this, R.string.profile_infoSave, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        if (view == binding.logoutBT) {
            firebaseAuth.signOut();
            finish();
            startActivity(new Intent(this, LoginActivity.class));
        } else if (view == binding.saveBT) {
            saveUserInformation();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
    }
}