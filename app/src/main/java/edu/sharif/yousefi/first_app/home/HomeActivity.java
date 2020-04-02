package edu.sharif.yousefi.first_app.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import edu.sharif.yousefi.first_app.profile.ProfileActivity;
import edu.sharif.yousefi.first_app.R;
import edu.sharif.yousefi.first_app.add.AddActivity;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        Button profile_btn = findViewById(R.id.profile_hm_btn);
        profile_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, ProfileActivity.class));

            }
        });

        Button add_btn = findViewById(R.id.add_hm_btn);
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
