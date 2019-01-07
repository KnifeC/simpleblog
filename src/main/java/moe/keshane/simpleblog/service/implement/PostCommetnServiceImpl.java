package moe.keshane.simpleblog.service.implement;

import moe.keshane.simpleblog.dal.CommentRepo;
import moe.keshane.simpleblog.dal.entity.Comment;
import moe.keshane.simpleblog.service.interfaces.PostCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostCommetnServiceImpl implements PostCommentService {
    @Autowired
    CommentRepo commentRepo;
    @Override
    public Comment postComment(Comment comment) {
        try {
            Comment posted = commentRepo.save(comment);
            return posted;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
