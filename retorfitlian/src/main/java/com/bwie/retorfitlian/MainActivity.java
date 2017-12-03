package com.bwie.retorfitlian;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.bwie.retorfitlian.modle.Bean;
import com.bwie.retorfitlian.modle.ResPonseData;
import com.bwie.retorfitlian.modle.ResPonseDataList;
import com.bwie.retorfitlian.network.RetrofitHelper;
import com.bwie.retorfitlian.network.ServiceAPI;
import com.bwie.retorfitlian.network.Utils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         ServiceAPI api= RetrofitHelper.getAPI();
        Call<ResPonseData<List<Bean>>> tags = api.tags();
        tags.enqueue(new Callback<ResPonseData<List<Bean>>>() {
           @Override
           public void onResponse(Call<ResPonseData<List<Bean>>> call, Response<ResPonseData<List<Bean>>> response) {
               Log.d(getLocalClassName(),response.body().toString());
           }

           @Override
           public void onFailure(Call<ResPonseData<List<Bean>>> call, Throwable t) {

           }
       });
    }
}
