package com.example.demo.Utils;

import com.example.demo.Bean.AResponse;
import com.example.demo.Bean.Response;

import java.util.Date;
import java.util.List;

public class ResponseUtil {


    public Response setresponse(int code, List<?> data){
        Response response=new Response();
        switch (code){
            case 200:
                response.setCode(code);
                response.setMessage(null);
                response.setData(data);
                response.setTime(new Date());

            case 404:
                response.setCode(code);
                response.setMessage("not found");
                response.setData(data);
                response.setTime(new Date());

            case 400:
                response.setCode(code);
                response.setMessage("bad request");
                response.setData(data);
                response.setTime(new Date());



            default:
                response.setCode(code);
                response.setMessage(null);
                response.setData(data);
                response.setTime(new Date());
                break;

        }
        return response;
    }

    public AResponse setaresponse(int code, Object data){
        AResponse response=new AResponse();
        switch (code){
            case 200:
                response.setCode(code);
                response.setMessage(null);
                response.setData(data);
                response.setTime(new Date());

            case 404:
                response.setCode(code);
                response.setMessage("not found");
                response.setData(data);
                response.setTime(new Date());

            case 400:
                response.setCode(code);
                response.setMessage("bad request");
                response.setData(data);
                response.setTime(new Date());

            default:
                response.setCode(code);
                response.setMessage(null);
                response.setData(data);
                response.setTime(new Date());
                break;

        }
        return response;
    }
}
