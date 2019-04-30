package com.example.demo.Services;

import com.example.demo.Bean.AResponse;
import com.example.demo.Bean.Fobject;
import com.example.demo.Bean.Response;

public interface IFobjectService {
    Response selectByTitle(String title);

    Response selectByUpdatetime(int updatetime);

    Response selectByType(String type1,String type2,String type3);

    Response selectall();

    Response selectMonth(int month);

    Response selectRegion(String region);

    Response selectActor(String actor);

    Response deleteById(int id);

    Response add(Fobject fobject);

    AResponse getimage(int id);

    Fobject getImage(int id);

}
