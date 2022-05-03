package com.example.nidaapp2;

public class category {
    int catImage;
    String catName;
    float catfee;
    String catDescription;

    public category(int catImage, String catName, float catfee, String catDescription) {
        this.catImage = catImage;
        this.catName = catName;
        this.catfee = catfee;
        this.catDescription = catDescription;
    }

    public int getCatImage() {
        return catImage;
    }

    public void setCatImage(int catImage) {
        this.catImage = catImage;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public float getCatfee() {
        return catfee;
    }

    public void setCatfee(float catfee) {
        this.catfee = catfee;
    }

    public String getCatDescription() {
        return catDescription;
    }

    public void setCatDescription(String catDescription) {
        this.catDescription = catDescription;
    }
}




