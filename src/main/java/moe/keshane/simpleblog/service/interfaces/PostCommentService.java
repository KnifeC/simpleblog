package moe.keshane.simpleblog.service.interfaces;

import moe.keshane.simpleblog.dal.entity.Comment;

public interface PostCommentService {
    Comment postComment(Comment comment);
}
