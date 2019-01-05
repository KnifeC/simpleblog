package moe.keshane.gradleblog.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @RequestMapping("hello")
    @ResponseBody
    public String hello(ModelMap modelMap){

        return "hehe";
    }
    @RequestMapping("redirect")
    public String redirect(){
        return "redirect:hello";
    }
    @RequestMapping("forward")
    public String forward(){
        return "forward:hello";
    }
}
