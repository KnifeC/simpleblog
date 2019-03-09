package moe.keshane.simpleblog.web;

import moe.keshane.simpleblog.common.SessionKey;
import moe.keshane.simpleblog.dal.entity.Comment;
import moe.keshane.simpleblog.service.interfaces.DeleteCommentService;
import moe.keshane.simpleblog.service.interfaces.PostCommentService;
import moe.keshane.simpleblog.web.forms.PostCommentForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class CommentColtroller {

    @Autowired
    PostCommentService postCommentService;
    @Autowired
    DeleteCommentService deleteCommentService;

    @RequestMapping(value = "/postcomment", method = RequestMethod.POST)
    public String postComment(PostCommentForm postCommentForm, HttpSession session) {
        if(postCommentForm.getCommentcontext().replaceAll("\\s*", "").equals("")){
            return "error";
        }
        Comment comment = new Comment(postCommentForm.getArticleid(), (int) session.getAttribute(SessionKey.USER_ID), postCommentForm.getCommentcontext());
        Comment posted = postCommentService.postComment(comment);
        if (posted != null) {
            return "redirect:/article/" + posted.getArticleid();
        } else {
            return "/error";
        }
    }

    @RequestMapping(value = "/deletecomment/{commentid}" ,method = RequestMethod.GET)
    public String deleteComment(@PathVariable("commentid") Integer commentid){
        boolean isdelete = deleteCommentService.deleteCommentById(commentid);
        return "redirect:/article/";
    }

}
