package moe.keshane.gradleblog.service.implement;

import moe.keshane.gradleblog.dal.ArticleRepo;
import moe.keshane.gradleblog.dal.entity.Article;
import moe.keshane.gradleblog.service.interfaces.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    ArticleRepo articleRepo;

    @Override
    public int postArticle(Article article) {
        try{
            articleRepo.save(article);
            return article.getArticleid();
        }catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
