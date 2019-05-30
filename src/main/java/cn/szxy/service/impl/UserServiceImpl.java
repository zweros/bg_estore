package cn.szxy.service.impl;

import cn.szxy.mapper.UsersMapper;
import cn.szxy.pojo.Users;
import cn.szxy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther:wzer
 * @Date:2019/5/30
 * @Description:cn.szxy.service.impl
 * @Version:1.0
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersMapper usersMapper;

    @Override
    public Users findUser(Users user) {
        Users u = usersMapper.selUserByName(user.getUsername());
        if(u != null){
            if(u.getPassword().equals(user.getPassword())){
                return user;
            }
        }
        return null;
    }
}
