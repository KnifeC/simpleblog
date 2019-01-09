package moe.keshane.simpleblog.web;

import com.youbenzi.mdtool.tool.MDTool;
import moe.keshane.simpleblog.common.SessionKey;
import moe.keshane.simpleblog.dal.entity.Article;
import moe.keshane.simpleblog.dal.entity.Comment;
import moe.keshane.simpleblog.dal.entity.User;
import moe.keshane.simpleblog.service.interfaces.*;
import moe.keshane.simpleblog.web.forms.ArticleForm;
import moe.keshane.simpleblog.web.forms.EditForm;
import moe.keshane.simpleblog.web.returnset.ReturnComment;
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

    @RequestMapping(value = "/write", method = RequestMethod.POST)
    public String write(ArticleForm articleForm, ModelMap modelMap) {
        if (articleForm.getTitle().replaceAll("\\s*", "").equals("") || articleForm.getContext().replaceAll("\\s*", "").equals("")) {
            return "error";
        }
        Article article = new Article(new Date(), articleForm.getTitle(), articleForm.getContext().replaceAll("\\\\n", "\n"), articleForm.isHascomment());
        Article post = postArticleService.postArticle(article);
        if (post != null) {
//            modelMap.put("ispost", "文章发布成功,id=" + post.getArticleid());
            return "redirect:/index";
        } else {
//            new ModelMap().put("ispost", "文章发布失败");
            return "error";
        }
    }

    @RequestMapping(value = "/write", method = RequestMethod.GET)
    public String write(HttpSession session, ModelMap modelMap) {
        Object username = session.getAttribute(SessionKey.USER_NAME);
        Object usertype = session.getAttribute(SessionKey.USER_TYPE);
        if (usertype != null && usertype.toString().equals("admin")) {
            modelMap.put("adminpermission", true);
        }
        modelMap.put("username", username);
        return "postarticle";
    }

    @RequestMapping(value = "/article", method = RequestMethod.GET)
    public String article() {
        return "redirect:list";
    }


    @RequestMapping(value = "/article/{id}", method = RequestMethod.GET)
    public String article(@PathVariable("id") Integer id, ModelMap modelMap, HttpSession session) {
        Object username = session.getAttribute(SessionKey.USER_NAME);
        Object usertype = session.getAttribute(SessionKey.USER_TYPE);
        if (usertype != null && usertype.toString().equals("admin")) {
            modelMap.put("adminpermission", true);
        }
        modelMap.put("username", username);
        Article article = readService.readById(id);
        String markD = MDTool.markdown2Html(article.getContext());
        article.setContext(markD);
        if (article == null) {
            return "error";
        }
        if (article.isHascomment()) {
            ArrayList<ReturnComment> comment_list = new ArrayList<>();
            Comment[] comments = readCommentService.getCommentByArticleid(id);
            for (Comment c : comments) {
                int userid = c.getUserid();
                User user = userService.findUserByUserid(userid);
                ReturnComment returnComment = new ReturnComment(c.getArticleid(), c.getInlineid(), user.getUserid(), user.getUsername(), c.getCommentcontext());
                comment_list.add(returnComment);
            }
            modelMap.put("comment_list", comment_list);
        }
        modelMap.put("artile_title",article.getTitle());
        modelMap.put("article", article);
        return "read";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable("id") Integer id, ModelMap modelMap, HttpSession session) {
        Object username = session.getAttribute(SessionKey.USER_NAME);
        Object usertype = session.getAttribute(SessionKey.USER_TYPE);
        if (usertype != null && usertype.toString().equals("admin")) {
            modelMap.put("adminpermission", true);
        }
        modelMap.put("username", username);
        Article editArticle = editService.getEditArticle(id);
        if (editArticle == null) {
            return "error";
        }
        modelMap.put("edit_article", editArticle);
        return "editarticle";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(EditForm editForm) {
        if (editForm.getTitle().replaceAll("\\s*", "").equals("") || editForm.getContext().replaceAll("\\s*", "").equals("")) {
            return "error";
        }
        Article saveArticle = new Article();
        //处理时间
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date dateTime = formatter.parse(editForm.getPostdate());
            saveArticle.setPostdate(dateTime);
        } catch (ParseException e) {
            e.printStackTrace();
            return "error";
        }
        saveArticle.setArticleid(editForm.getArticleid());
        saveArticle.setContext(editForm.getContext());
        saveArticle.setTitle(editForm.getTitle());
        saveArticle.setHascomment(editForm.isHascomment());
        Article article = editService.saveEditArticle(saveArticle);
        if (article == null) {
            return "error";
        }
        return "redirect:/article/" + saveArticle.getArticleid();
    }

    @RequestMapping(value = "/deletearticle/{id}", method = RequestMethod.GET)
    public String deleteArticle(@PathVariable("id") Integer articleid) {
        boolean isDelete = deleteService.deleteArticleById(articleid);
        if (isDelete) {
            return "redirect:/list";
        } else {
            return "error";
        }

    }

}
