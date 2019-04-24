package edu.gatech.cs2340.team49x.spacetrader.Activities.Database;

import android.app.ProgressDialog;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import edu.gatech.cs2340.team49x.spacetrader.R;
import edu.gatech.cs2340.team49x.spacetrader.databinding.ActivityRegisterBinding;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityRegisterBinding binding;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_register);

        firebaseAuth = FirebaseAuth.getInstance();
        if (firebaseAuth.getCurrentUser() != null) {
            finish();
            startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
        }

        progressDialog = new ProgressDialog(this);

        binding.regBT.setOnClickListener(this);
        binding.rSignInTV.setOnClickListener(this);
    }

    /**
     * Registers user
     */
    private void registerUser() {
        String email = binding.rEmailET.getText().toString().trim();
        String password = binding.rPasswordET.getText().toString().trim();

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, R.string.login_enterE, Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, R.string.login_enterP, Toast.LENGTH_SHORT).show();
            return;
        }

        progressDialog.setMessage(String.valueOf(R.string.reg_sending));
        progressDialog.show();
        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, task -> {
                    {
                        if (task.isSuccessful()) {
                            finish();
                            startActivity(
                                    new Intent(getApplicationContext(), ProfileActivity.class));
                            Toast.makeText(RegisterActivity.this,
                                    R.string.reg_success, Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(RegisterActivity.this,
                                    R.string.reg_fail, Toast.LENGTH_SHORT).show();
                        }
                        progressDialog.dismiss();
                    }
                });
    }

    @Override
    public void onClick(View view) {
        if (view == binding.regBT) {
            registerUser();
        } else if (view == binding.rSignInTV) {
            startActivity(new Intent(this, LoginActivity.class));
        }
    }
}