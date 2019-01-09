package moe.keshane.simpleblog.web;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class PhtotoController {

    @RequestMapping(value = "/photo",method = RequestMethod.GET)
    public String photo(HttpSession session, ModelMap modelMap){
        return "photomanage";
    }
}
