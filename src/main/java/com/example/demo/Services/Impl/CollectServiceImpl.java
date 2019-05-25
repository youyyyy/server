package com.example.demo.Services.Impl;

import com.example.demo.Bean.AResponse;
import com.example.demo.Bean.Collect;
import com.example.demo.Bean.Response;
import com.example.demo.Dao.CollectDao;
import com.example.demo.Services.ICollectServise;
import com.example.demo.Utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectServiceImpl implements ICollectServise {

    @Autowired
    private CollectDao collectDao;

    @Override
    public Response selfCollect(int userid) {
        ResponseUtil responseUtil=new ResponseUtil();
        List<Collect> collects=collectDao.selfCollect(userid);
        if (collects==null)
            return responseUtil.setresponse(404,collects);
        else
            return responseUtil.setresponse(200,collects);
    }

    @Override
    public AResponse addCollect(Collect collect) {
        ResponseUtil responseUtil=new ResponseUtil();
        collectDao.addCollect(collect);
        return responseUtil.setaresponse(200,collect);
    }

    @Override
    public AResponse deleteCollect(int id) {
        ResponseUtil responseUtil=new ResponseUtil();
        Collect collect=collectDao.deleteCollect(id);
        if (collect==null)
            return responseUtil.setaresponse(404,collect);
        else
            return responseUtil.setaresponse(200,collect);
    }
}
