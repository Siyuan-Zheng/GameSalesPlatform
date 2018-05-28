package com.shigure.dao;

import com.shigure.model.Game;
import com.shigure.util.StringUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GameDao {

    public static int gameTypeAdd(Connection con, Game game) throws SQLException {
        String sql = "insert into t_game values(null,?,?,?,?,?,0,?,?,?)";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1,game.getGameName());
        pstmt.setString(2,game.getGameDesc());
        pstmt.setInt(3,game.getGameTypeId());
        pstmt.setDouble(4,game.getGamePrice());
        pstmt.setDouble(5,game.getGameDiscountNum());
        pstmt.setString(6,game.getGamePressTime());
        pstmt.setInt(7,game.getPressId());
        pstmt.setInt(8,game.getImageId());
        return pstmt.executeUpdate();
    }

    public static Game getGameByName(Connection con, Game game) throws Exception{
        Game resultGame = new Game();
        String sql = "select * from t_game where gameName=?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, game.getGameName());
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()){
            resultGame.setGameName(rs.getString("gameId"));
            resultGame.setGameDesc(rs.getString("gameDesc"));
            resultGame.setGameTypeId(rs.getInt("gameTypeId"));
            resultGame.setGamePrice(rs.getDouble("gamePrice"));
            resultGame.setGameDiscountNum(rs.getInt("gameDiscountNum"));
            resultGame.setGamePressTime(rs.getString("gamePressedTime"));
            resultGame.setPressId(rs.getInt("pressId"));
            resultGame.setImageId(rs.getInt("imageId"));
        }
        return resultGame;
    }

    public static ResultSet gameList(Connection con, Game game) throws SQLException{
        StringBuilder sb = new StringBuilder("select * from t_game");
        if(StringUtils.isNotEmpty(game.getGameName())){
            sb.append(" and gameName like '%").append(game.getGameName()).append("%'");
        }
        PreparedStatement psmt = con.prepareStatement(sb.toString().replaceFirst("and","where"));
        return psmt.executeQuery();
    }

}
