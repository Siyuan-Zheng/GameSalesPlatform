package com.shigure.controller;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXTabPane;
import com.shigure.util.StageUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import java.net.URL;
import java.util.ResourceBundle;

public class UserDashBoardController implements Initializable {

    @FXML
    private JFXDrawer userName_drawer;

    @FXML
    private Tab tab_userName;

    @FXML
    private Menu menu_view;

    @FXML
    private StackPane rootPane;

    @FXML
    private JFXHamburger library_hamburger;

    @FXML
    private Menu menu_friends;

    @FXML
    private Menu menu_game;

    @FXML
    private Menu menu_about;

    @FXML
    private Tab tab_library;

    @FXML
    private Tab tab_shop;

    @FXML
    private JFXDrawer shop_drawer;

    @FXML
    private MenuBar menuBar;

    @FXML
    private Menu menu_system;

    @FXML
    private JFXHamburger shop_hamburger;

    @FXML
    private JFXDrawer library_drawer;

    @FXML
    private JFXHamburger userName_hamburger;

    @FXML
    private MenuItem close;

    @FXML
    private JFXTabPane tabPane;

    @FXML
    private Button butt;

    @FXML
    void buttpush(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initShopDrawer();

        initLibraryDrawer();

        initUserNameDrawer();
    }


    private void initUserNameDrawer() {
        StageUtils.initDrawer(userName_drawer,userName_hamburger,"/com/shigure/view/UserNameSliderBar.fxml");
    }

    private void initLibraryDrawer() {
        StageUtils.initDrawer(library_drawer,library_hamburger,"/com/shigure/view/LibrarySliderBar.fxml");
    }

    private void initShopDrawer() {
        StageUtils.initDrawer(shop_drawer,shop_hamburger,"/com/shigure/view/ShopSliderBar.fxml");
    }
}
