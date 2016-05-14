package by.aleks.geekschat;

/**
 * Created by Alex on 5/14/16.
 */
public class User {
    private String name;
    private String email;
    private int friendsNum;
    private String imgSrc;

    public User(String name, String email, int friendsNum, String imgSrc) {
        this.name = name;
        this.email = email;
        this.friendsNum = friendsNum;
        this.imgSrc = imgSrc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getFriendsNum() {
        return friendsNum;
    }

    public void setFriendsNum(int friendsNum) {
        this.friendsNum = friendsNum;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }
}
