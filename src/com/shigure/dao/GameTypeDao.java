package com.shigure.dao;

import com.shigure.model.GameType;
import com.shigure.util.StringUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GameTypeDao {

    public static int gameTypeAdd(Connection con, GameType gameType) throws SQLException {
        String sql = "insert into t_gameType values(null,?)";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1,gameType.getGameTypeName());
        return pstmt.executeUpdate();
    }

    public static int gameTypeUpdate(Connection con,GameType gameType, String originalGameTypeName) throws SQLException{
        String sql = "update t_gameType set gameTypeName=? where gameTypeName=?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1,gameType.getGameTypeName());
        pstmt.setString(2,originalGameTypeName);
        return pstmt.executeUpdate();
    }

    public static GameType getGameTypeIdByName(Connection con, GameType gameType) throws SQLException{
        GameType resultGameType = new GameType();
        String sql = "select * from t_gameType where gameTypeName=?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, gameType.getGameTypeName());
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()){
            resultGameType.setGameTypeId(rs.getInt("gameTypeId"));
        }
        return resultGameType;
    }

    public static GameType getGameTypeNameById(Connection con, int id) throws SQLException{
        GameType resultGameType = new GameType();
        String sql = "select * from t_gameType where gameTypeId=?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()){
            resultGameType.setGameTypeName(rs.getString("gameTypeName"));
        }
        return resultGameType;
    }

    public static ResultSet gameTypeList(Connection con, GameType gameType) throws SQLException{
        StringBuilder sb = new StringBuilder("select * from t_gameType");
        if(StringUtils.isNotEmpty(gameType.getGameTypeName())){
            sb.append(" and gameTypeName like '%").append(gameType.getGameTypeName()).append("%'");
        }
        PreparedStatement psmt = con.prepareStatement(sb.toString().replaceFirst("and","where"));
        return psmt.executeQuery();
    }

    public static int gameTypeDelete(Connection con,GameType gameType) throws SQLException {
        String sql = "delete from t_gameType where gameTypeName = ?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1,gameType.getGameTypeName());
        return pstmt.executeUpdate();
    }

}
