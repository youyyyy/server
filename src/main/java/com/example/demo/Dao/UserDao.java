package com.example.demo.Dao;

import com.example.demo.Bean.Discuss;
import com.example.demo.Bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


/*
* 用户数据持久层，存放sql语句，提供操作数据库的接口
* */
@Mapper
public interface UserDao {

    //按ID查找用户
    @Select("select * from user where id=#{id}")
    User selectUser(@Param("id") int id);

    //查找所有用户及资料
    @Select("select * from user")
    List<User> selectAllUser();

    //按邮件查找
    @Select("select id,username,gender,phonenum,levels,email,type,csignature from user where email=#{email}")
    User selectbyEmail(@Param("email") String email);

    //添加用户
    @Select("insert into user(username,password,gender,phonenum,levels,email,type,csignature) value(#{user.username},#{user.password},#{user.gender},#{user.phonenum},#{user.levels},#{user.email},#{user.type},#{user.csignature})")
    User regist(@Param("user")User user);

    //按照电话号码查找其他用户资料，不显示密码
    @Select("select id,username,gender,phonenum,levels,email,type,csignature from user where phonenum=#{phonenum}")
    User selectphone(@Param("phonenum") String phonenum);

    //其他用户按照ID查找用户资料
    @Select("select id,username,gender,phonenum,levels,email,type,csignature from user where id=#{id}")
    User selectById(@Param("id")int id);

    @Select("select * from user where phonenum=#{phonenum}")
    User selectphone2(@Param("phonenum")String phonenum);

//    @Select("select * from user password=#{password}")
//    User selectpass(@Param("password")String password);

    @Select("delete from user where id=#{id}")
    User removeUser(@Param("id") int id);//修改e


    @Select("delete from user where email=#{email}")
    User deleteByEmail(@Param("email")String email);
    //@Select("select email from user where")
    //User loginUser(@Param("email")String email,@Param("password")String password);

    //修改信息
    @Select("update user set username=#{username},password=#{password},gender=#{gender},phonenum=#{phonenum},email=#{email},csignature=#{csignature},type=#{type} where id=#{id}")
    User modifyUser(User user);

    @Select("update user set username=#{username} where id=#{id}")
    User modifyName(String username,int id);

    @Select("update user set csignature=#{csignature} where id=#{id}")
    User modifyCsignature(String csignature,int id);

    @Select("update user set gender=#{gender} where id=#{id}")
    User modifyGender(int gender,int id);

    @Select("update user set password=#{password} where id=#{id}")
    User modifyPassword(String password,int id);

    @Select("update user set type=#{type} where id=#{id}")
    User modifyType(String type,int id);


}