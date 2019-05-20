package com.example.demo.Dao;

import com.example.demo.Bean.Music;
import com.example.demo.Bean.Response;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MusicDao {
    //根据番剧id搜索
    @Select("select * from music where fobjectid=#{fobjectid}")
    Music selectByFobjectid(int fobjectid);

    //搜索所有
    @Select("select musicname,signer,type,fobjectname from music")
    List<Music> allMusic();

    //按id删除
    @Select("delete from music where id=#{id}")
    Music deleteMusaic(int id);
}
