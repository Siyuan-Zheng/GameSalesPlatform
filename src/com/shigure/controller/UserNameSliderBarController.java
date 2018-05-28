package com.shigure.controller;

import com.jfoenix.controls.JFXButton;
import com.shigure.util.ImageUtils;
import com.shigure.util.StageUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class UserNameSliderBarController {
    @FXML
    private ImageView img_user;

    @FXML
    private JFXButton butt_friends;

    @FXML
    private JFXButton butt_user;

    @FXML
    private ImageView img_logout;

    @FXML
    private JFXButton butt_logout;

    @FXML
    private ImageView img_orderList;

    @FXML
    private ImageView img_friends;

    @FXML
    private JFXButton butt_orderList;

    @FXML
    void click_user(ActionEvent event) {
        StageUtils.newStage("个人信息管理","/com/shigure/view/UserSelfManage.fxml");
    }

    @FXML
    void userEnter(MouseEvent event) {
        ImageUtils.setImg(img_user,"/com/shigure/material/user_dark.png");
    }

    @FXML
    void userExit(MouseEvent event) {
        ImageUtils.setImg(img_user,"/com/shigure/material/user.png");
    }

    @FXML
    void click_friends(ActionEvent event) {
        StageUtils.newStage("好友","/com/shigure/view/FriendsList.fxml");

    }

    @FXML
    void friendsEnter(MouseEvent event) {
        ImageUtils.setImg(img_friends,"/com/shigure/material/friends_dark.png");
    }

    @FXML
    void friendsUpExit(MouseEvent event) {
        ImageUtils.setImg(img_friends,"/com/shigure/material/friends.png");
    }

    @FXML
    void click_orderList(ActionEvent event) {

    }

    @FXML
    void orderListEnter(MouseEvent event) {
        ImageUtils.setImg(img_orderList,"/com/shigure/material/list_dark.png");
    }

    @FXML
    void orderListExit(MouseEvent event) {
        ImageUtils.setImg(img_orderList,"/com/shigure/material/list.png");
    }

    @FXML
    void click_logout(ActionEvent event) {
    }

    @FXML
    void logoutEnter(MouseEvent event) {
        ImageUtils.setImg(img_logout,"/com/shigure/material/logout_dark.png");
    }

    @FXML
    void logoutExit(MouseEvent event) {
        ImageUtils.setImg(img_logout,"/com/shigure/material/logout.png");
    }

}
