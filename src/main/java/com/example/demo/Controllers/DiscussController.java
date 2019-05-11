package com.example.demo.Controllers;


import com.example.demo.Bean.AResponse;
import com.example.demo.Bean.Discuss;
import com.example.demo.Bean.Response;
import com.example.demo.Services.IDiscussService;
import com.example.demo.Utils.ResponseUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/discuss")
public class DiscussController {
    @Resource
    private IDiscussService discussService;


    @RequestMapping("/self")
    public Response selfdis(int userid){
        return discussService.selfdis(userid);
    }

    @RequestMapping("/fobject")
    public Response fobjectdis(int fobjectid){
        return discussService.fobjectdis(fobjectid);
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public AResponse adddis(@RequestBody Discuss discuss){
        return discussService.adddis(discuss);
    }

    @RequestMapping("/delete/{id}")
    public AResponse deletedis(@PathVariable("id")int id){
        return discussService.deletedis(id);
    }

    @RequestMapping("modifyusername")
    public Response modifyusername(int userid,String username){
        return discussService.modifyusername(userid,username);
    }

}
