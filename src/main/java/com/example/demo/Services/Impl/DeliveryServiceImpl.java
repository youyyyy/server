package com.example.demo.Services.Impl;

import com.example.demo.Bean.AResponse;
import com.example.demo.Bean.Delivery;
import com.example.demo.Dao.DeliveryDao;
import com.example.demo.Services.IDeliveryService;
import com.example.demo.Utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryServiceImpl implements IDeliveryService {

    @Autowired
    private DeliveryDao deliveryDao;

    @Override
    public AResponse selectUrl(int fobjectid) {
        ResponseUtil responseUtil=new ResponseUtil();
        Delivery delivery=deliveryDao.selectUrl(fobjectid);
        if (delivery==null)
            return responseUtil.setaresponse(404,delivery);
        else
            return responseUtil.setaresponse(200,delivery);
    }
}
