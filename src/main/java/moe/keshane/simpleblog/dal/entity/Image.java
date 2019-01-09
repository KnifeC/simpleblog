package moe.keshane.simpleblog.dal.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "image")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int imageid;
    private int userid;
    private Date uploaddate;
    private String imageurl;
    private String deleteurl;

    public Image(int userid, Date uploaddate, String imageurl, String deleteurl) {
        this.userid = userid;
        this.uploaddate = uploaddate;
        this.imageurl = imageurl;
        this.deleteurl = deleteurl;
    }

    public Image() {
    }

    public int getImageid() {
        return imageid;
    }

    public void setImageid(int imageid) {
        this.imageid = imageid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public Date getUploaddate() {
        return uploaddate;
    }

    public void setUploaddate(Date uploaddate) {
        this.uploaddate = uploaddate;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getDeleteurl() {
        return deleteurl;
    }

    public void setDeleteurl(String deleteurl) {
        this.deleteurl = deleteurl;
    }
}
