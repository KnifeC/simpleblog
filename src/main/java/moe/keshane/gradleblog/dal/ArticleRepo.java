package moe.keshane.gradleblog.dal;

import moe.keshane.gradleblog.dal.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepo extends JpaRepository<Article,Integer> {
    public Article findOneByArticleid(int articleid);
    public Article findAllByTitle(String title);
}
