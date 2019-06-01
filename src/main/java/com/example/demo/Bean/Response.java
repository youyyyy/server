package com.example.demo.Bean;

import java.util.Date;
import java.util.List;

/*
 * 统一返回格式，对于列表即多个结果
 * 返回状态码code，报错信息，客户端请求消息以及请求时间
 * */
public class Response {
    private int code;

    private String message;

    private List<?> data;

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

    public List<?> getData(){
        return data;
    }
    public void setData(List<?> data){
        this.data=data;
    }

    public Date getTime(){
        return time;
    }
    public void setTime(Date time){
        this.time=time;
    }
}

