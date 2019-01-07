package moe.keshane.gradleblog.service.implement;

import moe.keshane.gradleblog.dal.CommentRepo;
import moe.keshane.gradleblog.dal.entity.Comment;
import moe.keshane.gradleblog.service.interfaces.ReadCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReadCommentServiceImple implements ReadCommentService {
    @Autowired
    CommentRepo commentRepo;

    @Override
    public Comment[] getCommentByArticleid(int articleid) {
        try {
            Comment[] all = commentRepo.findAllByArticleidOrderByInlineid(articleid);
            return all;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
