package cn.szxy.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther:wzer
 * @Date:2019/5/29
 * @Description:cn.szxy.web.controller
 * @Version:1.0
 **/
@Controller
public class PageController {

    /**
     *  页面跳转   RESTful 风格
     */
    @RequestMapping("/{page}")
    public String showPage(@PathVariable String page){
        return page;
    }


    @RequestMapping("/")
    public String showIndex(){
        return "index";
    }
}
