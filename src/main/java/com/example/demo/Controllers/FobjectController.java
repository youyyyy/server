package com.example.demo.Controllers;

import com.example.demo.Bean.AResponse;
import com.example.demo.Bean.Fobject;
import com.example.demo.Bean.Response;
import com.example.demo.Services.IFobjectService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@RestController
@RequestMapping("/fobject")
public class FobjectController {
    @Resource
    private IFobjectService fobjectService;

    @RequestMapping("/bytime")
    public Response bytime(int updatetime){
        return fobjectService.selectByUpdatetime(updatetime);
    }

    @RequestMapping("/bytitle")
    public Response bytitle(String title){
        return fobjectService.selectByTitle(title);
    }

    @RequestMapping("/bytype")
    public Response selectByType(String type1,String type2,String type3){
        return fobjectService.selectByType(type1,type2,type3);
    }

    @RequestMapping("/selectall")
    public Response selectAll(){
        return fobjectService.selectall();
    }

    @RequestMapping("/bymonth")
    public Response selectMonth( int month){
        return fobjectService.selectMonth(month);
    }

    @RequestMapping("/byregion")
    public Response selectRegion( String region){
        return fobjectService.selectRegion(region);
    }

    @RequestMapping("/byactor")
    public Response selectActor(String actor){
        return fobjectService.selectActor(actor);
    }

    @RequestMapping("/delete")
    public Response delete(int id){
        return fobjectService.deleteById(id);
    }

    //获取图片资源
    @RequestMapping(value = "/get",produces = MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
    public byte[] getImage(int id) throws IOException {
        String s=fobjectService.getImage(id).getObjectpic();
        File file = new File("C:/Users/blank/Desktop/资源/"+s);
        FileInputStream inputStream = new FileInputStream(file);
        byte[] bytes = new byte[inputStream.available()];
        inputStream.read(bytes, 0, inputStream.available());
        return bytes;
    }

    @RequestMapping("/getImage")
    public String getImage2(int id){
        String s=fobjectService.getImage(id).getObjectpic();
        return s;
    }

}
