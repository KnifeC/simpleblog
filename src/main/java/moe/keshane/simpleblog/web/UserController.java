package moe.keshane.simpleblog.web;

import moe.keshane.simpleblog.common.SessionKey;
import moe.keshane.simpleblog.dal.entity.User;
import moe.keshane.simpleblog.service.interfaces.AdminService;
import moe.keshane.simpleblog.service.interfaces.LoginService;
import moe.keshane.simpleblog.service.interfaces.RegService;
import moe.keshane.simpleblog.service.interfaces.UpdateUserService;
import moe.keshane.simpleblog.web.forms.UpdateUserForm;
import moe.keshane.simpleblog.web.forms.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

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
            return "error";
        }
        session.setAttribute(SessionKey.USER_ID,user.getUserid());
        session.setAttribute(SessionKey.USER_NAME,user.getUsername());
        session.setAttribute(SessionKey.USER_TYPE,user.getType());
        modelMap.put("success_title","成功");
        modelMap.put("success_content","我一句话不说也不好");
        return "redirect:/index";
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
        return "redirect:/login";
    }
    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String registerWeb(){
        return "registerhtml";
    }

    @Autowired
    AdminService adminService;
    @RequestMapping(value = "/admin",method = RequestMethod.GET)
    public String admin(ModelMap modelMap){
        ArrayList<User> allUserInfo = adminService.getAllUserInfo();
        if(allUserInfo==null){
            return "error";
        }
        modelMap.put("userinfo",allUserInfo);
        return "admin";
    }

    @Autowired
    UpdateUserService updateUserService;
    @RequestMapping(value = "/updateuser",method = RequestMethod.POST)
    public String updateUser(UpdateUserForm updateUserForm){
        if(updateUserForm.getType()==null||updateUserForm.getType().equals("")){
            updateUserForm.setType("user");
        }
        User user = new User(updateUserForm.getUsername(),updateUserForm.getPassword(),updateUserForm.getType());
        user.setUserid(updateUserForm.getUserid());
        updateUserService.updateUser(user);
        return "redirect:/admin";
    }

}
