package club.nogn.shirojwt.service;

import club.nogn.shirojwt.pojo.UserEntity;

public interface UserService {
    int register(UserEntity user);
    String getpsdByusername(String username);
    int updatepwd(String username,String pwd);
    Byte getUserBanStatus(String username);
    String getUserRole(String username);
    String getRolePermission(String username);


}
