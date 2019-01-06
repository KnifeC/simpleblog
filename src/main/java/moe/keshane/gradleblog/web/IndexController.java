package moe.keshane.gradleblog.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class IndexController {

    @RequestMapping("/")
    public String index(){
        return "forward:list";
    }

    @RequestMapping("/index")
    public String index_1(){
        return "forward:list";
    }
}
