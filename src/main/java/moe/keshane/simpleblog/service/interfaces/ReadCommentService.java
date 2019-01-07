package moe.keshane.simpleblog.service.interfaces;

import moe.keshane.simpleblog.dal.entity.Comment;

public interface ReadCommentService {
    Comment[] getCommentByArticleid(int articleid);
}
