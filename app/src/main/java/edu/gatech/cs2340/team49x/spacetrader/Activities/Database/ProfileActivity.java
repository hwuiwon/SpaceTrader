package edu.gatech.cs2340.team49x.spacetrader.Activities.Database;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

import edu.gatech.cs2340.team49x.spacetrader.Model.ModelFacade;
import edu.gatech.cs2340.team49x.spacetrader.Model.PlayerInteractor;
import edu.gatech.cs2340.team49x.spacetrader.R;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth firebaseAuth;
    private Button buttonLogout;
    private DatabaseReference databaseReference;
    private Button buttonSave;
    private PlayerInteractor playerInteractor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        playerInteractor = ModelFacade.getInstance().getPlayerInteractor();
        firebaseAuth = FirebaseAuth.getInstance();

        if (firebaseAuth.getCurrentUser() == null) {
            finish();
            startActivity(new Intent(this, LoginActivity.class));
        }

        databaseReference = FirebaseDatabase.getInstance().getReference();
        buttonSave = findViewById(R.id.buttonSave);

        FirebaseUser user = firebaseAuth.getCurrentUser();
        TextView textViewUserEmail = findViewById(R.id.textViewUerEmail);
        String[] parts = Objects.requireNonNull(user.getEmail()).split("@");
        textViewUserEmail.setText(parts[0]);
        buttonLogout = findViewById(R.id.buttonLogout);

        buttonLogout.setOnClickListener(this);
        buttonSave.setOnClickListener(this);

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
        Toast.makeText(this, "Information saved...", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        if (view == buttonLogout) {
            firebaseAuth.signOut();
            finish();
            startActivity(new Intent(this, LoginActivity.class));
        }
        if (view == buttonSave) {
            saveUserInformation();
        }
    }
}
