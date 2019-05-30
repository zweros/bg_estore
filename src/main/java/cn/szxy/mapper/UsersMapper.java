package cn.szxy.mapper;

import cn.szxy.pojo.Users;
import org.apache.ibatis.annotations.Select;

/**
 * @Auther:wzer
 * @Date:2019/5/30
 * @Description:cn.szxy.mapper
 * @Version:1.0
 **/
public interface UsersMapper {

    /**
     * 根据用户名查询用户信息
     * @param name
     * @return
     */
 /*   @Select("select userid,username,password from tbl_user where username = #{username}")*/
    Users selUserByName(String name);
}
