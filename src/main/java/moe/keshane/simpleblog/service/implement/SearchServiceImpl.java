package moe.keshane.simpleblog.service.implement;

import moe.keshane.simpleblog.dal.entity.Article;
import moe.keshane.simpleblog.service.interfaces.SearchService;
import org.springframework.stereotype.Service;

@Service
public class SearchServiceImpl implements SearchService {
    @Override
    public Article searchById(int articleid) {
        return null;
    }

    @Override
    public Article[] searchByTitle(String title) {
        return new Article[0];
    }
}
