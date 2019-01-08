package moe.keshane.simpleblog.web;

import moe.keshane.simpleblog.common.SessionKey;
import moe.keshane.simpleblog.dal.entity.Article;
import moe.keshane.simpleblog.service.interfaces.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
public class ListController {

    @Autowired
    ListService listService;
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String list(ModelMap modelMap, HttpSession session){
        ArrayList<Article> articles = listService.listAllArticle();
        //对文章进行切片
        if(articles!=null) {
            for(Article article : articles){
                if(article.getContext().toCharArray().length>50){
                    char[] dst = article.getContext().toCharArray();
                    article.setContext(String.valueOf(dst,0,48)+"...");
                }
            }
            Object username = session.getAttribute(SessionKey.USER_NAME);
            Object usertype = session.getAttribute(SessionKey.USER_TYPE);
            if(usertype!=null&&usertype.toString().equals("admin")){
                modelMap.put("adminpermission",true);
            }
            modelMap.put("username",username);
            modelMap.put("articlelist", articles);
        }else{
            modelMap.put("articlelist","没有数据");
        }
        return "indexhtml";
    }
}
