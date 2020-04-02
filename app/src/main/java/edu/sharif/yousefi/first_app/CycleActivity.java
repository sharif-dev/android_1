package edu.sharif.yousefi.first_app;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

public class CycleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("life cycle", "CREATE");
        setContentView(R.layout.activity_cycle);

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("life cycle", "RESUME");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("life cycle", "DESTROY");
    }

    @Override
    protected void onStart() {
        Log.d("life cycle", "START");
        super.onStart();
    }

    @Override
    protected void onStop() {
        Log.d("life cycle", "STOP");
        super.onStop();
    }

    @Override
    protected void onRestart() {
        Log.d("life cycle", "RESTART");
        super.onRestart();
    }

}
