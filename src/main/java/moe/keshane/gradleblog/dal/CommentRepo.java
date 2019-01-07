package moe.keshane.gradleblog.dal;

import moe.keshane.gradleblog.dal.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comment,Integer> {
    Comment[] findAllByArticleidOrderByInlineid(int articleid);
    Comment[] findAllByUserid(int userid);
    Comment[] findAllByArticleidAndUserid(int articleid,int userid);
}
