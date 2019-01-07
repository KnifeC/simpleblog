package moe.keshane.gradleblog.service.interfaces;

import moe.keshane.gradleblog.dal.entity.Comment;

public interface PostCommentService {
    Comment postComment(Comment comment);
}
