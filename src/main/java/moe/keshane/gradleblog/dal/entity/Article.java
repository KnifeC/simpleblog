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
    private boolean hascomment = false;

    @Override
    public String toString() {
        return "Article{" +
                "articleid=" + articleid +
                ", pubdate=" + pubdate +
                ", title='" + title + '\'' +
                ", context='" + context + '\'' +
                ", hascomment=" + hascomment +
                '}';
    }

    public Article(Date pubdate, String title, String context, boolean hascomment) {
        this.pubdate = pubdate;
        this.title = title;
        this.context = context;
        this.hascomment = hascomment;
    }

    public Article(Date pubdate, String title, String context) {
        this.pubdate = pubdate;
        this.title = title;
        this.context = context;
    }

    public Article() {
    }

    public boolean isHascomment() {
        return hascomment;
    }

    public void setHascomment(boolean hascomment) {
        this.hascomment = hascomment;
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
