package com.example.zhigan.api;

import com.example.zhigan.MyApp;
import com.example.zhigan.util.StateUtils;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 朱文祥 on 2016/9/21.
 */
public class ApiRetrofit {
    public static final String ZHIHU_BASE_URL = "http://news-at.zhihu.com/api/4/";
    public static final String GANK_BASE_URL = "http://gank.io/api/";
    public static final String DAILY_BASE_URL = "http://app3.qdaily.com/app3/";
    private final ZhihuApi zhihuApiService;

    public ZhihuApi getZhihuApiService() {
        return zhihuApiService;
    }

    /**
     * 构造方法
     */
    ApiRetrofit() {
        File httpCacheDirectory = new File(MyApp.mContext.getCacheDir(), "responses");
        int cacheSize = 10 * 1024 * 1024;//10 MB
        Cache cache = new Cache(httpCacheDirectory, cacheSize);

        //配置OkHttpClient
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(REWRITE_CACHE_CONTROL_INTERCEPTOR)
                .addNetworkInterceptor(REWRITE_CACHE_CONTROL_INTERCEPTOR)
                .cache(cache)
                .build();

        Retrofit retrofit_zhihu = new Retrofit.Builder()
                .baseUrl(ZHIHU_BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        Retrofit retrofit_gank = new Retrofit.Builder()
                .baseUrl(GANK_BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        Retrofit retrofit_daily= new Retrofit.Builder()
                .baseUrl(DAILY_BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        zhihuApiService = retrofit_zhihu.create(ZhihuApi.class);
        // TODO: 2016/9/22  GankApi 和 DailyApi的interface
    }


    Interceptor REWRITE_CACHE_CONTROL_INTERCEPTOR=new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            /*CacheControl.Builder cacheBuilder = new CacheControl.Builder();
            cacheBuilder.maxAge(0, TimeUnit.SECONDS);
            cacheBuilder.maxStale(365, TimeUnit.DAYS);
            CacheControl cacheControl = cacheBuilder.build();*/
            Response originalResponse = chain.proceed(chain.request());
            if (StateUtils.isNetworkAvailable(MyApp.mContext)) {
                int maxAge = 60;//在线缓存在1分钟内可读取
                return originalResponse.newBuilder()
                        .removeHeader("Pragma")
                        .removeHeader("Cache-Control")
                        .header("Cache-Control", "public, max-age=" + maxAge)
                        .build();
            } else {
                int maxStale = 60 * 60 * 24 * 28; // 离线时缓存保存4周
                return originalResponse.newBuilder()
                        .removeHeader("Pragma")
                        .removeHeader("Cache-Control")
                        .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                        .build();
            }
        }
    };

}
