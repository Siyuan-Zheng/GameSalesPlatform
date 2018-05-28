package com.shigure.controller;

import com.jfoenix.controls.*;
import com.shigure.dao.GameDao;
import com.shigure.dao.GameTypeDao;
import com.shigure.dao.ImageDao;
import com.shigure.dao.PressDao;
import com.shigure.model.Game;
import com.shigure.model.GameType;
import com.shigure.model.Image;
import com.shigure.model.Press;
import com.shigure.util.FieldUtils;
import com.shigure.util.FtpUtils;
import com.shigure.util.ImageUtils;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import sun.net.ftp.FtpClient;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;

import static com.shigure.util.DbUtils.free;
import static com.shigure.util.DbUtils.getConnection;

public class GameManageController implements Initializable {

    private String fileType;

    private String uploadLocalPath;

    private String ftpPath;

    private String originalGameName;

    @FXML
    private JFXTextField add_gamePrice;

    @FXML
    private JFXButton change_uploadImg;

    @FXML
    private JFXTextArea change_gameDesc;

    @FXML
    private JFXComboBox<String> change_gameType;

    @FXML
    private JFXTextField change_gamePrice;

    @FXML
    private JFXDatePicker add_datePicker;

    @FXML
    private JFXButton addButton;

    @FXML
    private JFXTextField add_gameNameField;

    @FXML
    private JFXComboBox<String> add_pressName;

    @FXML
    private ImageView change_imgView;

    @FXML
    private JFXComboBox<String> add_gameType;

    @FXML
    private JFXComboBox<String> change_pressName;

    @FXML
    private ImageView add_imgView;

    @FXML
    private JFXDatePicker change_datePicker;

    @FXML
    private JFXTextField change_gameName;

    @FXML
    private JFXTextField change_gameDiscountNum;

    @FXML
    private JFXTextArea add_gameDescTxt;

    @FXML
    private JFXButton add_uploadImg;

    @FXML
    private JFXButton gameChangeButton;

    @FXML
    private JFXListView<String> change_listView;

    @FXML
    void click_addUploadImgButton(ActionEvent event) {

        uploadLocalPath = ImageUtils.setImg(add_imgView);

        if(uploadLocalPath != null) {

            fileType = ImageUtils.imageType(uploadLocalPath);
        }
    }

    @FXML
    void click_addButton(ActionEvent event) {

        String gameName = add_gameNameField.getText();
        String gameDesc = add_gameDescTxt.getText();
        String gamePress = add_pressName.getValue();
        double gamePrice = Double.parseDouble(add_gamePrice.getText());
        String gameType = add_gameType.getValue();
        LocalDate date = add_datePicker.getValue();

        Image image;
        if (uploadLocalPath != null) {
            FtpClient ftpClient = FtpUtils.connectFTP("115.159.202.192", 21, "shigure", "zhengsiyuan4399");
            FtpUtils.upload(uploadLocalPath, "gameImg" + gameName + fileType, ftpClient);
            image = new Image("gameImg" + gameName + fileType);
        } else {
            image = new Image("noImage.png");
        }

        Connection con = null;
        try {
            con = getConnection();
            int n = ImageDao.addImage(con, image);
            int imageId = ImageDao.getImageId(con, image).getImageId();
            int pressId = PressDao.getPressDescAndIdByName(con, new Press(gamePress)).getPressId();
            int gameTypeId = GameTypeDao.getGameTypeIdByName(con, new GameType(gameType)).getGameTypeId();

            Game game = new Game(gameName, gameDesc, gameTypeId, gamePrice, 1, date.toString(), pressId, imageId);

            int r = GameDao.gameTypeAdd(con, game);
            if (r == 1) {
//                ((Stage) field_userName.getScene().getWindow()).close();
            } else if (n == 1) {
                FieldUtils.imageRed(add_imgView);
            } else {
//                FieldUtils.imageRed(,img_lock,img_mail,img_phone,img_user,img_add);
            }
        } catch (Exception e1) {
//            field_userName.setPromptText("用户名重复");
//            field_userName.setBlendMode(BlendMode.RED);
//            FieldUtils.imageRed(img_user);
//            FieldUtils.imageRed(img_add);
        } finally {
            free(con);
        }
    }


    @FXML
    void click_changeUploadImgButton(ActionEvent event) {
        uploadLocalPath = ImageUtils.setImg(change_imgView);

        if(uploadLocalPath != null) {

            fileType = ImageUtils.imageType(uploadLocalPath);
        }
    }

    @FXML
    void click_changeButton(ActionEvent event) {

    }


    private void fillList(Game game) {

        ObservableList<String> list = FXCollections.observableArrayList();

        Connection con = null;
        try {
            con = getConnection();
            ResultSet rs = GameDao.gameList(con, game);
            while (rs.next()) {

                list.add(rs.getString("gameName"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            free(con);
        }


        change_listView.setItems(list);

        change_listView.setExpanded(true);

        change_listView.getSelectionModel().selectedItemProperty().addListener(
                (ObservableValue<? extends String> ov, String old_val,
                 String new_val) -> {

                    originalGameName = new_val;


                    Connection con1 = null;
                    try {
                        Game press1 = new Game(originalGameName);
                        con1 = getConnection();
                        Game rs = GameDao.getGameByName(con1,press1);

                        change_datePicker.setValue(LocalDate.parse(rs.getGamePressTime()));
                        change_gameDesc.setText(rs.getGameDesc());
                        change_gameDiscountNum.setText(String.valueOf(rs.getGameDiscountNum()));
                        change_gameName.setText(rs.getGameName());
                        change_gamePrice.setText(String.valueOf(rs.getGamePrice()));
                        change_gameType.setValue(GameTypeDao.getGameTypeNameById(con1,rs.getGameTypeId()).getGameTypeName());
                        change_pressName.setValue(PressDao.getPressNameById(con1,rs.getPressId()).getPressName());

                        ftpPath = ImageDao.getPressNameById(con1,rs.getImageId()).getImagePath();

                        FtpClient ftpClient = FtpUtils.connectFTP("115.159.202.192", 21, "shigure", "zhengsiyuan4399");
                        FtpUtils.download(originalGameName+".png",ftpPath,ftpClient);
                        ftpClient.close();

                        change_imgView.setImage(new javafx.scene.image.Image("../../../../../"+originalGameName+".png"));


                    } catch (Exception e) {
                        e.printStackTrace();
                    }finally {
                        free(con1);
                    }
                });

    }

    private void fillComboBox(GameType gameType, Press press){
        ObservableList<String> gameTypeList = FXCollections.observableArrayList();

        ObservableList<String> pressList = FXCollections.observableArrayList();

        Connection con = null;
        try {
            con = getConnection();
            ResultSet resultGameType = GameTypeDao.gameTypeList(con,gameType);
            while(resultGameType.next()){

                gameTypeList.add(resultGameType.getString("gameTypeName"));

            }

            ResultSet resultPress = PressDao.pressList(con,press);

            while(resultPress.next()){

                pressList.add(resultPress.getString("pressName"));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            free(con);
        }

        change_gameType.setItems(gameTypeList);

        change_pressName.setItems(pressList);

        add_pressName.setItems(pressList);

        add_gameType.setItems(gameTypeList);

//        change_listView.getSelectionModel().selectedItemProperty().addListener(
//                (ObservableValue<? extends String> ov, String old_val,
//                 String new_val) -> {
//                    change_gameTypeField.setText(new_val);
//                    originalGameTypeName = new_val;
//                });
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        FieldUtils.checkEmpty(add_gameNameField);
        FieldUtils.checkEmpty(add_gameDescTxt);
        FieldUtils.checkEmpty(add_gamePrice);
        fillComboBox(new GameType(), new Press());

        fillList(new Game());
    }
}
