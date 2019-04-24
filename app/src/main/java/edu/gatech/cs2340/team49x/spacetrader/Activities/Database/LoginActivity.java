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
import edu.gatech.cs2340.team49x.spacetrader.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityLoginBinding binding;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        firebaseAuth = FirebaseAuth.getInstance();

        if (firebaseAuth.getCurrentUser() != null) {
            finish();
            startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
        }
        progressDialog = new ProgressDialog(this);
        binding.signInBT.setOnClickListener(this);
        binding.signUpTV.setOnClickListener(this);
    }

    /**
     * User Login
     */
    private void userLogin() {
        String email = binding.emailET.getText().toString().trim();
        String password = binding.passwordET.getText().toString().trim();

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, R.string.login_enterE, Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, R.string.login_enterP, Toast.LENGTH_SHORT).show();
            return;
        }

        progressDialog.setMessage(String.valueOf(R.string.login_check));
        progressDialog.show();
        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        finish();
                        startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
                    } else {
                        Toast.makeText(LoginActivity.this,
                                R.string.login_checkAgain,
                                Toast.LENGTH_SHORT).show();
                    }
                    progressDialog.dismiss();
                });
    }

    @Override
    public void onClick(View view) {
        if (view == binding.signInBT) {
            userLogin();
        } else if (view == binding.signUpTV) {
            finish();
            startActivity(new Intent(this, RegisterActivity.class));
        }
    }
}