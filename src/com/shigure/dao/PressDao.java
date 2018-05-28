package com.shigure.dao;

import com.shigure.model.Press;
import com.shigure.util.StringUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PressDao {

    public static int pressAdd(Connection con, Press press) throws SQLException {
        String sql = "insert into t_press values(null,?,?)";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, press.getPressName());
        pstmt.setString(2, press.getPressDesc());
        return pstmt.executeUpdate();
    }

    public static int pressUpdate(Connection con,Press press, String originalPressName) throws SQLException{
        String sql = "update t_press set pressName=? , pressDesc =? where pressName=?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1,press.getPressName());
        pstmt.setString(2,press.getPressDesc());
        pstmt.setString(3,originalPressName);
        return pstmt.executeUpdate();
    }

    public static Press getPressDescAndIdByName(Connection con, Press press) throws Exception{
        Press resultPress = new Press();
        String sql = "select * from t_press where pressName=?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, press.getPressName());
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()){
            resultPress.setPressId(rs.getInt("pressId"));
            resultPress.setPressDesc(rs.getString("pressDesc"));
        }
        return resultPress;
    }

    public static Press getPressNameById(Connection con, int pressId) throws Exception{
        Press resultPress = new Press();
        String sql = "select * from t_press where pressId=?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, pressId);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()){
            resultPress.setPressName(rs.getString("pressName"));
        }
        return resultPress;
    }


    public static ResultSet pressList(Connection con, Press press) throws SQLException{
        StringBuilder sb = new StringBuilder("select * from t_press");
        if(StringUtils.isNotEmpty(press.getPressName())){
            sb.append(" and pressName like '%").append(press.getPressName()).append("%'");
        }
        PreparedStatement psmt = con.prepareStatement(sb.toString().replaceFirst("and","where"));
        return psmt.executeQuery();
    }

    public static int pressDelete(Connection con,Press press) throws SQLException {
        String sql = "delete from t_press where pressName = ?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1,press.getPressName());
        return pstmt.executeUpdate();
    }

}
