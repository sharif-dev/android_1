package edu.sharif.yousefi.first_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import edu.sharif.yousefi.first_app.account.LoginActivity;
import edu.sharif.yousefi.first_app.account.SignupActivity;

public class MainActivity extends AppCompatActivity {

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


}
