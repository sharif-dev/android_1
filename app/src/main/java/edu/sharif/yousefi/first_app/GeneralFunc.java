package edu.sharif.yousefi.first_app;

import android.graphics.drawable.LevelListDrawable;
import android.view.View;
import android.widget.ImageView;

public class GeneralFunc {
    private static final GeneralFunc ourInstance = new GeneralFunc();

    public static GeneralFunc getInstance() {
        return ourInstance;
    }

    private GeneralFunc() {
    }

    public static void setLevel(ImageView btn, int level){
        LevelListDrawable back= (LevelListDrawable) btn.getBackground();
        back.setLevel(level);
    }
}
