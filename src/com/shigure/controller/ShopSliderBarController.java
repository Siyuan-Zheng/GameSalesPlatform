package com.shigure.controller;

import com.jfoenix.controls.JFXButton;
import com.shigure.util.ImageUtils;
import com.shigure.util.StageUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ShopSliderBarController {

    @FXML
    private ImageView img_lookup;

    @FXML
    private ImageView img_wishList;

    @FXML
    private JFXButton butt_anliz;

    @FXML
    private JFXButton butt_best;

    @FXML
    private JFXButton butt_wishList;

    @FXML
    private ImageView img_best;

    @FXML
    private ImageView img_anliz;

    @FXML
    private JFXButton butt_lockup;


    @FXML
    void click_bestButton(ActionEvent event) {

    }

    @FXML
    void click_lookUpButton(ActionEvent event) {
        StageUtils.newStage("浏览","/com/shigure/view/GameBrowse.fxml");
    }

    @FXML
    void click_wishListButton(ActionEvent event) {
        StageUtils.newStage("愿望单","/com/shigure/view/WishList.fxml");
    }

    @FXML
    void click_anlizButton(ActionEvent event) {

    }

    @FXML
    void bestEnter(MouseEvent event) {
        ImageUtils.setImg(img_best,"/com/shigure/material/great_dark.png");
    }

    @FXML
    void bestExit(MouseEvent event) {
        ImageUtils.setImg(img_best,"/com/shigure/material/great.png");
    }

    @FXML
    void lookUpEnter(MouseEvent event) {
        ImageUtils.setImg(img_lookup,"/com/shigure/material/shop_dark.png");

    }

    @FXML
    void lookUpExit(MouseEvent event) {
        ImageUtils.setImg(img_lookup,"/com/shigure/material/shop.png");

    }

    @FXML
    void wishListEnter(MouseEvent event) {
        ImageUtils.setImg(img_wishList,"/com/shigure/material/wish_dark.png");

    }

    @FXML
    void wishListExit(MouseEvent event) {
        ImageUtils.setImg(img_wishList,"/com/shigure/material/love.png");

    }


    @FXML
    void anlizEnter(MouseEvent event) {
        ImageUtils.setImg(img_anliz,"/com/shigure/material/anliz_dark.png");

    }

    @FXML
    void anlizExit(MouseEvent event) {
        ImageUtils.setImg(img_anliz,"/com/shigure/material/anlis.png");

    }
}
