package com.example.demo.Services.Impl;

import com.example.demo.Bean.AResponse;
import com.example.demo.Bean.Music;
import com.example.demo.Bean.Response;
import com.example.demo.Dao.MusicDao;
import com.example.demo.Services.IMusicService;
import com.example.demo.Utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicServiceImpl implements IMusicService {

    @Autowired
    private MusicDao musicDao;
    @Override
    public Response selectByFobjectid(int fobjectid) {
        ResponseUtil responseUtil=new ResponseUtil();
        List<Music> music=musicDao.selectByFobjectid(fobjectid);
        if (music==null)
            return responseUtil.setresponse(404,music);
        else
            return responseUtil.setresponse(200,music);
    }

    @Override
    public Response allMusic() {
        ResponseUtil responseUtil=new ResponseUtil();
        List<Music> music=musicDao.allMusic();
        if (music==null)
            return responseUtil.setresponse(404,music);
        else
            return responseUtil.setresponse(200,music);

    }

    @Override
    public AResponse deleteMusaic(int id) {
        ResponseUtil responseUtil=new ResponseUtil();
        Music music=musicDao.deleteMusaic(id);
        if (music==null)
            return responseUtil.setaresponse(404,music);
        else
            return responseUtil.setaresponse(200,music);
    }
}
