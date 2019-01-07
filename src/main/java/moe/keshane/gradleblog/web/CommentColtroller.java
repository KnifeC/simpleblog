package moe.keshane.gradleblog.web;

import moe.keshane.gradleblog.common.SessionKey;
import moe.keshane.gradleblog.dal.entity.Comment;
import moe.keshane.gradleblog.service.interfaces.PostCommentService;
import moe.keshane.gradleblog.web.forms.PostCommentForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class CommentColtroller {

    @Autowired
    PostCommentService postCommentService;

    @RequestMapping(value = "/postcomment", method = RequestMethod.POST)
    public String postComment(PostCommentForm postCommentForm, HttpSession session) {
        Comment comment = new Comment(postCommentForm.getArticleid(), (int) session.getAttribute(SessionKey.USER_ID), postCommentForm.getCommentcontext());
        Comment posted = postCommentService.postComment(comment);
        if (posted != null) {
            return "redirect:/article/" + posted.getArticleid();
        } else {
            return "/error";
        }
    }


}
