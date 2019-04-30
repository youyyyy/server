package com.example.demo.Bean;

import java.util.Date;
import java.util.List;

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

