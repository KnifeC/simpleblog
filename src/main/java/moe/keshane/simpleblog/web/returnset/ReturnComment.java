package moe.keshane.simpleblog.web.returnset;

public class ReturnComment {
    private int inlineid;
    private int articleid;
    private int userid;
    private String username;
    private String commentcontext;

    public ReturnComment() {
    }

    public ReturnComment(int inlineid, int articleid, int userid, String username, String commentcontext) {
        this.inlineid = inlineid;
        this.articleid = articleid;
        this.userid = userid;
        this.username = username;
        this.commentcontext = commentcontext;
    }

    public int getInlineid() {
        return inlineid;
    }

    public void setInlineid(int inlineid) {
        this.inlineid = inlineid;
    }

    public int getArticleid() {
        return articleid;
    }

    public void setArticleid(int articleid) {
        this.articleid = articleid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCommentcontext() {
        return commentcontext;
    }

    public void setCommentcontext(String commentcontext) {
        this.commentcontext = commentcontext;
    }
}
