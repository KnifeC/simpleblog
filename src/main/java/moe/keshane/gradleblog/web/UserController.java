package moe.keshane.gradleblog.web;

import moe.keshane.gradleblog.common.SessionKey;
import moe.keshane.gradleblog.dal.entity.User;
import moe.keshane.gradleblog.service.interfaces.LoginService;
import moe.keshane.gradleblog.service.interfaces.RegService;
import moe.keshane.gradleblog.web.forms.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    private LoginService loginService;
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(UserForm userForm, ModelMap modelMap, HttpSession session)
    {
        User user = loginService.login(userForm.getUsername(),userForm.getPassword());
        if(user == null){
            modelMap.put("success_title","失败了");
            modelMap.put("success_content","无可奉告");
            return "home";
        }
        session.setAttribute(SessionKey.USER_ID,user.getUserid());
        session.setAttribute(SessionKey.USER_NAME,user.getUsername());
        session.setAttribute(SessionKey.USER_TYPE,user.getType());
        modelMap.put("success_title","成功");
        modelMap.put("success_content","我一句话不说也不好");
        return "home";
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String loginWeb(){
        return "loginhtml";
    }

    @Autowired
    private RegService regService;
    @RequestMapping(value = "/register",method = RequestMethod.POST)
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
    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String registerWeb(){
        return "registerhtml";
    }
}
