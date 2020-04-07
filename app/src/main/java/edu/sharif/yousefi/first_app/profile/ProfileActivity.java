package edu.sharif.yousefi.first_app.profile;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import edu.sharif.yousefi.first_app.R;
import edu.sharif.yousefi.first_app.add.AddActivity;
import edu.sharif.yousefi.first_app.home.HomeActivity;

public class ProfileActivity extends AppCompatActivity {
    private AnimationDrawable avatarAnimation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        Button home_button = findViewById(R.id.home_pr_btn);
        home_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfileActivity.this, HomeActivity.class));
            }
        });

        Button add_button = findViewById(R.id.add_pr_btn);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfileActivity.this, AddActivity.class));

            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        ImageView avatars = findViewById(R.id.avatar_image);
        avatars.setBackgroundResource(R.drawable.avatar_images);
        avatarAnimation=(AnimationDrawable) avatars.getBackground();
        avatarAnimation.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        avatarAnimation.stop();
    }
}
