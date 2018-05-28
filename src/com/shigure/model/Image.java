package com.shigure.model;

public class Image {
    private int imageId;
    private String imagePath;

    public Image() {
    }

    public Image(int imageId, String imagePath) {
        this.imageId = imageId;
        this.imagePath = imagePath;
    }

    public Image(String imagePath) {
        this.imagePath = imagePath;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
