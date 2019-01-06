package moe.keshane.gradleblog.web.forms;


public class ArticleForm {

    private String title;
    private String context;
    private boolean hascomment = false;


    public ArticleForm() {
    }

    public ArticleForm(String title, String context, boolean hascomment) {
        this.title = title;
        this.context = context;
        this.hascomment = hascomment;
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

