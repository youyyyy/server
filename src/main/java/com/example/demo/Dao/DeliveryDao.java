package com.example.demo.Dao;

import com.example.demo.Bean.Delivery;
import org.apache.ibatis.annotations.Select;

public interface DeliveryDao {
    @Select("select * from delivery where fobjectid=#{fobjectid}")
    Delivery selectUrl(int fobjectid);
}
