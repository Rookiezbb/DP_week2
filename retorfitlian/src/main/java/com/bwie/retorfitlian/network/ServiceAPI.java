package com.bwie.retorfitlian.network;

import com.bwie.retorfitlian.modle.ResPonseData;
import com.bwie.retorfitlian.modle.ResPonseDataList;
import com.bwie.retorfitlian.modle.Bean;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by lenovo on 2017/12/1.
 */

public interface ServiceAPI {
@GET(Utils.TAGS)
Call<ResPonseData <List<Bean>>> tags();
}
