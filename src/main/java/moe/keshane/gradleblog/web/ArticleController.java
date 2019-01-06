package moe.keshane.gradleblog.web;

import moe.keshane.gradleblog.dal.entity.Article;
import moe.keshane.gradleblog.service.interfaces.PostService;
import moe.keshane.gradleblog.service.interfaces.ReadService;
import moe.keshane.gradleblog.service.interfaces.SearchService;
import moe.keshane.gradleblog.web.forms.ArticleForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
public class ArticleController {
    @Autowired
    ReadService readService;
    @Autowired
    PostService postService;
    @Autowired
    SearchService searchService;

    @RequestMapping(value = "/article",method = RequestMethod.POST)
    @ResponseBody
    public String article(ArticleForm articleForm,ModelMap modelMap){
        Article article = new Article(new Date(),articleForm.getTitle(),articleForm.getContext(),articleForm.isHascomment());
        Article post = postService.postArticle(article);
        if(post != null){
            modelMap.put("ispost","文章发布成功,id="+post.getArticleid());
            return "文章发布成功,id="+post.getArticleid();
        }else{
            new ModelMap().put("ispost","文章发布失败");
            return "文章发布失败";
        }
    }


//    @RequestMapping(value = "/article",method = RequestMethod.GET)
//    public String article(int id,ModelMap modelMap){
//        Article article = readService.readById(id);
//        if(article == null){
//            return "请求的参数错误";
//        }
//        modelMap.put("article",article);
//        return "read";
//    }

    @RequestMapping(value = "/article",method = RequestMethod.GET)
    public String article(HttpServletRequest request){
        return "redirect:list" ;
    }
//    @GetMapping
//    public String article(@PathVariable("id") Integer id){
    @RequestMapping(value = "/article/{id}",method = RequestMethod.GET)
    public String article(@PathVariable("id") Integer id,ModelMap modelMap){
        Article article = readService.readById(id);
        if(article == null){
            return "请求的参数错误";
        }
        modelMap.put("article",article);
        return "read";
    }

}
