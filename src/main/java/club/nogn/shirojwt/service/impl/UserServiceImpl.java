package club.nogn.shirojwt.service.impl;

import club.nogn.shirojwt.mapper.UserMapper;
import club.nogn.shirojwt.pojo.UserEntity;
import club.nogn.shirojwt.service.UserService;
import club.nogn.shirojwt.util.EncryptionHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 16225
 * @Title: UserServiceImpl
 * @ProjectName shiro-jwt
 * @Description: TODO
 * @date 2018/11/818:42
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;


    @Override
    public int register(UserEntity user) {

//        user.setPassword();
        if (user.getPassword().equals(null)){
            return -1;
        }
        EncryptionHelper encryptionHelper = new EncryptionHelper();
        String encryptpsw = encryptionHelper.encrypt(user.getPassword());
        user.setPassword(encryptpsw);
        user.setBan((byte) 0);
        user.setPermission("normal");
        user.setRole("user");
        int insert = userMapper.insert(user);
        return insert;
    }

    @Override
    public String getpsdByusername(String username) {
        UserEntity user =  new UserEntity();
        user.setUsername(username);
        System.out.println(user.toString());
        UserEntity userEntity = userMapper.selectOne(user);
        System.out.println(userEntity.toString());
        return userEntity.getPassword();
    }

    @Override
    public int updatepwd(String username, String pwd) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(username);
        EncryptionHelper encryptionHelper = new EncryptionHelper();
        String encryptpsw = encryptionHelper.encrypt(pwd);
        userEntity.setPassword(encryptpsw);
        int update = userMapper.updateByPrimaryKeySelective(userEntity);
        return update;
    }

    @Override
    public Byte getUserBanStatus(String username) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(username);
        UserEntity userEntity1 = userMapper.selectOne(userEntity);

        return userEntity1.getBan();
    }

    @Override
    public String getUserRole(String username) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(username);
        UserEntity userEntity1 = userMapper.selectOne(userEntity);

        return userEntity1.getRole();
    }

    @Override
    public String getRolePermission(String username) {

        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(username);
        UserEntity userEntity1 = userMapper.selectOne(userEntity);

        return userEntity1.getPermission();
    }
}
