package edu.sharif.yousefi.first_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final Button login_btn = findViewById(R.id.signup_btn);
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText userName = findViewById(R.id.username_inp_su);
                EditText email = findViewById(R.id.email_inp_su);
                EditText password = findViewById(R.id.pass_inp_su);

                Editable usernameText = userName.getText();
                Editable emailText = email.getText();
                Editable passwordText = password.getText();

                if ( usernameText== null || emailText == null  || passwordText == null ){
                    Toast toast=Toast.makeText(getApplicationContext(),R.string.Login_error,Toast.LENGTH_SHORT);
                    toast.setMargin(50,50);
                    toast.show();
                }
                else {
                    try {
                        ProgressBar pb = findViewById(R.id.progressBar_su);
                        pb.setVisibility(View.VISIBLE);

                        final User user = new User(userName.getText().toString(),
                                email.getText().toString(),
                                password.getText().toString());
                            new Thread(){
                                @Override
                                public void run() {
                                    Intent email_send = new Intent(Intent.ACTION_SEND);
                                    email_send.putExtra(Intent.EXTRA_EMAIL, new String[]{ user.getEmail()});
                                    email_send.putExtra(Intent.EXTRA_SUBJECT, "Sign up");
                                    email_send.putExtra(Intent.EXTRA_TEXT, "Welcome to our App");

//need this to prompts email client only
                                    email_send.setType("message/rfc822");
                                    try {
                                        startActivity(Intent.createChooser(email_send, "Send mail..."));
                                        finish();
                                    }catch (android.content.ActivityNotFoundException ex){
                                        Toast.makeText(SignupActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();

                                    }
                                }
                            }.start();

                        pb.setVisibility(View.GONE);
                        startActivity(new Intent(SignupActivity.this, ProfileActivity.class));

                    }catch (Exception e){
                        Toast toast=Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT);
                        toast.setMargin(50,50);
                        toast.show();
                    }
                }
            }
        });

    }


}
