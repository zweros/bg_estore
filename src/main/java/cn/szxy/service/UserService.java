package cn.szxy.service;

import cn.szxy.pojo.Users;

/**
 * @Auther:wzer
 * @Date:2019/5/30
 * @Description:cn.szxy.service
 * @Version:1.0
 **/
public interface UserService {

    /**
     * 查询用户信息
     * @param user
     * @return
     */
    Users findUser(Users user);
}
