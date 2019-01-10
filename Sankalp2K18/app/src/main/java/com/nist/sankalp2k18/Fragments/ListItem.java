package com.nist.sankalp2k18.Fragments;

public class ListItem {
    String title;
    int imageID;

    public ListItem(String title, int imageID) {
        this.title = title;
        this.imageID = imageID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }
}
