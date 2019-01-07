package moe.keshane.simpleblog.dal.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "article")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int articleid;

    private Date postdate;
    private String title;
    @Lob
    private String context;
    private boolean hascomment = false;

    @Override
    public String toString() {
        return "Article{" +
                "articleid=" + articleid +
                ", postdate=" + postdate +
                ", title='" + title + '\'' +
                ", context='" + context + '\'' +
                ", hascomment=" + hascomment +
                '}';
    }

    public Article() {
    }

    public Article(Date postdate, String title, String context) {
        this.postdate = postdate;
        this.title = title;
        this.context = context;
    }

    public Article(Date postdate, String title, String context, boolean hascomment) {
        this.postdate = postdate;
        this.title = title;
        this.context = context;
        this.hascomment = hascomment;
    }

    public int getArticleid() {
        return articleid;
    }

    public void setArticleid(int articleid) {
        this.articleid = articleid;
    }

    public Date getPostdate() {
        return postdate;
    }

    public void setPostdate(Date postdate) {
        this.postdate = postdate;
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

    public boolean isHascomment() {
        return hascomment;
    }

    public void setHascomment(boolean hascomment) {
        this.hascomment = hascomment;
    }
}
