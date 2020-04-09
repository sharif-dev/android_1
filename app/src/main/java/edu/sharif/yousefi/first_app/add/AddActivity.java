package edu.sharif.yousefi.first_app.add;

import android.content.Intent;
import android.graphics.drawable.LevelListDrawable;
import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import edu.sharif.yousefi.first_app.GeneralFunc;
import edu.sharif.yousefi.first_app.home.HomeActivity;
import edu.sharif.yousefi.first_app.profile.ProfileActivity;
import edu.sharif.yousefi.first_app.R;

public class AddActivity extends AppCompatActivity  implements SendMessageF{
    ShowFragment showFragment;
    AddFragment addFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        ImageView add_btn = findViewById(R.id.add_btn);
        GeneralFunc.setLevel(add_btn, 1);


        final ImageView profile_btn = findViewById(R.id.profile_btn);
        GeneralFunc.setLevel(profile_btn, 0);

        profile_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AddActivity.this, ProfileActivity.class));
            }
        });

        ImageView home_btn = findViewById(R.id.home_btn);
        GeneralFunc.setLevel(home_btn, 0);
        home_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AddActivity.this, HomeActivity.class));
            }
        });


        // add fragments
        FragmentManager fragmentManager = getSupportFragmentManager();

        showFragment =  (ShowFragment) fragmentManager.findFragmentByTag("show");
        if (showFragment == null) {
            showFragment = new ShowFragment();
            fragmentManager.beginTransaction().add(R.id.show_fragment_container, showFragment, "show").commit();
        }

        addFragment = (AddFragment) fragmentManager.findFragmentByTag("add");
        if (addFragment == null) {
            addFragment = new AddFragment();
            fragmentManager.beginTransaction().add(R.id.add_fragment_container, addFragment, "add").commit();
        }
    }



    @Override
    public void sendName(String name) {
        showFragment.gotName(name);
    }

    @Override
    public void sendExplain(String explain) {
        showFragment.gotExplain(explain);
    }

    @Override
    public void sendImage(int image) {
        showFragment.gotImage(image);
    }
}
