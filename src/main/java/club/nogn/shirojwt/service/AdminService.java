package club.nogn.shirojwt.service;

import club.nogn.shirojwt.pojo.UserEntity;

import java.util.List;

/**
 * @author 16225
 * @Title: AdminService
 * @ProjectName shiro-jwt
 * @Description: TODO
 * @date 2018/11/818:57
 */

public interface AdminService {
    List<UserEntity> getUsers();
    int banuser(String username);
}
