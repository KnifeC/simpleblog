package moe.keshane.simpleblog.web.returnset;

public class ReturnImage {
    private String image;
    private String date;
    private String imageurl;

    public ReturnImage() {
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public ReturnImage(String image, String date, String imageurl) {
        this.image = image;
        this.date = date;
        this.imageurl = imageurl;
    }
}
