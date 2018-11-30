package club.nogn.shirojwt.controller;

import club.nogn.shirojwt.model.ResultMap;
import club.nogn.shirojwt.service.UserService;
import club.nogn.shirojwt.util.EncryptionHelper;
import club.nogn.shirojwt.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description
 * @Date 2018-04-29
 * @Time 13:20
 */
@RestController
public class LoginController {
    //    private final UserMapper_ori userMapper;
    private UserService userService;
    private final ResultMap resultMap;


    @Autowired
    public LoginController(UserService userService, ResultMap resultMap) {
        this.userService = userService;
        this.resultMap = resultMap;
    }

    @PostMapping("/login")
    public ResultMap login(@RequestParam("username") String username,
                           @RequestParam("password") String password) {
//        String realPassword = userMapper.getPassword(username);
//        EncryptionHelper encryptionHelper = new EncryptionHelper();
//        encryptionHelper.encrypt(password);
        System.out.println("username" + username);
        System.out.println("userpwd" + password);

        String epwd = new EncryptionHelper().encrypt(password);
        String realPassword = userService.getpsdByusername(username);
        System.out.println("epwd" + epwd+"realpass"+realPassword);
        if (realPassword == null) {
             resultMap.fail().code(401).message("用户名错误");
        }
        else if (realPassword.equals(epwd)) {

             resultMap.success().code(200).message(JWTUtil.createToken(username));

        } else if(!realPassword.equals(epwd)) {
            resultMap.fail().code(401).message("密码错误");
        }
        return resultMap;
    }

    @RequestMapping(path = "/unauthorized/{message}")
    public ResultMap unauthorized(@PathVariable String message) throws UnsupportedEncodingException {
        return resultMap.success().code(401).message(message);
    }
}
