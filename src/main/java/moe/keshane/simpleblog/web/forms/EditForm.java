package moe.keshane.simpleblog.web.forms;

public class EditForm {

    private int articleid;

    private String postdate;
    private String title;
    private String context;
    private boolean hascomment;

    public EditForm() {
    }

    public EditForm(int articleid, String postdate, String title, String context, boolean hascomment) {
        this.articleid = articleid;
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

    public String getPostdate() {
        return postdate;
    }

    public void setPostdate(String postdate) {
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
