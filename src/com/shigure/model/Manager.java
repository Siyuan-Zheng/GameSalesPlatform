package com.shigure.model;

public class Manager {
    private int managerId;
    private String managerName;
    private String managerPassword;
    private String managerMail;
    private String managerPhoneNum;

    public Manager(String managerName, String managerPassword) {
        this.managerName = managerName;
        this.managerPassword = managerPassword;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getManagerPassword() {
        return managerPassword;
    }

    public void setManagerPassword(String managerPassword) {
        this.managerPassword = managerPassword;
    }

    public String getManagerMail() {
        return managerMail;
    }

    public void setManagerMail(String managerMail) {
        this.managerMail = managerMail;
    }

    public String getManagerPhoneNum() {
        return managerPhoneNum;
    }

    public void setManagerPhoneNum(String managerPhoneNum) {
        this.managerPhoneNum = managerPhoneNum;
    }

    public Manager(int managerId, String managerName, String managerPassword, String managerMail, String managerPhoneNum) {

        this.managerId = managerId;
        this.managerName = managerName;
        this.managerPassword = managerPassword;
        this.managerMail = managerMail;
        this.managerPhoneNum = managerPhoneNum;
    }

    public Manager() {
    }

}
