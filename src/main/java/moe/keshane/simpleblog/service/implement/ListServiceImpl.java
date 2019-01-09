package moe.keshane.simpleblog.service.implement;

import moe.keshane.simpleblog.configure.PageConfig;
import moe.keshane.simpleblog.dal.ArticleRepo;
import moe.keshane.simpleblog.dal.entity.Article;
import moe.keshane.simpleblog.service.interfaces.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ListServiceImpl implements ListService {

    @Autowired
    ArticleRepo articleRepo;

    @Override
    public ArrayList<Article> listAllArticle() {
        try {
//            Sort s=new Sort(Sort.Direction.DESC, "postdate");
            ArrayList<Article> all = articleRepo.findAllByOrderByPostdateDesc();
            return all;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Page<Article> listPageArticle(int pageindex) {
        try {
            Page<Article> page = articleRepo.findAll(new PageRequest(((int) pageindex) - 1, PageConfig.PAGE_SIZE, new Sort(Sort.Direction.DESC, "postdate")));
            return page;
        } catch (Exception e) {
            return null;
        }
    }
}
