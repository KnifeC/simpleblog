package moe.keshane.simpleblog.service.interfaces;

import moe.keshane.simpleblog.dal.entity.Article;

public interface SearchService {
    Article searchById(int articleid);
    Article[] searchByTitle(String title);
}
