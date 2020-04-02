package edu.sharif.yousefi.first_app.add;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import edu.sharif.yousefi.first_app.home.HomeActivity;
import edu.sharif.yousefi.first_app.profile.ProfileActivity;
import edu.sharif.yousefi.first_app.R;

public class AddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);


        Button profile_btn = findViewById(R.id.profile_add_btn);
        profile_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AddActivity.this, ProfileActivity.class));
            }
        });

        Button home_btn = findViewById(R.id.home_add_btn);
        home_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AddActivity.this, HomeActivity.class));
            }
        });

    }

}
