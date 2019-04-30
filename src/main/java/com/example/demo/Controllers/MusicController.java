package com.example.demo.Controllers;

import com.example.demo.Bean.AResponse;
import com.example.demo.Bean.Response;
import com.example.demo.Services.IMusicService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/music")
public class MusicController {
    @Resource
    private IMusicService musicService;

    @RequestMapping("/all")
    public Response allMusic(){
        return musicService.allMusic();
    }

    @RequestMapping("/fmusic")
    public Response fmusic(int fobjectid){
        return musicService.selectByFobjectid(fobjectid);
    }

    @RequestMapping("/delete")
    public AResponse delete(int id){
        return musicService.deleteMusaic(id);
    }

}
