package moe.keshane.gradleblog.dal.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Comment {
    @Id
    private int articleid;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int inlineid;
    private int replyid;
    private int userid;
    private String commentcontext;

}
