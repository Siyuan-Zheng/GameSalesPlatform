package com.shigure.controller;

import com.jfoenix.controls.JFXButton;
import com.shigure.util.ImageUtils;
import com.shigure.util.StageUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class LibrarySliderBarController {

    @FXML
    private JFXButton butt_cast;

    @FXML
    private JFXButton butt_game;

    @FXML
    private JFXButton butt_calendar;

    @FXML
    private JFXButton butt_star;

    @FXML
    private ImageView img_cast;

    @FXML
    private ImageView img_calendar;

    @FXML
    private ImageView img_star;

    @FXML
    private ImageView img_game;


    @FXML
    void click_game(ActionEvent event) {
        StageUtils.newStage("游戏","/com/shigure/view/GameList.fxml");
    }

    @FXML
    void gameEnter(MouseEvent event) {
        ImageUtils.setImg(img_game,"/com/shigure/material/game_dark.png");
    }

    @FXML
    void gameExit(MouseEvent event) {
        ImageUtils.setImg(img_game,"/com/shigure/material/game.png");
    }

    @FXML
    void click_calendar(ActionEvent event) {

    }

    @FXML
    void calendarEnter(MouseEvent event) {
        ImageUtils.setImg(img_calendar,"/com/shigure/material/calendar_dark.png");
    }

    @FXML
    void calendarExit(MouseEvent event) {
        ImageUtils.setImg(img_calendar,"/com/shigure/material/calendar.png");
    }

    @FXML
    void click_star(ActionEvent event) {
        StageUtils.newStage("收藏夹","/com/shigure/view/CollectionList.fxml");
    }

    @FXML
    void starEnter(MouseEvent event) {
        ImageUtils.setImg(img_star,"/com/shigure/material/star_dark.png");
    }

    @FXML
    void starExit(MouseEvent event) {
        ImageUtils.setImg(img_star,"/com/shigure/material/star.png");
    }

    @FXML
    void click_cast(ActionEvent event) {

    }

    @FXML
    void castEnter(MouseEvent event) {
        ImageUtils.setImg(img_cast,"/com/shigure/material/cart_dark.png");
    }

    @FXML
    void castExit(MouseEvent event) {
        ImageUtils.setImg(img_cast,"/com/shigure/material/cart.png");
    }
}
