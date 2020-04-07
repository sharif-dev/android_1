package edu.sharif.yousefi.first_app.add;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import edu.sharif.yousefi.first_app.R;


public class AddFragment extends Fragment {
    private SendMessageF mCallback;
    private ImageView selection;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.add_fragment, container, false);
        selection=view.findViewById(R.id.selection_img);
        Animation jump = AnimationUtils.loadAnimation(view.getContext(), R.anim.y_move_alpha);
        selection.startAnimation(jump);

        Button result_btn = view.findViewById(R.id.result_btn);
        result_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView name = view.findViewById(R.id.name_inp_add);
                TextView explain = view.findViewById(R.id.explain_inp_add);
                ImageView image = view.findViewById(R.id.profile_img_add);
                mCallback.sendName(name.getText().toString());
                mCallback.sendExplain(explain.getText().toString());
                // mCallback.sendImage(image.);
            }
        });
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof SendMessageF) {
// context (here is addActivity is set as call back cause when call mcallback methods calls addActivity methods
            mCallback = (SendMessageF) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnGreenFragmentListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mCallback = null;
        selection.setAnimation(null);
    }
}

