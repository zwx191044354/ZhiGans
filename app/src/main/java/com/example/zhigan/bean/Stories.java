package com.example.zhigan.bean;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Created by 朱文祥 on 2016/9/22.
 */
public class Stories implements Serializable{
    private String ga_prefix;
    private String id;
    private String multipic;
    private String title;
    private String type;
    private String[] images;

    public String getGa_prefix() {
        return ga_prefix;
    }

    public String getId() {
        return id;
    }

    public String getMultipic() {
        return multipic;
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    public String[] getImages() {
        return images;
    }

    @Override
    public String toString() {
        return "Stories{" +
                "ga_prefix='" + ga_prefix + '\'' +
                ", id='" + id + '\'' +
                ", multipic='" + multipic + '\'' +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", images=" + Arrays.toString(images) +
                '}';
    }
}
