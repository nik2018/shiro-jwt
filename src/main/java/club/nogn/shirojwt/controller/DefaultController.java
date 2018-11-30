package club.nogn.shirojwt.controller;

import club.nogn.shirojwt.pojo.UserEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 16225
 * @Title: DefaultController
 * @ProjectName shiro-jwt
 * @Description: TODO
 * @date 2018/11/1517:57
 */
@Controller
public class DefaultController {
    @RequestMapping("/")
    public String defaultpage(){
        return "index";
    }
    @RequestMapping("/testaxios")
    @ResponseBody
    public UserEntity testaxios(){
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername("nik");
        userEntity.setRole("user");
        userEntity.setHeadsculpture("https://gss2.bdstatic.com/9fo3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike92%2C5%2C5%2C92%2C30/sign=7b584f645b66d0166a14967af642bf62/d6ca7bcb0a46f21ffc8a92faff246b600d33aed9.jpg");
        return userEntity;
    }
}
