package com.example.demo.Dao;

import com.example.demo.Bean.Discuss;
import com.example.demo.Bean.User;
import org.apache.ibatis.annotations.*;

import java.util.List;


public interface DiscussDao {
    //用户通过自己的id查询自己的所有评论
    @Select("select * from discuss where userid=#{userid}")
    List<Discuss> selfdis(int userid);

    //通过番剧id查找此番剧的所有评论及回复
    @Select("select * from discuss where fobjectid=#{fobjectid}")
    List<Discuss> fobjectdis(int fobjectid);

//    @Select("select username from user where discuss.userid")
//    List<Discuss> selectDis(int id);

    //写评论or回复
    @Select("insert into discuss(body,userid,fobjectid,time,pid,puid,username) value(#{discuss.body},#{discuss.userid},#{discuss.fobjectid},#{discuss.time},#{discuss.pid},#{discuss.puid},#{discuss.username})")
    Discuss adddis(@Param("discuss")Discuss discuss);

    //根据自己的ID删除自己的评论
    @Select("delete from discuss where id=#{id}")
    Discuss deletedis(@Param("id")int id);

    @Select("update discuss set username=#{username} where userid=#{userid}")
    List<Discuss> modifyName(String username,int userid);


}
