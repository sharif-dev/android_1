package edu.sharif.yousefi.first_app.profile;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.LevelListDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import edu.sharif.yousefi.first_app.GeneralFunc;
import edu.sharif.yousefi.first_app.R;
import edu.sharif.yousefi.first_app.add.AddActivity;
import edu.sharif.yousefi.first_app.home.HomeActivity;
import edu.sharif.yousefi.first_app.setting.SettingActivity;

public class ProfileActivity extends AppCompatActivity {
    private AnimationDrawable avatarAnimation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        ImageView profile_btn = findViewById(R.id.profile_btn);
        GeneralFunc.setLevel(profile_btn, 1);


        ImageView home_button = findViewById(R.id.home_btn);
        GeneralFunc.setLevel(home_button, 0);
        home_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfileActivity.this, HomeActivity.class));
            }
        });

        ImageView add_button = findViewById(R.id.add_btn);
        GeneralFunc.setLevel(add_button, 0);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfileActivity.this, AddActivity.class));

            }
        });

        ImageView setting_button = findViewById(R.id.setting_btn);
        GeneralFunc.setLevel(setting_button, 0);
        setting_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfileActivity.this, SettingActivity.class));

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
