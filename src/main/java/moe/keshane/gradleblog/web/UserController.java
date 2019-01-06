package moe.keshane.gradleblog.web;

import moe.keshane.gradleblog.dal.entity.User;
import moe.keshane.gradleblog.service.interfaces.LoginService;
import moe.keshane.gradleblog.service.interfaces.RegService;
import moe.keshane.gradleblog.web.forms.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private LoginService loginService;
    @RequestMapping(value = "login",method = RequestMethod.POST)
//    @ResponseBody
    public String login(UserForm userForm,ModelMap modelMap)
    {
//        ModelMap modelMap = new ModelMap();
        User user = loginService.login(userForm.getUsername(),userForm.getPassword());
        if(user == null){
            modelMap.put("success_title","失败了");
            modelMap.put("success_content","无可奉告");
            return "home";
//            return "失败了";
        }
        modelMap.put("success_title","成功");
        modelMap.put("success_content","我一句话不说也不好");
//        return user.toString();
        return "home";
    }

    @Autowired
    private RegService regService;
    @RequestMapping(value = "reg",method = RequestMethod.POST)
    public String reg(UserForm userForm,ModelMap modelMap){
        User user = new User(userForm.getUsername(),userForm.getPassword());
        User reg = regService.reg(user);
        if(reg != null){
            modelMap.put("success_title","成功了");
            modelMap.put("success_content","看你这么热情");
        }else{
            modelMap.put("success_title","失败了");
            modelMap.put("success_content","搞个大新闻");
        }
        return "home";
    }
}
