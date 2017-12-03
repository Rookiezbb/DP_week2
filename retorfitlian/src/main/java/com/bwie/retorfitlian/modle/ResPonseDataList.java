package com.bwie.retorfitlian.modle;

import java.util.List;

/**
 * Created by lenovo on 2017/12/1.
 */

public class ResPonseDataList<T> {
    public String message;
    public List<T> data;

    @Override
    public String toString() {
        return "ResPonseDataList{" +
                "message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
