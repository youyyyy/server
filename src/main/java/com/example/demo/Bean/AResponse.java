package com.example.demo.Bean;

import java.util.Date;

import java.util.ArrayList;
import java.util.List;

/*
* 统一返回格式，对于单个
* 返回状态码code，报错信息，客户端请求消息以及请求时间
* */
public class AResponse {
    private int code;

    private String message;

    private Object data;

    private Date time;

    public int getCode() {
        return code;
    }
    public void setCode(int code){
        this.code=code;
    }

    public String getMessage(){
        return message;
    }
    public void setMessage(String message){
        this.message=message;
    }

    public Object getData(){
        return data;
    }
    public void setData(Object data){
        this.data=data;
    }

    public Date getTime(){
        return time;
    }
    public void setTime(Date time){
        this.time=time;
    }
}
