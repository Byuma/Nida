package com.example.nidaapp2;

import android.graphics.Bitmap;

public class Gallery {
    String GalleryName;
    String GalleryType;
    String GalleryDescr;
    Bitmap bitmapImage;

    public Gallery(String galleryName, String galleryType, String galleryDescr, Bitmap bitmapImage) {
        GalleryName = galleryName;
        GalleryType = galleryType;
        GalleryDescr = galleryDescr;
        this.bitmapImage = bitmapImage;
    }

    public String getGalleryName() {
        return GalleryName;
    }

    public void setGalleryName(String galleryName) {
        GalleryName = galleryName;
    }

    public String getGalleryType() {
        return GalleryType;
    }

    public void setGalleryType(String galleryType) {
        GalleryType = galleryType;
    }

    public String getGalleryDescr() {
        return GalleryDescr;
    }

    public void setGalleryDescr(String galleryDescr) {
        GalleryDescr = galleryDescr;
    }

    public Bitmap getBitmapImage() {
        return bitmapImage;
    }

    public void setBitmapImage(Bitmap bitmapImage) {
        this.bitmapImage = bitmapImage;
    }
}
