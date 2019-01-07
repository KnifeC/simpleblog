package moe.keshane.simpleblog.web.forms;

public class PostCommentForm {
    private int articleid;
    private String commentcontext;

    public PostCommentForm() {
    }

    public PostCommentForm(int articleid, String commentcontext) {
        this.articleid = articleid;
        this.commentcontext = commentcontext;
    }

    public int getArticleid() {
        return articleid;
    }

    public void setArticleid(int articleid) {
        this.articleid = articleid;
    }

    public String getCommentcontext() {
        return commentcontext;
    }

    public void setCommentcontext(String commentcontext) {
        this.commentcontext = commentcontext;
    }
}
