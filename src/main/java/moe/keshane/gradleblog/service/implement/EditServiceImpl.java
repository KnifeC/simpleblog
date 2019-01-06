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
        Article articleNeedEdit = articleRepo.findOneByArticleid(articleid);

        return  articleNeedEdit;
    }

    @Override
    public Article saveEditArticle(Article article) {
        return null;
    }
}
