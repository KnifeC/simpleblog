package moe.keshane.simpleblog.dal;

import moe.keshane.simpleblog.dal.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface ArticleRepo extends JpaRepository<Article,Integer> {
    Article findOneByArticleid(int articleid);
    Article findAllByTitle(String title);
    ArrayList<Article> findAllByOrderByPostdateDesc();
}
