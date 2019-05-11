package com.example.demo.Services;

import com.example.demo.Bean.AResponse;
import com.example.demo.Bean.Discuss;
import com.example.demo.Bean.Response;

import java.util.List;

public interface IDiscussService {
    Response selfdis(int userid);

    Response fobjectdis(int fobjectid);

    AResponse adddis(Discuss discuss);

    AResponse deletedis(int id);

    Response modifyusername(int userid,String username);
}
