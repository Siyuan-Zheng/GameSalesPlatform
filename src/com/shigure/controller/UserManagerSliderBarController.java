package com.shigure.controller;

import com.jfoenix.controls.JFXButton;
import com.shigure.util.ImageUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class UserManagerSliderBarController {

    @FXML
    private JFXButton butt_orderListManager;

    @FXML
    private JFXButton butt_userManager;

    @FXML
    private ImageView img_orderListManager;

    @FXML
    private ImageView img_userManager;

    @FXML
    void click_userManager(ActionEvent event) {

    }

    @FXML
    void userManagerEnter(MouseEvent event) {
        ImageUtils.setImg(img_userManager,"/com/shigure/material/setting_dark.png");
    }

    @FXML
    void userManagerExit(MouseEvent event) {
        ImageUtils.setImg(img_userManager,"/com/shigure/material/setting.png");
    }

    @FXML
    void click_orderListManager(ActionEvent event) {

    }

    @FXML
    void orderListManagerEnter(MouseEvent event) {
        ImageUtils.setImg(img_orderListManager,"/com/shigure/material/setting_dark.png");
    }

    @FXML
    void orderListManagerExit(MouseEvent event) {
        ImageUtils.setImg(img_orderListManager,"/com/shigure/material/setting.png");
    }

}
