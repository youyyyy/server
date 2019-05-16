package com.example.demo.Controllers;

import com.example.demo.Bean.AResponse;
import com.example.demo.Bean.Response;
import com.example.demo.Bean.User;
import com.example.demo.Dao.UserDao;
import com.example.demo.Services.IUserService;
import com.example.demo.Utils.CookieUtil;
import com.example.demo.Utils.ResponseUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController<session> {

    @Resource
    private IUserService userService;
    private int id;
    private ObjectMapper objectMapper;
    private User user;
   // private String phone_num;
    @Autowired
    private UserDao userDao;




    //登陆
    @RequestMapping("/login")
    public AResponse login(String phonenum,String password,HttpServletResponse response){
        ResponseUtil responseUtil=new ResponseUtil();
        User user = userService.login(phonenum,password);
        String userId = String.valueOf(user.getId());
        if(user==null)
            return responseUtil.setaresponse(404,"null");
        else {
            if (user.getPassword()==null){
                return responseUtil.setaresponse(404,"null");
            }
            else if(user.getPassword().equals(password)) {
                //read cookie

//                String readCookieValue = CookieUtil.getCookie(request, "login");
//
//                System.out.println("read cookie, value is: " + readCookieValue);
               // Cookie cookie = new Cookie("login", userId);
                //cookie.setMaxAge(36000);
                //response.addCookie(cookie);
                CookieUtil.writeCookie(response, "login", userId);
                return responseUtil.setaresponse(200,user);
            }
            else
                return responseUtil.setaresponse(404,"null");
        }

    }

   // 查找所有用户
    @RequestMapping("/selectall")
    public Response selectall(){

        return userService.showAllUsers();
    }

    //用户注册
//    @RequestMapping(name = "/addUser")
//    public AResponse addUser(User user){
//
//        System.out.println("收到");
//        return userService.regist(user);
//    }

    //用户注册
    @RequestMapping(value = "/regist",method = RequestMethod.POST)
    public AResponse regist(@RequestBody User user){
        return userService.regist(user);
    }

    //按照id查找用户
    @RequestMapping("/showuser")
    public AResponse showuser(int id){
        return userService.showUser(id);
    }

    //按照email查找用户
    @RequestMapping("/showuser2")
    public AResponse showByEmail(String email){
        return userService.selectByEmail(email);
    }



    //按照email删除用户
    @RequestMapping("/deleteuser")
    public AResponse deleteUser(String email){
        return userService.deleteByEmail(email);
    }


    @RequestMapping(value = "/modify",method = RequestMethod.POST)
    public AResponse modify(int id,@RequestBody User user){
        return userService.modifyUser(id,user);
    }

    @RequestMapping("modifyname")
    public AResponse modifyName(int id,String username,User user){
        return userService.modifyName(id,username,user);
    }

    @RequestMapping("/selectbyid")
    public AResponse selectById(int id){
        return userService.selectById(id);
    }

    @RequestMapping("modifycsignature")
    public AResponse modifyCsignature(String csignature,int id,User user){
        return userService.modifyCsignature(csignature,id,user);
    }

    @RequestMapping("modifygender")
    public AResponse modifyGender(int gender,int id,User user){
        return userService.modifyGender(gender,id,user);
    }

    @RequestMapping("modifypassword")
    public AResponse modifyPassword(String password,int id,User user){
        return userService.modifyPassword(password,id,user);
    }

    @RequestMapping("modifytype")
    public AResponse modifyType(String type,int id,User user){
        return userService.modifyType(type,id,user);
    }




//        //这个变量用于装cookies信息
//        private static Cookie cookie;
//
//        @RequestMapping(value = "/login2",method = RequestMethod.POST)
//        @ApiOperation(value = "登录接口，成功后获取cookies信息",httpMethod = "POST")
//        public String login(HttpServletResponse response,
//                            @RequestParam(value = "id",required = true) int id,
//                            @RequestParam(value = "password",required = true) String passord){
//            if(id.equals(user.getId()) && password.equals(user.getPassword())){
//                cookie = new Cookie("login","true");  //对比入参数据
//                response.addCookie(cookie);
//                return "恭喜登录成功";
//            }
//            return  "用户名或密码错误";
//
//        }
//
//
//    }
//    @RequestMapping("/test")
//    public String test(){
//        return "{\"test success\"}";
//    }
}
