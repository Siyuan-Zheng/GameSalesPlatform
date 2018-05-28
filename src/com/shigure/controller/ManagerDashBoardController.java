package com.shigure.controller;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.shigure.util.StageUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;

public class ManagerDashBoardController implements Initializable {

    @FXML
    private JFXHamburger gameManager_hamburger;

    @FXML
    private JFXHamburger userManager_hamburger;

    @FXML
    private JFXDrawer gameManager_drawer;

    @FXML
    private JFXDrawer userManager_drawer;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        initGameManagerDrawer();

        initUserManagerDrawer();

    }

    private void initGameManagerDrawer() {
        StageUtils.initDrawer(gameManager_drawer,gameManager_hamburger,"/com/shigure/view/GameManagerSliderBar.fxml");
    }

    private void initUserManagerDrawer() {
        StageUtils.initDrawer(userManager_drawer,userManager_hamburger,"/com/shigure/view/UserManagerSliderBar.fxml");
    }


}
