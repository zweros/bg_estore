package cn.szxy.pojo;

/**
 * @Auther:wzer
 * @Date:2019/5/30
 * @Description:cn.szxy.pojo
 * @Version:1.0
 **/
public class Users {
    private int userid;
    private String username;
    private String password;

    public Users() {

    }

    public Users(String username, String password) {
        this.username = username;
        this.password = password;
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

    @Override
    public String toString() {
        return "Users{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
