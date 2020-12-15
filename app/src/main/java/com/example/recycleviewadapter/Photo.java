package com.example.recycleviewadapter;

public class Photo {

    private String title;
    private String subtitle;
    private Integer imageResId;

    public Photo(Integer imageResId , String title ) {
        this.title = title;
        this.imageResId = imageResId;
    }
    public Photo(Integer imageResId , String title , String subtitle ) {
        this.title = title;
        this.imageResId = imageResId;
        this.subtitle = subtitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getImageResId() {
        return imageResId;
    }

    public void setImageResId(Integer imageResId) {
        this.imageResId = imageResId;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }
}
