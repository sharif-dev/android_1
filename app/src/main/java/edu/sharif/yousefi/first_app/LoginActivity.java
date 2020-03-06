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
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    final private String apiKey = "4ec25b49-5fa0-11ea-9fa5-0200cd936042";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final Button login_btn = findViewById(R.id.login_btn);
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText userName = findViewById(R.id.username_inp);
                EditText password = findViewById(R.id.pass_inp);

                Editable usernameText = userName.getText();
                Editable passwordText = password.getText();

                if ( usernameText== null  || passwordText == null ){
                    Toast toast=Toast.makeText(getApplicationContext(),R.string.Login_error,Toast.LENGTH_SHORT);
                    toast.setMargin(50,50);
                    toast.show();
                }
                else {
                    try {
                        User user = User.find_user(usernameText.toString(), passwordText.toString());
                        String session_id=requestOtp(apiKey,user.getPhoneNumber());
                        EditText otp_inp = findViewById(R.id.otp_inp);
                        if(otp_inp.getText()!= null) {
                            verifyOtp(apiKey, session_id, otp_inp.getText().toString());
                        }

                       // startActivity(new Intent(LoginActivity.this, ProfileActivity.class));
                    }catch (Exception e){
                        Toast toast=Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT);
                        toast.setMargin(50,50);
                        toast.show();
                    }
                }
            }
        });

    }
    public String requestOtp(String API_KEY,String mobileNumber){
        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        Call<MessageResponse> call = apiService.sentOTP(API_KEY, mobileNumber);
        final StringBuilder id = new StringBuilder() ;

        call.enqueue(new Callback<MessageResponse>() {
            String sessionId;
            @Override
            public void onResponse(Call<MessageResponse> call, Response<MessageResponse> response) {
                sessionId = response.body().getDetails();
                id.append(sessionId);
                Log.d("SenderID", sessionId);
                //you may add code to automatically fetch OTP from messages.
            }

            @Override
            public void onFailure(Call<MessageResponse> call, Throwable t) {
                Log.e("ERROR", t.toString());
            }
        });
        return id.toString();
    }
    public void verifyOtp(String API_KEY, String sessionId,String user_otp){
        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        Call<MessageResponse> call = apiService.verifyOTP(API_KEY,sessionId, user_otp);

        call.enqueue(new Callback<MessageResponse>() {

            @Override
            public void onResponse(Call<MessageResponse> call, Response<MessageResponse> response) {

                try {
                    if(response.body().getStatus().equals("Success")){
                        Intent i=new Intent(LoginActivity.this,ProfileActivity.class);
                        startActivity(i);
                    }else{
                        Log.d("Failure", response.body().getDetails()+"|||"+response.body().getStatus());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<MessageResponse> call, Throwable t) {
                Log.e("ERROR", t.toString());
            }

        });
    }





}
