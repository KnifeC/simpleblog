package moe.keshane.gradleblog.web;

import moe.keshane.gradleblog.dal.entity.User;
import moe.keshane.gradleblog.service.interfaces.LoginService;
import moe.keshane.gradleblog.service.interfaces.RegService;
import moe.keshane.gradleblog.web.forms.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private LoginService loginService;
    @PostMapping("/login")
    @ResponseBody
    public String login(UserForm userForm)
    {
        User user = loginService.login(userForm.getUsername(),userForm.getPassword());
        if(user == null){
            return "登陆失败";
        }
        return user.toString();
    }

    @Autowired
    private RegService regService;
    @PostMapping("/reg")
    @ResponseBody
    public String reg(UserForm userForm){
        boolean reg = regService.reg(userForm.getUsername(), userForm.getPassword());
        if(reg){
            return "注册成功"+userForm.toString();
        }else{
            return "注册失败"+userForm.toString();
        }
    }
}
