package moe.keshane.simpleblog.service.implement;

import moe.keshane.simpleblog.dal.CommentRepo;
import moe.keshane.simpleblog.dal.entity.Comment;
import moe.keshane.simpleblog.service.interfaces.ReadCommentService;
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
