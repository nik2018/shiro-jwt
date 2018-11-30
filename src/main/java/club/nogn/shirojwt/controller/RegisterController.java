package club.nogn.shirojwt.controller;

import club.nogn.shirojwt.model.ResultMap;
import club.nogn.shirojwt.pojo.UserEntity;
import club.nogn.shirojwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 16225
 * @Title: RegisterController
 * @ProjectName shiro-jwt
 * @Description: TODO
 * @date 2018/11/817:36
 */
@RestController
public class RegisterController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResultMap register(UserEntity userEntity) {
        System.out.println(userEntity.getUsername() + userEntity.getPassword());

        if (userEntity.getUsername() != null && !"".equals(userEntity.getUsername().trim()) && userEntity.getPassword() != null && !"".equals(userEntity.getPassword().trim())) {
            int register = userService.register(userEntity);
            if (register == 1) {
                return new ResultMap().success().code(200).message("注册成功，请登录!");
            } else {
                return new ResultMap().fail().code(500).message("注册失败，请重试。");
            }
        } else {
            return new ResultMap().fail().code(500).message("注册失败，请重试。");
        }

    }
}
