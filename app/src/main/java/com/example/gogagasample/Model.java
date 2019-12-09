package com.example.gogagasample;

public class Model {
    private int image;
    private String text;
    private String desc;



    public Model(int image, String text, String desc) {
        this.image = image;
        this.text= text;
        this.desc= desc;
    }



    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
