package moe.keshane.simpleblog.web.forms;

public class UpdateUserForm {
    private int userid;
    private String username;
    private String password;
    private String type = "user";

    public UpdateUserForm() {
    }

    public UpdateUserForm(int userid, String username, String password, String type) {
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.type = type;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
