package moe.keshane.gradleblog.service.interfaces;

import moe.keshane.gradleblog.dal.entity.Article;

public interface EditService {
    Article getEditArticle(int articleid);
    Article saveEditArticle(Article article);
}
