package edu.sharif.yousefi.first_app.home;

import edu.sharif.yousefi.first_app.R;

public class CardContent {
    private int image;
    private String name;
    private String explain;

    public CardContent(String name, String explain){
        this.name = name;
        this.explain = explain;
        this.image = R.drawable.button_custom;
    }

    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }

    public String getExplain() {
        return explain;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
