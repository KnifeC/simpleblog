package moe.keshane.gradleblog.service.interfaces;

import moe.keshane.gradleblog.dal.entity.Article;

public interface ReadService {
    Article readById(int articleid);
}
