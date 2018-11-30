package club.nogn.shirojwt.controller;

import club.nogn.shirojwt.model.ResultMap;
import club.nogn.shirojwt.pojo.UserEntity;
import club.nogn.shirojwt.service.AdminService;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description admin角色权限controller
 * @Date 2018-04-29
 * @Time 17:32
 */
@RestController
@RequestMapping("/admin")
public class AdminController {
//    private final UserMapper userMapper;
    private AdminService adminService;
    private final ResultMap resultMap;

    @Autowired
    public AdminController(AdminService adminService, ResultMap resultMap) {
        this.adminService = adminService;
        this.resultMap = resultMap;
    }

    @GetMapping("/getUsers")
    @RequiresRoles("admin")
    public ResultMap getUser() {
        List<UserEntity> users = adminService.getUsers();
//        List<String> list = userMapper.getUser();
        return resultMap.success().code(200).message(users);
    }

    /**
     * 封号操作
     */
    @PostMapping("/banUser")
    @RequiresRoles("admin")
    public ResultMap updatePassword(String username) {
//        userMapper.banUser(username);
        int banuser = adminService.banuser(username);
        if (banuser>0){
            return resultMap.success().code(200).message("成功封号！");
        }
        else {
            return resultMap.success().code(500).message("失败");
        }
    }
}
