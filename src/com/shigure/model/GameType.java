package com.shigure.model;

public class GameType {
    private int gameTypeId;
    private String gameTypeName;

    public GameType() {
    }

    public GameType(String gameTypeName) {
        this.gameTypeName = gameTypeName;
    }

    public GameType(int gameTypeId, String gameTypeName) {
        this.gameTypeId = gameTypeId;
        this.gameTypeName = gameTypeName;
    }

    public int getGameTypeId() {
        return gameTypeId;
    }

    public void setGameTypeId(int gameTypeId) {
        this.gameTypeId = gameTypeId;
    }

    public String getGameTypeName() {
        return gameTypeName;
    }

    public void setGameTypeName(String gameTypeName) {
        this.gameTypeName = gameTypeName;
    }
}
