package com.shigure.util;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerSlideCloseTransition;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.IOException;

public class StageUtils {

    //newStage方法,提供标题和fxml文件path,创建一个新的窗口
    public static void newStage(String title, String path){
        Parent parent = null;
        try {
            parent = FXMLLoader.load(StageUtils.class.getResource(path));
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle(title);
            stage.setScene(new Scene(parent));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //初始化Drawer方法,代码参考JFoenix官方wiki
    public static void initDrawer(JFXDrawer drawer, JFXHamburger hamburger, String path) {
        try {
            VBox librarySliderBar = FXMLLoader.load(StageUtils.class.getResource(path));
            drawer.setSidePane(librarySliderBar);
        } catch (IOException e) {
            e.printStackTrace();
        }
        HamburgerSlideCloseTransition libraryTask = new HamburgerSlideCloseTransition(hamburger);
        libraryTask.setRate(-1);
        hamburger.addEventHandler(MouseEvent.MOUSE_CLICKED, (EventHandler<Event>) event -> {
            libraryTask.setRate(libraryTask.getRate() * -1);
            libraryTask.play();
            if (drawer.isClosed()) {
                drawer.open();
            } else {
                drawer.close();
            }
        });
    }
}
