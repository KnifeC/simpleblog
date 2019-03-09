package moe.keshane.simpleblog.service.implement;

import moe.keshane.simpleblog.dal.CommentRepo;
import moe.keshane.simpleblog.dal.entity.Comment;
import moe.keshane.simpleblog.service.interfaces.DeleteCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteCommentImpl implements DeleteCommentService {
    @Autowired
    CommentRepo commentRepo;
    @Override
    public boolean deleteCommentById(int commentid) {
        try {
            commentRepo.deleteById(commentid);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
