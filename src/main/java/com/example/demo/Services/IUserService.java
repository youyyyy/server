package com.example.demo.Services;

import com.example.demo.Bean.AResponse;
import com.example.demo.Bean.Response;
import com.example.demo.Bean.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IUserService {
//    @Select("select * from user where user_id=#{user_id}")
//    User selectUser(@Param("user_id") int user_id);//按ID查找用户
//
//
//    @Select("select * from user")
//    List<User> selectAllUser();//查找所有用户
//
//    @Select("select * from user where email=#{email}")
//    User selectbyEmail(@Param("email") String email);//按邮件查找
//
//    @Select("insert into user value(#{user.username},#{user.password},#{user.sex},#{user.phone_num},#{user.levels},#{user.email})")
//    User adduser(@Param("user") User user);//添加用户
//
//    @Select("select * from user where phone_num=#{phone_num}")
//    User selectphone(@Param("phone_num") String phone_num);//按照电话号码查找
//
//    @Select("delete from user where user_id=#{user_id}")
//    User removeUser(@Param("user_id") int user_id);//修改
//
//    User modifyUser(User user);

    AResponse regist(User user);

    User login(String phonenum, String password);

//    User login2(String phonenum, String password);

    AResponse selectByEmail(String email);

    AResponse modifyUser(int id,User user);

    Response showAllUsers();

    AResponse showUser(int id);

    AResponse deleteByEmail(String email);

    AResponse selectById(int id);

    AResponse modifyName(int id,String username,User user);

    AResponse modifyCsignature(String csignature,int id,User user);

    AResponse modifyGender(int gender,int id,User user);

    AResponse modifyPassword(String password,int id,User user);

    AResponse modifyType(String type,int id,User user);
}