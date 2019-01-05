package moe.keshane.gradleblog.dal.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "article")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int articleid;
    private Date pubdate;
    private String title;
    private String context;

    @Override
    public String toString() {
        return "Article{" +
                "articleid=" + articleid +
                ", pubdate=" + pubdate +
                ", title='" + title + '\'' +
                ", context='" + context + '\'' +
                '}';
    }

    public int getArticleid() {
        return articleid;
    }

    public void setArticleid(int articleid) {
        this.articleid = articleid;
    }

    public Date getPubdate() {
        return pubdate;
    }

    public void setPubdate(Date pubdate) {
        this.pubdate = pubdate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
}
