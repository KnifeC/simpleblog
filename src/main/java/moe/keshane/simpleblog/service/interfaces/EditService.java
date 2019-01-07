package moe.keshane.simpleblog.service.interfaces;

import moe.keshane.simpleblog.dal.entity.Article;

public interface EditService {
    Article getEditArticle(int articleid);
    Article saveEditArticle(Article article);
}
