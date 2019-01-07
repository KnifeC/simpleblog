package moe.keshane.gradleblog.dal.entity;

import javax.persistence.*;

@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int inlineid;

    private int articleid;
    @Column(nullable = true)
    private int replyid;
    private int userid;
    @Lob
    private String commentcontext;

    public Comment(int articleid,  int userid, String commentcontext) {
        this.articleid = articleid;
        this.userid = userid;
        this.commentcontext = commentcontext;
    }

    public Comment() {
    }

    public int getArticleid() {
        return articleid;
    }

    public void setArticleid(int articleid) {
        this.articleid = articleid;
    }

    public int getInlineid() {
        return inlineid;
    }

    public void setInlineid(int inlineid) {
        this.inlineid = inlineid;
    }

    public int getReplyid() {
        return replyid;
    }

    public void setReplyid(int replyid) {
        this.replyid = replyid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getCommentcontext() {
        return commentcontext;
    }

    public void setCommentcontext(String commentcontext) {
        this.commentcontext = commentcontext;
    }
}
