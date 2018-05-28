package com.shigure.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import com.shigure.util.FieldUtils;
import com.shigure.dao.GameTypeDao;
import com.shigure.model.GameType;
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

public class GameTypeManageController implements Initializable {

    private String originalGameTypeName = "";

    @FXML
    private JFXListView<String> change_listView;

    @FXML
    private JFXButton add_button;

    @FXML
    private JFXTextField change_gameTypeField;

    @FXML
    private JFXTextField add_gameTypeField;

    @FXML
    private JFXButton change_button;

    @FXML
    private JFXButton change_deleteButton;

    @FXML
    void click_deleteButton(ActionEvent event){

        String gameTypeName = change_gameTypeField.getText();
        if(StringUtils.isEmpty(gameTypeName)){
//            JOptionPane.showMessageDialog(null,"图书类别不能为空");
            return;
        }

//        int n = JOptionPane.showConfirmDialog(null,"确定要删除这条记录吗");
//        if(n==0){
            Connection con = null;
            GameType gameType = new GameType(gameTypeName);
            try {
                con= getConnection();
//                boolean flag = bookDao.getBookByBookTypeId(con,id);
//                if(flag){
//                    JOptionPane.showMessageDialog(null,"当前图书类别下仍有图书，不能删除该类别");
//                    return;
//                }
                int deleteNum = GameTypeDao.gameTypeDelete(con,gameType);
                if(deleteNum == 1){
//                    JOptionPane.showMessageDialog(null,"删除成功");
//                    this.resetValue();
                    fillList(new GameType());
                }else {
//                    JOptionPane.showMessageDialog(null, "删除失败");
                }

            } catch (Exception e1) {
                e1.printStackTrace();
//                JOptionPane.showMessageDialog(null,"删除失败");
            }finally {
                free(con);
            }
//        }

    }

    @FXML
    void click_addButton(ActionEvent event) {

        String gameTypeName = add_gameTypeField.getText();
        if(StringUtils.isEmpty(gameTypeName)){
//            JOptionPane.showMessageDialog(null,"图书类别不能为空");
            return;
        }
        GameType gameType = new GameType(gameTypeName);
        Connection con;
        try {
            con = getConnection();
            int n = GameTypeDao.gameTypeAdd(con,gameType);
            if(n==1){
//                JOptionPane.showMessageDialog(null,"图书类别添加成功");
                add_gameTypeField.setText("");
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

        String gameTypeName = change_gameTypeField.getText();
        if(StringUtils.isEmpty(gameTypeName)){
//            JOptionPane.showMessageDialog(null,"图书类别不能为空");
            return;
        }
        GameType gameType = new GameType(gameTypeName);
        Connection con = null;
        try {
            con= getConnection();
            int updateNum = GameTypeDao.gameTypeUpdate(con,gameType,originalGameTypeName);
            if(updateNum == 1){
//                JOptionPane.showMessageDialog(null,"修改成功");
                change_gameTypeField.setText("");
                fillList(new GameType());
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

    private void fillList(GameType gameType){

        ObservableList<String> list = FXCollections.observableArrayList();

        Connection con = null;
        try {
            con = getConnection();
            ResultSet rs = GameTypeDao.gameTypeList(con,gameType);
            while(rs.next()){

                list.add(rs.getString("gameTypeName"));

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
                    change_gameTypeField.setText(new_val);
                    originalGameTypeName = new_val;
                });
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        fillList(new GameType());

        FieldUtils.checkEmpty(add_gameTypeField);
        FieldUtils.checkEmpty(change_gameTypeField);
    }
}
