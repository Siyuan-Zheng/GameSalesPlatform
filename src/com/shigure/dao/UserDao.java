package com.shigure.dao;

import com.shigure.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDao {

    public User login(Connection con, User user) throws Exception {

        User resultUser = null;
        String sql = "SELECT * FROM t_user WHERE userName=? AND userPassword=?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, user.getUserName());
        pstmt.setString(2, user.getUserPassword());
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            resultUser = new User();
            resultUser.setUserName(rs.getString("userName"));
            resultUser.setUserPassword(rs.getString("userPassword"));
        }
        return resultUser;
    }


    public static User getUser(Connection con, User user) throws Exception{
        User resultUser = new User();
        String sql = "select * from t_user where userName=?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, user.getUserName());
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()){
            resultUser.setUserId(rs.getInt("userId"));
            resultUser.setUserName(rs.getString("userName"));
            resultUser.setUserPassword(rs.getString("userPassword"));
            resultUser.setUserMail(rs.getString("userMail"));
            resultUser.setUserPhoneNum(rs.getString("userPhoneNum"));
            resultUser.setImageId(rs.getInt("imageId"));
        }
        return resultUser;
    }


    public static int userRegister(Connection con, User user) throws Exception {
        String sql = "INSERT INTO t_user VALUES(NULL,?,?,?,?,?)";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, user.getUserName());
        pstmt.setString(2, user.getUserPassword());
        pstmt.setString(3, user.getUserMail());
        pstmt.setString(4, user.getUserPhoneNum());
        pstmt.setInt(5,user.getImageId());
        return pstmt.executeUpdate();
    }
}
