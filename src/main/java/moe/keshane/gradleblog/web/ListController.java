package moe.keshane.gradleblog.web;

import moe.keshane.gradleblog.dal.entity.Article;
import moe.keshane.gradleblog.service.interfaces.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;

@Controller
public class ListController {

    @Autowired
    ListService listService;
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String list(ModelMap modelMap){
        ArrayList<Article> articles = listService.listAllArticle();
        if(articles!=null) {
            modelMap.put("articlelist", articles);
        }else{
            modelMap.put("articlelist","没有数据");
        }
        return "listarticle";
    }
}
