package com.shigure.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.shigure.util.FieldUtils;
import com.shigure.dao.ImageDao;
import com.shigure.dao.UserDao;
import com.shigure.model.Image;
import com.shigure.model.User;
import com.shigure.util.FtpUtils;
import com.shigure.util.ImageUtils;
import com.shigure.util.MD5Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import sun.net.ftp.FtpClient;

import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;

import static com.shigure.util.DbUtils.free;
import static com.shigure.util.DbUtils.getConnection;

public class RegisterController implements Initializable {
    private String localPath;
    private String fileType = null;

    @FXML
    private ImageView img_mail;

    @FXML
    private JFXTextField field_mail;

    @FXML
    private ImageView img_add;

    @FXML
    private JFXTextField field_userName;

    @FXML
    private JFXTextField field_phoneNum;

    @FXML
    private JFXPasswordField field_password;

    @FXML
    private JFXPasswordField field_rePassword;

    @FXML
    private JFXButton butt_register;

    @FXML
    private ImageView img_conf;

    @FXML
    private ImageView img_user;

    @FXML
    private JFXButton butt_uploadImg;

    @FXML
    private JFXButton butt_reset;

    @FXML
    private ImageView img_lock;

    @FXML
    private ImageView img_upImg;

    @FXML
    private ImageView img_phone;

    @FXML
    private ImageView img_lookUp;

    @FXML
    void uploadImg(ActionEvent event) {
        localPath =  ImageUtils.setImg(img_lookUp);

        fileType = ImageUtils.imageType(localPath);
    }

    @FXML
    void register(ActionEvent event) {
        if (isEmpty() == 0) {
            String userName = field_userName.getText();
            String userPassword = field_password.getText();
            String userPhoneNum = field_phoneNum.getText();
            String userMail = field_mail.getText();

            Image image;
            if(localPath != null) {
                FtpClient ftpClient = FtpUtils.connectFTP("115.159.202.192", 21, "shigure", "zhengsiyuan4399");
                FtpUtils.upload(localPath, "userImg" + userName + fileType, ftpClient);
                image = new Image("/www/wwwroot/shigure/images/" + "userImg" + userName + fileType);
            }else {
                image = new Image("/www/wwwroot/shigure/images/noImage.png");
            }

            Connection con = null;
            try {
                con = getConnection();
                int n = ImageDao.addImage(con, image);
                int imageId = ImageDao.getImageId(con, image).getImageId();

                User user = new User(userName, MD5Utils.encoderByMd5(userPassword), userMail, userPhoneNum, imageId);
                int r = UserDao.userRegister(con, user);
                if (r == 1) {
                    ((Stage) field_userName.getScene().getWindow()).close();
                }else if(n == 1) {
                    FieldUtils.imageRed(img_upImg);
                }else {
                    FieldUtils.imageRed(img_conf,img_lock,img_mail,img_phone,img_user,img_add);
                    }
            } catch (Exception e1) {
                field_userName.setPromptText("用户名重复");
                field_userName.setBlendMode(BlendMode.RED);
                FieldUtils.imageRed(img_user);
                FieldUtils.imageRed(img_add);
            } finally {
                free(con);
            }
        }
    }

    @FXML
    void reset(ActionEvent event) {
        this.field_mail.setText("");
        this.field_password.setText("");
        this.field_phoneNum.setText("");
        this.field_rePassword.setText("");
        this.field_userName.setText("");
        this.img_lookUp.setImage(null);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        FieldUtils.checkEmpty(field_password,field_rePassword);
        FieldUtils.checkEmpty(field_mail,field_phoneNum,field_userName);
    }


    private int isEmpty(){

        FieldUtils.imageNormal(img_add,img_conf,img_lock,img_mail,img_phone,img_user);

        int e = 0;
        if(field_userName.getText().isEmpty()){
            FieldUtils.imageRed(img_user);
            FieldUtils.imageRed(img_add);
            e = 1;
        }
        if(field_password.getText().isEmpty()){
            FieldUtils.imageRed(img_lock);
            FieldUtils.imageRed(img_add);
            e = 1;
        }
        if (field_rePassword.getText().isEmpty()){
            FieldUtils.imageRed(img_conf);
            FieldUtils.imageRed(img_add);
            e = 1;
        }
        if(field_phoneNum.getText().isEmpty()){
            FieldUtils.imageRed(img_phone);
            FieldUtils.imageRed(img_add);
            e = 1;
        }
        if(field_mail.getText().isEmpty()){
            FieldUtils.imageRed(img_mail);
            FieldUtils.imageRed(img_add);
            e = 1;
        }if(!field_rePassword.getText().equals(field_password.getText())){
            field_rePassword.getStyleClass().add("wrong-passport");
            field_rePassword.setPromptText("密码输入不一致");
            FieldUtils.imageRed(img_conf);
            FieldUtils.imageRed(img_add);

            field_password.getStyleClass().add("wrong-passport");
            field_password.setPromptText("密码输入不一致");
            FieldUtils.imageRed(img_lock);
            FieldUtils.imageRed(img_add);
            e = 1;
        }
        return e;
    }
}
