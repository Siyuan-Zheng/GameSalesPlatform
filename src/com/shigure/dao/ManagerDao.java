package com.shigure.dao;

import com.shigure.model.Manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ManagerDao {

    public Manager login(Connection con, Manager manager) throws Exception {

        Manager resultManager = null;
        String sql = "SELECT * FROM t_manager WHERE managerName=? AND managerPassword=?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, manager.getManagerName());
        pstmt.setString(2, manager.getManagerPassword());
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            resultManager = new Manager();
            resultManager.setManagerName(rs.getString("managerName"));
            resultManager.setManagerPassword(rs.getString("managerPassword"));
        }
        return resultManager;
    }

}
