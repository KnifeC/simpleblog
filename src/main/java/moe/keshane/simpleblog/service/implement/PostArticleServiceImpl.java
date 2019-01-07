package moe.keshane.simpleblog.service.implement;

import moe.keshane.simpleblog.dal.ArticleRepo;
import moe.keshane.simpleblog.dal.entity.Article;
import moe.keshane.simpleblog.service.interfaces.PostArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostArticleServiceImpl implements PostArticleService {
    @Autowired
    ArticleRepo articleRepo;

    @Override
    public Article postArticle(Article article) {
        try{
            articleRepo.save(article);
            return article;
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
