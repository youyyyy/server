package com.example.demo.Controllers;


import com.example.demo.Bean.AResponse;
import com.example.demo.Services.IDeliveryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {

    @Resource
    private IDeliveryService deliveryService;

    @RequestMapping("/byfobjectid")
    public AResponse selcetUrl(int fobjectid){
        return deliveryService.selectUrl(fobjectid);
    }

}
