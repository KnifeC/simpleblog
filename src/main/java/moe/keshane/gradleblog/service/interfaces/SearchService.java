package moe.keshane.gradleblog.service.interfaces;

import moe.keshane.gradleblog.dal.entity.Article;

public interface SearchService {
    Article searchById(int articleid);
    Article[] searchByTitle(String title);
}
