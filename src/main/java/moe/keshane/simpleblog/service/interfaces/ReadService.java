package moe.keshane.simpleblog.service.interfaces;

import moe.keshane.simpleblog.dal.entity.Article;

public interface ReadService {
    Article readById(int articleid);
}
