package edu.sharif.yousefi.first_app.add;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import edu.sharif.yousefi.first_app.R;


public class ShowFragment extends Fragment {
    private TextView nameView;
    private TextView explainView;
    private ImageView imageView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.show_fragment, container, false);
        nameView= view.findViewById(R.id.name_card);
        explainView = view.findViewById(R.id.explain_card);
        imageView = view.findViewById(R.id.image_card);
        return view;
    }

    public void gotName(String name){
        nameView.setText(name);
    }
    public void gotExplain(String explain){
        explainView.setText(explain);
    }
    public void gotImage(int image){
        imageView.setImageResource(image);
    }
}

