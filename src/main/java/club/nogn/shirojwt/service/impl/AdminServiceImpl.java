package club.nogn.shirojwt.service.impl;

import club.nogn.shirojwt.mapper.UserMapper;
import club.nogn.shirojwt.pojo.UserEntity;
import club.nogn.shirojwt.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 16225
 * @Title: AdminServiceImpl
 * @ProjectName shiro-jwt
 * @Description: TODO
 * @date 2018/11/818:58
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public List<UserEntity> getUsers() {
        List<UserEntity> userEntities = userMapper.selectAll();
        return userEntities;
    }

    @Override
    public int banuser(String username) {
        UserEntity user  = new UserEntity();
        user.setUsername(username);
        user.setPassword("test");
        int i = userMapper.updateByPrimaryKeySelective(user);
        return i;
    }
}
