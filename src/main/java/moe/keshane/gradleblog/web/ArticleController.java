package moe.keshane.gradleblog.web;

import moe.keshane.gradleblog.common.SessionKey;
import moe.keshane.gradleblog.dal.entity.Article;
import moe.keshane.gradleblog.dal.entity.Comment;
import moe.keshane.gradleblog.dal.entity.User;
import moe.keshane.gradleblog.service.interfaces.*;
import moe.keshane.gradleblog.web.forms.ArticleForm;
import moe.keshane.gradleblog.web.forms.EditForm;
import moe.keshane.gradleblog.web.returnset.ReturnComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Controller
public class ArticleController {
    @Autowired
    ReadService readService;
    @Autowired
    PostArticleService postArticleService;
    @Autowired
    SearchService searchService;
    @Autowired
    EditService editService;
    @Autowired
    DeleteService deleteService;
    @Autowired
    UserService userService;
    @Autowired
    ReadCommentService readCommentService;

    @RequestMapping(value = "/write",method = RequestMethod.POST)
    @ResponseBody
    public String write(ArticleForm articleForm,ModelMap modelMap){
        Article article = new Article(new Date(),articleForm.getTitle(),articleForm.getContext(),articleForm.isHascomment());
        Article post = postArticleService.postArticle(article);
        if(post != null){
            modelMap.put("ispost","文章发布成功,id="+post.getArticleid());
            return "文章发布成功,id="+post.getArticleid();
        }else{
            new ModelMap().put("ispost","文章发布失败");
            return "文章发布失败";
        }
    }

    @RequestMapping(value = "/write",method = RequestMethod.GET)
    public String write(HttpSession session,ModelMap modelMap){
        modelMap.put("user_name",session.getAttribute(SessionKey.USER_NAME));
        return "postarticle";
    }

    @RequestMapping(value = "/article",method = RequestMethod.GET)
    public String article(){
        return "redirect:list" ;
    }


    @RequestMapping(value = "/article/{id}",method = RequestMethod.GET)
    public String article(@PathVariable("id") Integer id,ModelMap modelMap){
        Article article = readService.readById(id);
        if(article == null){
            return "forward:errorpage";
        }
        if(article.isHascomment()){
            ArrayList<ReturnComment> comment_list = new ArrayList<>();
            Comment[] comments = readCommentService.getCommentByArticleid(id);
            ArrayList<User> userList = new ArrayList<>();
            for(Comment c: comments){
                int userid = c.getUserid();
                User user = userService.findUserByUserid(userid);
                ReturnComment returnComment = new ReturnComment(c.getArticleid(),c.getInlineid(),user.getUserid(),user.getUsername(),c.getCommentcontext());
                comment_list.add(returnComment);
            }
            modelMap.put("comment_list",comment_list);
        }
        modelMap.put("article",article);
        return "read";
    }

    @RequestMapping(value = "/edit/{id}",method = RequestMethod.GET)
    public String edit(@PathVariable("id") Integer id,ModelMap modelMap){
        Article editArticle = editService.getEditArticle(id);
        if(editArticle==null){
            return "forward:errorpage";
        }
        modelMap.put("edit_article",editArticle);
        return "editarticle";
    }

    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    @ResponseBody
    public String edit(EditForm editForm){
        Article saveArticle = new Article();
        //处理时间
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date dateTime = formatter.parse(editForm.getPostdate());
            saveArticle.setPostdate(dateTime);
        } catch (ParseException e) {
            e.printStackTrace();
            return "forward:errorpage";
        }
        saveArticle.setArticleid(editForm.getArticleid());
        saveArticle.setContext(editForm.getContext());
        saveArticle.setTitle(editForm.getTitle());
        saveArticle.setHascomment(editForm.isHascomment());
        Article article = editService.saveEditArticle(saveArticle);
        if(article==null){
            return "修改失败";
        }
        return "redirect:/article"+saveArticle.getArticleid();
    }

    @RequestMapping(value = "/deletearticle/{id}",method = RequestMethod.GET)
    public String deleteArticle(@PathVariable("id") Integer articleid){
        boolean isDelete = deleteService.deleteArticleById(articleid);

        return "redirect:/list";

    }

}
