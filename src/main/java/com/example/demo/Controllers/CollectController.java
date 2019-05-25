package com.example.demo.Controllers;

import com.example.demo.Bean.AResponse;
import com.example.demo.Bean.Collect;
import com.example.demo.Bean.Response;
import com.example.demo.Services.ICollectServise;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/collect")
public class CollectController {
    @Resource
    private ICollectServise collectServise;

    @RequestMapping("/self")
    public Response selfCollect(int userid){
        return collectServise.selfCollect(userid);
    }

    @RequestMapping("/delete")
    public AResponse deleteCollect(int id){
        return collectServise.deleteCollect(id);
    }

    @RequestMapping(value="/add",method = RequestMethod.POST)
    public AResponse addCollect(@RequestBody Collect collect){
        return collectServise.addCollect(collect);
    }

}
