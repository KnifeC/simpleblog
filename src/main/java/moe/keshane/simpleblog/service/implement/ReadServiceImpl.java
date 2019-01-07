package moe.keshane.simpleblog.service.implement;

import moe.keshane.simpleblog.dal.ArticleRepo;
import moe.keshane.simpleblog.dal.entity.Article;
import moe.keshane.simpleblog.service.interfaces.ReadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReadServiceImpl implements ReadService {

    @Autowired
    ArticleRepo articleRepo;

    @Override
    public Article readById(int articleid) {
        try {
            Article article = articleRepo.findOneByArticleid(articleid);
            return article;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
