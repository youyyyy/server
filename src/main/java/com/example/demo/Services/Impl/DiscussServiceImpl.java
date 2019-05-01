package com.example.demo.Services.Impl;

import com.example.demo.Bean.AResponse;
import com.example.demo.Bean.Discuss;
import com.example.demo.Bean.Response;
import com.example.demo.Dao.DiscussDao;
import com.example.demo.Services.IDiscussService;
import com.example.demo.Utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscussServiceImpl implements IDiscussService {

    @Autowired
    private DiscussDao discussDao;

    @Override
    public Response selfdis(int userid) {
        ResponseUtil responseUtil=new ResponseUtil();
        List<Discuss> discusses=discussDao.selfdis(userid);
        if (discusses==null)
            return responseUtil.setresponse(404,discusses);
        else
            return responseUtil.setresponse(200,discusses);
    }

    @Override
    public Response fobjectdis(int fobjectid) {
        ResponseUtil responseUtil=new ResponseUtil();
        List<Discuss> discusses=discussDao.fobjectdis(fobjectid);
        if (discusses==null)
            return responseUtil.setresponse(404,discusses);
        else
            return responseUtil.setresponse(200,discusses);
    }

    @Override
    public AResponse adddis(Discuss discuss) {
        ResponseUtil responseUtil=new ResponseUtil();
        discussDao.adddis(discuss);

        return responseUtil.setaresponse(200,discuss);

    }

    @Override
    public AResponse deletedis(int id) {
        ResponseUtil responseUtil=new ResponseUtil();
        Discuss discusses=discussDao.deletedis(id);
        if (discusses==null)
            return responseUtil.setaresponse(404,discusses);
        else
            return responseUtil.setaresponse(200,discusses);
    }
}
