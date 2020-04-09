package edu.sharif.yousefi.first_app.home;

import android.content.Intent;
import android.graphics.drawable.LevelListDrawable;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;

import edu.sharif.yousefi.first_app.GeneralFunc;
import edu.sharif.yousefi.first_app.profile.ProfileActivity;
import edu.sharif.yousefi.first_app.R;
import edu.sharif.yousefi.first_app.add.AddActivity;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ImageView home_btn = findViewById(R.id.home_btn);
        GeneralFunc.setLevel(home_btn, 1);

        ImageView profile_btn = findViewById(R.id.profile_btn);
        GeneralFunc.setLevel(profile_btn, 0);
        profile_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, ProfileActivity.class));

            }
        });

        ImageView add_btn = findViewById(R.id.add_btn);
        GeneralFunc.setLevel(add_btn, 0);
        add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, AddActivity.class));

            }
        });

        RecyclerView recyclerView = findViewById(R.id.home_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        CardAdapter adapter = new CardAdapter(createData());
        recyclerView.setAdapter(adapter);
    }

    private ArrayList<CardContent> createData(){
        ArrayList<CardContent> c= new ArrayList<>() ;
        for (int i =0 ;i <100;i++){
            c.add(new CardContent("Name of this"+i, "explain......"+i));
        }
        return c;
    }

}
