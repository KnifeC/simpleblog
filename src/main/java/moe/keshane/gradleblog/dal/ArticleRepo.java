package moe.keshane.gradleblog.dal;

import moe.keshane.gradleblog.dal.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepo extends JpaRepository<Article,Integer> {
    Article findOneByArticleid(int articleid);
    Article findAllByTitle(String title);

}
