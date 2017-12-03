package com.bwie.retorfitlian.network;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by lenovo on 2017/12/1.
 */

public class RetrofitHelper {
    private static OkHttpClient okHttpClient;
  private static ServiceAPI serviceAPI;
    private static ServiceAPI api;
    static {
        initOkhttpClient();
    }
    private static OkHttpClient initOkhttpClient() {
        if (okHttpClient==null){
            synchronized (RetrofitHelper.class){
                if (okHttpClient==null){
                    okHttpClient=new OkHttpClient.Builder()
                            .build();
                }

            }
        }
        return okHttpClient;
    }
public static  ServiceAPI getAPI(){
if (serviceAPI==null){
    synchronized (ServiceAPI.class){
        if (serviceAPI==null){
          api = RetrofitHelper.createAPI(ServiceAPI.class, Utils.BASE_HOST_URL);
        }
    }
}
    return  api;
}
    /**
     *
     * @param clzz
     * @param url
     * @param <T>
     * @return
     */
    public static  <T> T createAPI(Class<T> clzz,String url){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(Utils.BASE_HOST_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return  retrofit.create(clzz);
    }
}
