package moe.keshane.gradleblog.service.interfaces;

import moe.keshane.gradleblog.dal.entity.Article;

public interface PostArticleService {
    Article postArticle(Article article);
}
