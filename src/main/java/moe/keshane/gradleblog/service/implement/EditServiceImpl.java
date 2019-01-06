package moe.keshane.gradleblog.service.implement;

import moe.keshane.gradleblog.dal.ArticleRepo;
import moe.keshane.gradleblog.dal.entity.Article;
import moe.keshane.gradleblog.service.interfaces.EditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
