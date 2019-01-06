package moe.keshane.gradleblog.web.forms;

import java.util.Date;

public class ArticleForm {

    private String title;
    private String context;
    private boolean hascomment = false;

    @Override
    public String toString() {
        return "ArticleForm{" +
                "title='" + title + '\'' +
                ", context='" + context + '\'' +
                ", hascomment=" + hascomment +
                '}';
    }

    public boolean isHascomment() {
        return hascomment;
    }

    public void setHascomment(boolean hascomment) {
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
}

