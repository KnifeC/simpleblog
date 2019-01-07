package moe.keshane.gradleblog.service.implement;

import moe.keshane.gradleblog.dal.ArticleRepo;
import moe.keshane.gradleblog.dal.entity.Article;
import moe.keshane.gradleblog.service.interfaces.PostArticleService;
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
