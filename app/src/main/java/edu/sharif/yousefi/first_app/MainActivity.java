package edu.sharif.yousefi.first_app;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import edu.sharif.yousefi.first_app.account.LoginActivity;
import edu.sharif.yousefi.first_app.account.SignupActivity;

public class MainActivity extends AppCompatActivity {
    private  AnimatorSet animatorSet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button login_guid_btn = findViewById(R.id.login_guid_btn);
        login_guid_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
            }
        });

        Button signup_guid_btn = findViewById(R.id.signup_guid_btn);
        signup_guid_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SignupActivity.class));
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        final ImageView image = findViewById(R.id.android_image);
        animatorSet=(AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.x_move);
        animatorSet.setTarget(image);
        animatorSet.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        animatorSet.end();
    }
}
