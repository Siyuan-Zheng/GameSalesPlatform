package com.shigure.model;

public class Press {
    private int pressId;
    private String pressName;
    private String pressDesc;

    public Press(String pressName, String pressDesc) {
        this.pressName = pressName;
        this.pressDesc = pressDesc;
    }

    public Press(String pressName) {
        this.pressName = pressName;
    }

    public Press() {
    }

    public int getPressId() {

        return pressId;
    }

    public void setPressId(int pressId) {
        this.pressId = pressId;
    }

    public String getPressName() {
        return pressName;
    }

    public void setPressName(String pressName) {
        this.pressName = pressName;
    }

    public String getPressDesc() {
        return pressDesc;
    }

    public void setPressDesc(String pressDesc) {
        this.pressDesc = pressDesc;
    }

    public Press(int pressId, String pressName, String pressDesc) {
        this.pressId = pressId;
        this.pressName = pressName;
        this.pressDesc = pressDesc;
    }
}
