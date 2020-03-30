package edu.sharif.yousefi.first_app;

public class CardContent {
    private int image;
    private String name;
    private String explain;

    public CardContent(String name, String explain){
        this.name = name;
        this.explain = explain;
        this.image = R.drawable.ic_launcher_background;
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
