package com.example.zhigan.bean;

import java.io.Serializable;

/**
 * Created by 朱文祥 on 2016/9/22.
 */
public class TopStories implements Serializable {
    private String ga_prefix;
    private String id;
    private String multipic;
    private String title;
    private String type;
    private String image;
    private String url;


    public void setUrl(String url) {
        this.url = url;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setTitle(String title) {
        this.title = title;
    }

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

    public String getImage() {
        return image;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "TopStories{" +
                "ga_prefix='" + ga_prefix + '\'' +
                ", id='" + id + '\'' +
                ", multipic='" + multipic + '\'' +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", image='" + image + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
