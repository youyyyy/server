package com.example.demo.Services.Impl;

import com.example.demo.Bean.AResponse;
import com.example.demo.Bean.Fobject;
import com.example.demo.Bean.Response;
import com.example.demo.Dao.FobjectDao;
import com.example.demo.Services.IFobjectService;
import com.example.demo.Utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FobjectServiceImpl implements IFobjectService {
    @Autowired
    private FobjectDao fobjectDao;

    @Override
    public Response selectByTitle(String title) {
        ResponseUtil responseUtil=new ResponseUtil();
        List<Fobject> fobject=fobjectDao.selectBytitle("%"+title+"%");
        if (fobject==null)
            return responseUtil.setresponse(404,fobject);
        else
            return responseUtil.setresponse(200,fobject);

    }

    @Override
    public Response selectByUpdatetime(int updatetime) {
        ResponseUtil responseUtil=new ResponseUtil();
        List<Fobject> fobject=fobjectDao.selectByUpdatetime(updatetime);
        if (fobject==null)
            return responseUtil.setresponse(404,fobject);
        else
            return responseUtil.setresponse(200,fobject);
    }

    @Override
    public Response selectByType(String type1, String type2, String type3) {
        ResponseUtil responseUtil=new ResponseUtil();
        List<Fobject> fobject=fobjectDao.selectBytype("%"+type1+"%","%"+type2+"%","%"+type3+"%");
        if (fobject==null)
            return responseUtil.setresponse(404,fobject);
        else
            return responseUtil.setresponse(200,fobject);
    }

    @Override
    public Response selectall() {
        ResponseUtil responseUtil=new ResponseUtil();
        List<Fobject> fobjects=fobjectDao.selectall();
        if (fobjects==null)
            return responseUtil.setresponse(404,fobjects);
        else
            return responseUtil.setresponse(200,fobjects);
    }

    @Override
    public Response selectMonth(int month) {
        ResponseUtil responseUtil=new ResponseUtil();
        List<Fobject> fobjects=fobjectDao.selectMonth(month);
        if (fobjects==null)
            return responseUtil.setresponse(404,fobjects);
        else
            return responseUtil.setresponse(200,fobjects);
    }

    @Override
    public Response selectRegion(String region) {
        ResponseUtil responseUtil=new ResponseUtil();
        List<Fobject> fobjects=fobjectDao.selectRegion(region);
        if (fobjects==null)
            return responseUtil.setresponse(404,fobjects);
        else
            return responseUtil.setresponse(200,fobjects);
    }

    @Override
    public Response selectActor(String actor) {
        ResponseUtil responseUtil=new ResponseUtil();
        List<Fobject> fobjects=fobjectDao.selectActor("%"+actor+"%");
        if (fobjects==null)
            return responseUtil.setresponse(404,fobjects);
        else
            return responseUtil.setresponse(200,fobjects);
    }

    @Override
    public Response deleteById(int id) {
        ResponseUtil responseUtil=new ResponseUtil();
        List<Fobject> fobjects=fobjectDao.deleteById(id);
        if (fobjects==null)
            return responseUtil.setresponse(404,fobjects);
        else
            return responseUtil.setresponse(200,fobjects);
    }

    @Override
    public Response add(Fobject fobject) {
        return null;
    }

    @Override
    public AResponse getimage(int id) {
        ResponseUtil responseUtil=new ResponseUtil();
        Fobject fobject=fobjectDao.getImage(id);
        if (fobject==null)
            return responseUtil.setaresponse(404,fobject);
        else
            return responseUtil.setaresponse(200,fobject);
    }

    @Override
    public Fobject getImage(int id) {
       Fobject fobject=fobjectDao.getImage(id);
       return fobject;
    }

    @Override
    public AResponse byId(int id) {
        ResponseUtil responseUtil=new ResponseUtil();
        Fobject fobject=fobjectDao.byId(id);
        if (fobject==null)
            return responseUtil.setaresponse(404,fobject);
        else
            return responseUtil.setaresponse(200,fobject);
    }


}
