package com.jellyfishmix.gouhaitakeaway.dto;

import java.io.InputStream;

public class ImageHolder {
    private String imageName;
    private InputStream imageFileStream;

    public ImageHolder(String imageName, InputStream imageFileStream) {
        this.imageName = imageName;
        this.imageFileStream = imageFileStream;
    }

    // Getter & Setter

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public InputStream getImageFileStream() {
        return imageFileStream;
    }

    public void setImageFileStream(InputStream imageFileStream) {
        this.imageFileStream = imageFileStream;
    }
}
