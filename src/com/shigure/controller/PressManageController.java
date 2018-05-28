package com.shigure.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.shigure.dao.PressDao;
import com.shigure.model.Press;
import com.shigure.util.FieldUtils;
import com.shigure.util.StringUtils;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import static com.shigure.util.DbUtils.free;
import static com.shigure.util.DbUtils.getConnection;

public class PressManageController implements Initializable {

    private String originalPressName = "";

    @FXML
    private JFXTextField change_pressField;

    @FXML
    private JFXButton change_deleteButton;

    @FXML
    private JFXListView<String> change_listView;

    @FXML
    private JFXButton add_button;

    @FXML
    private JFXTextField add_pressField;

    @FXML
    private JFXTextArea add_pressDescArea;

    @FXML
    private JFXTextArea change_pressDescArea;

    @FXML
    private JFXButton change_button;

    @FXML
    void click_addButton(ActionEvent event) {

        String pressName = add_pressField.getText();
        String pressDesc = add_pressDescArea.getText();
        if(StringUtils.isEmpty(pressName) && StringUtils.isEmpty(pressDesc)){
//            JOptionPane.showMessageDialog(null,"图书类别不能为空");
            return;
        }
        Press press = new Press(pressName,pressDesc);
        Connection con;
        try {
            con = getConnection();
            int n = PressDao.pressAdd(con,press);
            if(n==1){
//                JOptionPane.showMessageDialog(null,"图书类别添加成功");
                add_pressField.setText("");
                add_pressDescArea.setText("");
            }
            else {
//                JOptionPane.showMessageDialog(null,"图书类别添加失败");
            }

        } catch (Exception e1) {
            e1.printStackTrace();
//            JOptionPane.showMessageDialog(null,"图书类别添加失败");

        }
    }

    @FXML
    void click_changeButton(ActionEvent event) {
        String pressName = change_pressField.getText();
        String pressDesc = change_pressDescArea.getText();
        if(StringUtils.isEmpty(pressName) || StringUtils.isEmpty(pressDesc)){
//            JOptionPane.showMessageDialog(null,"图书类别不能为空");
            return;
        }
        Press press = new Press(pressName,pressDesc);
        Connection con = null;
        try {
            con= getConnection();
            int updateNum = PressDao.pressUpdate(con,press,originalPressName);
            if(updateNum == 1){
//                JOptionPane.showMessageDialog(null,"修改成功");
                change_pressField.setText("");
                change_pressDescArea.setText("");
                fillList(new Press());
            }else {
//                JOptionPane.showMessageDialog(null, "修改失败");
            }

        } catch (Exception e1) {
            e1.printStackTrace();
//            JOptionPane.showMessageDialog(null,"修改失败");
        }finally {
            free(con);
        }
    }

    @FXML
    void click_deleteButton(ActionEvent event) {
        String pressName = change_pressField.getText();
        if(StringUtils.isEmpty(pressName)){
//            JOptionPane.showMessageDialog(null,"图书类别不能为空");
            return;
        }

//        int n = JOptionPane.showConfirmDialog(null,"确定要删除这条记录吗");
//        if(n==0){
        Connection con = null;
        Press press = new Press(pressName);
        try {
            con= getConnection();
//                boolean flag = bookDao.getBookByBookTypeId(con,id);
//                if(flag){
//                    JOptionPane.showMessageDialog(null,"当前图书类别下仍有图书，不能删除该类别");
//                    return;
//                }
            int deleteNum = PressDao.pressDelete(con,press);
            if(deleteNum == 1){
//                    JOptionPane.showMessageDialog(null,"删除成功");
//                    this.resetValue();
                fillList(new Press());
            }else {
//                    JOptionPane.showMessageDialog(null, "删除失败");
            }

        } catch (Exception e1) {
            e1.printStackTrace();
//                JOptionPane.showMessageDialog(null,"删除失败");
        }finally {
            free(con);
        }
    }

    private void fillList(Press press){

        ObservableList<String> list = FXCollections.observableArrayList();

        Connection con = null;
        try {
            con = getConnection();
            ResultSet rs = PressDao.pressList(con,press);
            while(rs.next()){


                list.add(rs.getString("pressName"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            free(con);
        }

        change_listView.setItems(list);

        change_listView.setExpanded(true);

        change_listView.getSelectionModel().selectedItemProperty().addListener(
                (ObservableValue<? extends String> ov, String old_val,
                 String new_val) -> {
                    change_pressField.setText(new_val);
                    originalPressName = new_val;

                    Connection con1 = null;
                    try {
                        Press press1 = new Press(originalPressName);
                        con1 = getConnection();
                        Press rs = PressDao.getPressDescAndIdByName(con1,press1);
                        change_pressDescArea.setText(rs.getPressDesc());

                    } catch (Exception e) {
                        e.printStackTrace();
                    }finally {
                        free(con1);
                    }
                });
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        fillList(new  Press());
        FieldUtils.checkEmpty(add_pressDescArea);
        FieldUtils.checkEmpty(add_pressField);
        FieldUtils.checkEmpty(change_pressDescArea);
        FieldUtils.checkEmpty(change_pressField);
    }
}
