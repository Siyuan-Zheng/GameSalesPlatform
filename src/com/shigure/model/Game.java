package com.shigure.model;

public class Game {
    private int gameId;
    private String gameName;
    private String  gameDesc;
    private int gameTypeId;
    private double gamePrice;
    private double gameDiscountNum;
    private int gameSalesVolume;
    private String gamePressTime;
    private int pressId;
    private int imageId;

    public Game(String gameName, String gameDesc, int gameTypeId, double gamePrice, double gameDiscountNum, String gamePressTime, int pressId, int imageId) {
        this.gameName = gameName;
        this.gameDesc = gameDesc;
        this.gameTypeId = gameTypeId;
        this.gamePrice = gamePrice;
        this.gameDiscountNum = gameDiscountNum;
        this.gamePressTime = gamePressTime;
        this.pressId = pressId;
        this.imageId = imageId;
    }

    public Game(String gameName) {
        this.gameName = gameName;
    }

    public Game() {
    }

    public Game(int gameId, String gameName, String gameDesc, int gameTypeId, double gamePrice, double gameDiscountNum, int gameSalesVolume, String gamePressTime, int pressId, int imageId) {
        this.gameId = gameId;
        this.gameName = gameName;
        this.gameDesc = gameDesc;
        this.gameTypeId = gameTypeId;
        this.gamePrice = gamePrice;
        this.gameDiscountNum = gameDiscountNum;
        this.gameSalesVolume = gameSalesVolume;
        this.gamePressTime = gamePressTime;
        this.pressId = pressId;
        this.imageId = imageId;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getGameDesc() {
        return gameDesc;
    }

    public void setGameDesc(String gameDesc) {
        this.gameDesc = gameDesc;
    }

    public int getGameTypeId() {
        return gameTypeId;
    }

    public void setGameTypeId(int gameTypeId) {
        this.gameTypeId = gameTypeId;
    }

    public double getGamePrice() {
        return gamePrice;
    }

    public void setGamePrice(double gamePrice) {
        this.gamePrice = gamePrice;
    }

    public double getGameDiscountNum() {
        return gameDiscountNum;
    }

    public void setGameDiscountNum(double gameDiscountNum) {
        this.gameDiscountNum = gameDiscountNum;
    }

    public int getGameSalesVolume() {
        return gameSalesVolume;
    }

    public void setGameSalesVolume(int gameSalesVolume) {
        this.gameSalesVolume = gameSalesVolume;
    }

    public String getGamePressTime() {
        return gamePressTime;
    }

    public void setGamePressTime(String gamePressTime) {
        this.gamePressTime = gamePressTime;
    }

    public int getPressId() {
        return pressId;
    }

    public void setPressId(int pressId) {
        this.pressId = pressId;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
