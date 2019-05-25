package com.example.demo.Dao;

import com.example.demo.Bean.Collect;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CollectDao {
    @Select("select * from collect where userid=#{userid}")
    List<Collect> selfCollect(int userid);

    @Select("insert into collect(userid,fjid,fjname,updatetime) value(#{collect.userid},#{collect.fjid},#{collect.fjname},#{collect.updatetime})")
    Collect addCollect(@Param("collect")Collect collect);

    @Select("delete from collect where id=#{id}")
    Collect deleteCollect(@Param("id")int id);
}
