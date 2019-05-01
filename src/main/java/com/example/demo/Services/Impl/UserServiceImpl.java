package com.example.demo.Services.Impl;

import com.example.demo.Bean.AResponse;
import com.example.demo.Bean.Response;
import com.example.demo.Bean.User;
import com.example.demo.Dao.UserDao;
import com.example.demo.Services.IUserService;
import com.example.demo.Utils.CookieUtil;
import com.example.demo.Utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserDao userDao;



    private boolean userInfoAuth(User user){
        if(user.getUsername()==""||user.getPassword()==""||user.getEmail()==""||user.getGender()==0||user.getPhonenum()==""||user.getLevels()==""){
            return false;
        }
        return true;
    }


    @Override
    public AResponse regist(User user) {
        ResponseUtil responseUtil=new ResponseUtil();
        if (!userInfoAuth(user)){
            return responseUtil.setaresponse(400,null);
        }

        if(userDao.selectphone2(user.getPhonenum())!=null||userDao.selectbyEmail(user.getEmail())!=null)
            return responseUtil.setaresponse(400,null);
        userDao.regist(user);

        User u=userDao.selectphone2(user.getPhonenum());
        if (u==null)
            return responseUtil.setaresponse(400,null);
        else
        {
            //userDao.adduser(user);
            return responseUtil.setaresponse(200,u);
        }

    }

    @Override
    public User login(String phonenum, String password) {
        User user = userDao.selectphone2(phonenum);
        return user;

    }


    @Override
    public AResponse selectByEmail(String email) {
        ResponseUtil responseUtil=new ResponseUtil();
        User user=userDao.selectbyEmail(email);
        if (user==null)
            return responseUtil.setaresponse(404,user);
        else
            return responseUtil.setaresponse(200,user);
    }

    @Override
    public AResponse modifyUser(int id,User user) {
        ResponseUtil responseUtil=new ResponseUtil();
        if(user.getId()==id) {
            userDao.modifyUser(user);
            User users=userDao.selectUser(user.getId());
            if (users==null)
                return responseUtil.setaresponse(404,users);
            else
                return responseUtil.setaresponse(200,users);
        }
        else
            return responseUtil.setaresponse(400,user);


    }

    @Override
    public Response showAllUsers() {
        ResponseUtil responseUtil=new ResponseUtil();
        List<User> users=userDao.selectAllUser();
        if(users==null)
        return responseUtil.setresponse(404,users);
        else
        return responseUtil.setresponse(200,users);
    }

    @Override
    public AResponse showUser(int id) {
        ResponseUtil responseUtil=new ResponseUtil();
        User user=userDao.selectUser(id);
        if(user==null)
        return responseUtil.setaresponse(404,user);
        else
            return responseUtil.setaresponse(200,user);
    }

    //删除用户
    @Override
    public AResponse deleteByEmail(String email) {
        ResponseUtil responseUtil=new ResponseUtil();
        User user=userDao.deleteByEmail(email);
        if(user==null)
            return responseUtil.setaresponse(404,user);
        else
            return responseUtil.setaresponse(200,user);
    }

    @Override
    public AResponse selectById(int id) {
        ResponseUtil responseUtil=new ResponseUtil();
        User user=userDao.selectById(id);
        if(user==null)
            return responseUtil.setaresponse(404,user);
        else
            return responseUtil.setaresponse(200,user);
    }


/* @Autowired
    private UserDao userDao;*/


//    @Resource
//    private UserDao userDao;
//
//    @Override
//    public User selectUser(int user_id) {
//        return this.userDao.selectUser(user_id);
//    }
//
//    @Override
//    public List<User> selectAllUser() {
//        return this.userDao.selectAllUser();
//    }
//
//    @Override
//    public User selectbyEmail(String email) {
//        return this.userDao.selectbyEmail(email);
//    }
//
//    @Override
//    public User adduser(User user) {
//        return this.userDao.adduser(user);
//    }
//
//    @Override
//    public User selectphone(String phone_num) {
//        return this.userDao.selectphone(phone_num);
//    }
//
//    @Override
//    public User removeUser(int user_id) {
//        return this.userDao.removeUser(user_id);
//    }
//
//    @Override
//    public User modifyUser(User user) {
//        return this.userDao.modifyUser(user);
//    }
}