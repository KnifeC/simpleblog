package moe.keshane.gradleblog.service.interfaces;

import moe.keshane.gradleblog.dal.entity.Article;

import java.util.ArrayList;

public interface ListService {
    ArrayList<Article> listAllArticle();
}
