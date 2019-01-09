package moe.keshane.simpleblog.service.interfaces;

import moe.keshane.simpleblog.dal.entity.Article;
import org.springframework.data.domain.Page;

import java.util.ArrayList;

public interface ListService {
    ArrayList<Article> listAllArticle();
    Page<Article> listPageArticle(int pageindex);
}
