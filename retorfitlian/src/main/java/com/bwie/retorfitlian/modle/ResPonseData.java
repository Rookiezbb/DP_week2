package com.bwie.retorfitlian.modle;

/**
 * Created by lenovo on 2017/12/1.
 */

public class ResPonseData<T>{
    public String message;
    public T data;

    @Override
    public String toString() {
        return "ResPonseData{" +
                "message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
