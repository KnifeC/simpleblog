package moe.keshane.simpleblog.dal;

import moe.keshane.simpleblog.dal.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comment,Integer> {
//    boolean deleteByInlineid(int commentid);
    Comment[] findAllByArticleidOrderByInlineidDesc(int articleid);
    Comment[] findAllByUserid(int userid);
    Comment[] findAllByArticleidAndUserid(int articleid,int userid);
}
