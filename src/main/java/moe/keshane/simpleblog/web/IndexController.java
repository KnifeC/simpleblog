package moe.keshane.simpleblog.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/")
    public String index(){
        return "forward:/list";
    }

    @RequestMapping("/index")
    public String index_1(){
        return "forward:/list";
    }
}
