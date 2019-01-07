package moe.keshane.simpleblog.service.implement;

import moe.keshane.simpleblog.dal.ArticleRepo;
import moe.keshane.simpleblog.dal.entity.Article;
import moe.keshane.simpleblog.service.interfaces.EditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EditServiceImpl implements EditService {
    @Autowired
    ArticleRepo articleRepo;
    @Override
    public Article getEditArticle(int articleid) {
        try {
            Article articleNeedEdit = articleRepo.findOneByArticleid(articleid);
            return  articleNeedEdit;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public Article saveEditArticle(Article article) {
        try {
            articleRepo.save(article);
            return  article;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
