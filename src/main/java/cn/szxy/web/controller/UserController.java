package cn.szxy.web.controller;

import cn.szxy.pojo.Users;
import cn.szxy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * @Auther:wzer
 * @Date:2019/5/30
 * @Description:cn.szxy.web.controller
 * @Version:1.0
 **/
@Controller
@RequestMapping("/user")
public class UserController  {

    @Autowired
    private UserService userService;

    @RequestMapping(value="/userLogin",method= RequestMethod.POST)
    public String userLogin(Users user, HttpSession session){
        Users  u = userService.findUser(user);
        if(u !=null){
                session.setAttribute("user",u);
                return "index";
        }
        session.setAttribute("error","用户名或密码错误");
        return "redirect:/login";
    }

    @RequestMapping(value="userLogout",method=RequestMethod.GET)
    public String userLogout(HttpSession session){
        /**
         *  清除 session 信息
         */
        session.invalidate();

        return "redirect:/login";
    }

}
