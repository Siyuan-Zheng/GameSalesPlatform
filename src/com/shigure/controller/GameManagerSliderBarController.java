package com.shigure.controller;

import com.jfoenix.controls.JFXButton;
import com.shigure.util.ImageUtils;
import com.shigure.util.StageUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class GameManagerSliderBarController {

    @FXML
    private JFXButton butt_game;

    @FXML
    private ImageView img_gameType;

    @FXML
    private JFXButton butt_gamePress;

    @FXML
    private ImageView img_gameManager;

    @FXML
    private JFXButton butt_gameType;

    @FXML
    private ImageView img_gamePress;

    @FXML
    void gameManagerEnter(MouseEvent event) {
        ImageUtils.setImg(img_gameManager,"/com/shigure/material/setting_dark.png");
    }

    @FXML
    void gameManagerExit(MouseEvent event) {
        ImageUtils.setImg(img_gameManager,"/com/shigure/material/setting.png");

    }

    @FXML
    void gameTypeManagerEnter(MouseEvent event) {
        ImageUtils.setImg(img_gameType,"/com/shigure/material/setting_dark.png");

    }

    @FXML
    void gameTypeManagerExit(MouseEvent event) {
        ImageUtils.setImg(img_gameType,"/com/shigure/material/setting.png");

    }

    @FXML
    void gamePressManagerEnter(MouseEvent event) {
        ImageUtils.setImg(img_gamePress,"/com/shigure/material/setting_dark.png");

    }

    @FXML
    void gamePressManagerExit(MouseEvent event) {
        ImageUtils.setImg(img_gamePress,"/com/shigure/material/setting.png");

    }

    @FXML
    void clickGamePress(ActionEvent event) {
        StageUtils.newStage("游戏类型管理","/com/shigure/view/PressManage.fxml");
    }

    @FXML
    void clickGameType(ActionEvent event) {
        StageUtils.newStage("游戏类型管理","/com/shigure/view/GameTypeManage.fxml");
    }

    @FXML
    void clickGame(ActionEvent event) {
        StageUtils.newStage("游戏管理","/com/shigure/view/GameManage.fxml");
    }
}
