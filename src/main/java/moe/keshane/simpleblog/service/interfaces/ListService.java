package moe.keshane.simpleblog.service.interfaces;

import moe.keshane.simpleblog.dal.entity.Article;

import java.util.ArrayList;

public interface ListService {
    ArrayList<Article> listAllArticle();
}
