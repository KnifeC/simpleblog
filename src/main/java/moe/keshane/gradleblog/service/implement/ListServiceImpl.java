package moe.keshane.gradleblog.service.implement;

import moe.keshane.gradleblog.dal.ArticleRepo;
import moe.keshane.gradleblog.dal.entity.Article;
import moe.keshane.gradleblog.service.interfaces.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ListServiceImpl implements ListService {

    @Autowired
    ArticleRepo articleRepo;

    @Override
    public ArrayList<Article> listAllArticle() {
        try {
            List<Article> all = articleRepo.findAll();
            return (ArrayList<Article>) all;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
