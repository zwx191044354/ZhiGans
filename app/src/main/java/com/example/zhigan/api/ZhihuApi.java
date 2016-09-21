package com.example.zhigan.api;

import com.example.zhigan.bean.News;
import com.example.zhigan.bean.NewsTimeLine;
import com.example.zhigan.bean.SplashImage;


import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by 朱文祥 on 2016/9/22.
 */
public interface ZhihuApi {
    @GET("start-image/1080*1920")
    Observable<SplashImage> getSplashImage();

    @GET("news/latest")
    Observable<NewsTimeLine> getLatestNews();

    @GET("news/before/{time}")
    Observable<NewsTimeLine> getBeforetNews(@Path("time") String time);

    @GET("news/{id}")
    Observable<News> getDetailNews(@Path("id") String id);
}
