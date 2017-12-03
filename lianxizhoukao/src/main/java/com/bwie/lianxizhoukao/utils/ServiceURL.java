package com.bwie.lianxizhoukao.utils;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by lenovo on 2017/12/2.
 */

public interface ServiceURL {
    @GET(UtilsAPI.TAGS)
    Call<Bean> bean();
//@GET("api/data/Android/{size}/{page}")
//Call<Bean> tagList(@Path("size") int size, @Path("page") int page);
}
