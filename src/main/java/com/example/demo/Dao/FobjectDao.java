package com.example.demo.Dao;

import com.example.demo.Bean.Fobject;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface FobjectDao {

    //按照标题查找
    @Select("select * from fobject where title like #{title}")
    List<Fobject> selectBytitle(String title);

    //按照更新时间查找
    @Select("select * from fobject where updatetime=#{updatetime}")
    List<Fobject> selectByUpdatetime(int updatetime);

    @Select("SELECT * FROM fobject where type like #{type1} or type like #{type2}  or type like #{type3}")
    List<Fobject> selectBytype(String type1,String type2,String type3);

    @Select("select * from fobject")
    List<Fobject> selectall();

    @Select("select * from fobject where month=#{month}")
    List<Fobject> selectMonth(int month);

    @Select("select * from fobject where region=#{region}")
    List<Fobject> selectRegion(String region);

    @Select("select * from fobject where actor like #{actor}")
    List<Fobject> selectActor(String actor);

    @Select("delete from fobject where id=#{id}")
    List<Fobject> deleteById(@Param("id") int id);//修改e

    @Select("insert into fobject(title,updatetime,objectabstract,type,objectpic,month,region,company,actor) value(#{fobject.title},#{fobject.updatetime},#{fobject.objectabstract},#{fobject.type},#{fobject.objectpic},#{fobject.month},#{fobject.region},#{fobject.actor})")
    List<Fobject> add(@Param("fobject")Fobject fobject);

    @Select("select objectpic from fobject where id=#{id}")
    Fobject getImage(int id);

}
