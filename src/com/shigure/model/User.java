package com.shigure.model;

public class User {
    private int userId;
    private String userName;
    private String userPassword;
    private String userMail;
    private String userPhoneNum;
    private int imageId;

    public int getUserId() {
        return userId;
    }

    public User(String userName, String userPassword) {
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public User(String userName, String userPassword, String userMail, String userPhoneNum, int imageId) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.userMail = userMail;
        this.userPhoneNum = userPhoneNum;
        this.imageId = imageId;
    }

    public User(String userName, String userPassword, String userMail, String userPhoneNum) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.userMail = userMail;
        this.userPhoneNum = userPhoneNum;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public String getUserPhoneNum() {
        return userPhoneNum;
    }

    public void setUserPhoneNum(String userPhoneNum) {
        this.userPhoneNum = userPhoneNum;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public User() {

    }

    public User(int userId, String userName, String userPassword, String userMail, String userPhoneNum, int imageId) {

        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userMail = userMail;
        this.userPhoneNum = userPhoneNum;
        this.imageId = imageId;
    }
}
