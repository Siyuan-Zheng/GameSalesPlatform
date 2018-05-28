package com.shigure.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.shigure.util.ImageUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class UserSelfManageController {

    @FXML
    private Button passwordChangeButton;

    @FXML
    private JFXTextField phoneNumField;

    @FXML
    private JFXButton upLoadImgButton;

    @FXML
    private JFXPasswordField rePasswordField;

    @FXML
    private JFXTextField mailField;

    @FXML
    private ImageView imgLookUp;

    @FXML
    private JFXPasswordField passwordField;

    @FXML
    private Button changeButton;

    @FXML
    void click_upLoadImgButton(ActionEvent event) {
        ImageUtils.setImg(imgLookUp);
    }

    @FXML
    void click_changeButton(ActionEvent event) {

    }

    @FXML
    void click_passwordChangeButton(ActionEvent event) {

    }

}
