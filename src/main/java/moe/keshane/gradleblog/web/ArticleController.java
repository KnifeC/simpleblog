package moe.keshane.gradleblog.web;

import moe.keshane.gradleblog.dal.entity.Article;
import moe.keshane.gradleblog.service.interfaces.PostService;
import moe.keshane.gradleblog.service.interfaces.ReadService;
import moe.keshane.gradleblog.service.interfaces.SearchService;
import moe.keshane.gradleblog.web.forms.ArticleForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class ArticleController {
    @Autowired
    ReadService readService;
    @Autowired
    PostService postService;
    @Autowired
    SearchService searchService;

    @PostMapping("/article")
    public String article(ArticleForm articleForm){
        Article article = new Article(new Date(),articleForm.getTitle(),articleForm.getContext());
        Article post = postService.postArticle(article);
        if(post != null){
            new ModelMap().put("ispost","文章发布成功,id="+post.getArticleid());
            return "文章发布成功,id="+post.getArticleid();
        }else{
            new ModelMap().put("ispost","文章发布失败");
            return "文章发布失败";
        }
    }

    @GetMapping("/article/{id}")
    public String article(@PathVariable("id") Integer id){
        Article article = readService.readById(id);
        if(article == null){
            return "请求的参数错误";
        }
        return article.toString();
    }

    @GetMapping("/article")
    public String article(int id){
        Article article = readService.readById(id);
        if(article == null){
            return "请求的参数错误";
        }
        return article.toString();
    }


}
