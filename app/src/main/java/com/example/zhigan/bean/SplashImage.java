package com.example.zhigan.bean;

import java.io.Serializable;

/**
 * Created by 朱文祥 on 2016/9/22.
 */
public class SplashImage implements Serializable {
    private String text;//图片出处
    private String img;//图片地址

    public String getText() {
        return text;
    }

    public String getImg() {
        return img;
    }

    @Override
    public String toString() {
        return "SplashImage{" +
                "text='" + text + '\'' +
                ", img='" + img + '\'' +
                '}';
    }
}
