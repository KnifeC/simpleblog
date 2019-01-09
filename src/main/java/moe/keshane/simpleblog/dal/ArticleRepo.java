package moe.keshane.simpleblog.dal;

import moe.keshane.simpleblog.dal.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.ArrayList;

public interface ArticleRepo extends PagingAndSortingRepository<Article,Integer> {
    Article findOneByArticleid(int articleid);
    Article findAllByTitle(String title);
    ArrayList<Article> findAllByOrderByPostdateDesc();
}
