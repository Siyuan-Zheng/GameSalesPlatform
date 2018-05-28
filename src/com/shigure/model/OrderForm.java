package com.shigure.model;

public class OrderForm {
    private int orderId;
    private int userId;
    private int gameId;
    private double gamePrice;
    private long orderTime;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public double getGamePrice() {
        return gamePrice;
    }

    public void setGamePrice(double gamePrice) {
        this.gamePrice = gamePrice;
    }

    public long getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(long orderTime) {
        this.orderTime = orderTime;
    }

    public OrderForm() {

    }

    public OrderForm(int orderId, int userId, int gameId, double gamePrice, long orderTime) {

        this.orderId = orderId;
        this.userId = userId;
        this.gameId = gameId;
        this.gamePrice = gamePrice;
        this.orderTime = orderTime;
    }
}
