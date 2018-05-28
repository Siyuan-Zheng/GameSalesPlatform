package com.shigure.controller;

import com.jfoenix.controls.*;
import com.shigure.dao.ManagerDao;
import com.shigure.dao.UserDao;
import com.shigure.util.FieldUtils;
import com.shigure.model.Manager;
import com.shigure.model.User;
import com.shigure.util.MD5Utils;
import com.shigure.util.StageUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.util.ResourceBundle;

import static com.shigure.util.DbUtils.free;
import static com.shigure.util.DbUtils.getConnection;



public class LoginController implements Initializable {

    public static int uId;

    private UserDao userDao = new UserDao();
    private ManagerDao managerDao = new ManagerDao();

    @FXML
    private ImageView img_user;

    @FXML
    private ImageView img_lock;

    @FXML
    private JFXTextField field_userName;

    @FXML
    private StackPane stackPane;

    @FXML
    private JFXButton butt_login;

    @FXML
    private JFXPasswordField field_password;

    @FXML
    private JFXButton butt_register;

    @FXML
    private JFXToggleButton check_manager;

    @FXML
    private ImageView img_password;

    @FXML
    Pane pane;

    @FXML
    void click_login(ActionEvent event) {

        if(!field_password.getText().isEmpty() && !field_userName.getText().isEmpty()) {

            if (check_manager.isSelected()) {

                String managerName = field_userName.getText();
                String managerPassword = field_password.getText();

                Manager manager = new Manager(managerName, managerPassword);

                Connection con = null;
                try {
                    con = getConnection();
                    Manager currentUser = managerDao.login(con, manager);      //进行登陆

                    System.out.println(currentUser);

                    if (currentUser != null) {
                        ((Stage) field_userName.getScene().getWindow()).close();
                        StageUtils.newStage("Manager", "/com/shigure/view/ManagerDashBoard.fxml");
                    } else {
                        FieldUtils.loginFailed(field_userName);
                        FieldUtils.loginFailed(field_password);
                        FieldUtils.imageRed(img_lock, img_password, img_user);
                    }
                } catch (Exception e) {
                    e.printStackTrace();

                } finally {
                    free(con);
                }


            } else {
                String userName = field_userName.getText();
                String password = field_password.getText();

                User user = null;
                try {
                    user = new User(userName, MD5Utils.encoderByMd5(password));
                } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
                    e.printStackTrace();
                }

                Connection con = null;
                try {
                    con = getConnection();
                    User currentUser = userDao.login(con, user);      //进行登陆
                    uId = UserDao.getUser(con, user).getUserId();
                    System.out.println(uId);

                    if (currentUser != null) {
                        ((Stage) field_userName.getScene().getWindow()).close();
                        StageUtils.newStage("GameSales", "/com/shigure/view/UserDashBoard.fxml");
                    } else {
                        FieldUtils.loginFailed(field_userName);
                        FieldUtils.loginFailed(field_password);
                        FieldUtils.imageRed(img_lock, img_password, img_user);
                    }
                } catch (Exception e) {
                    e.printStackTrace();

                } finally {
                    free(con);
                }
            }
        }
    }

    @FXML
    void click_register(ActionEvent event) {
        StageUtils.newStage("Register","/com/shigure/view/Register.fxml");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        FieldUtils.checkEmpty(field_password);
        FieldUtils.checkEmpty(field_userName);

    }
}

