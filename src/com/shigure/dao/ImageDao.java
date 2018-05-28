package com.shigure.dao;

import com.shigure.model.Image;
import com.shigure.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ImageDao {

    public static int addImage(Connection con, Image image) throws Exception {
        String sql = "INSERT INTO t_image VALUES(NULL,?)";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, image.getImagePath());
        return pstmt.executeUpdate();
    }

    public static Image getImageId(Connection con, Image image) throws Exception{
        ResultSet rs;
        String sql = "select * from t_image where imagePath=?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, image.getImagePath());
        rs = pstmt.executeQuery();
        while (rs.next()){
            image = new Image();
            image.setImageId(rs.getInt("imageId"));
        }
        return image;
    }

    public static Image getPressNameById(Connection con, int imageId) throws Exception{
        Image resultImage = new Image();
        String sql = "select * from t_image where imageId=?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, imageId);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()){
            resultImage.setImagePath(rs.getString("imagePath"));
        }
        return resultImage;
    }

}
