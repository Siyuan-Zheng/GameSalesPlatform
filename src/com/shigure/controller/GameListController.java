package com.shigure.controller;

import com.jfoenix.controls.*;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class GameListController implements Initializable {

    @FXML
    private JFXButton searchButton;

    @FXML
    private JFXTextField searchField;

    @FXML
    private Label titleLabel;

    @FXML
    private JFXButton startPlayButton;

    @FXML
    private JFXListView<String> gameList;

    @FXML
    private JFXTextArea gameTextArea;

    @FXML
    void click_searchButton(ActionEvent event) {
        fillList();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        listView();
    }

    private void listView() {
        ObservableList<String> list = FXCollections.observableArrayList("1","2","3");

        gameList.setItems(list);

        gameList.setExpanded(true);

        ImageView img =  new ImageView();


        gameList.getSelectionModel().selectedItemProperty().addListener(
                (ObservableValue<? extends String> ov, String old_val,
                 String new_val) -> {

                    img.setVisible(true);
                    img.setImage(new Image("/com/shigure/material/setting.png"));
                    img.setFitHeight(30);
                    img.setFitWidth(30);
                    img.setSmooth(true);

                    titleLabel.setGraphic(img);

                    startPlayButton.setVisible(true);

                    titleLabel.setText(new_val);

                    gameTextArea.setText(new_val);

                });
    }

    private void fillList(){
        ObservableList<String> list = FXCollections.observableArrayList("5","6","7");

        gameList.setItems(list);

        gameList.setExpanded(true);

        ImageView img =  new ImageView();


        gameList.getSelectionModel().selectedItemProperty().addListener(
                (ObservableValue<? extends String> ov, String old_val,
                 String new_val) -> {

                    img.setImage(new Image("/com/shigure/material/lock.png"));

                    img.setFitHeight(30);
                    img.setFitWidth(30);
                    img.setSmooth(true);

                    titleLabel.setGraphic(img);

                    startPlayButton.setVisible(true);

                    titleLabel.setText(new_val);

                    gameTextArea.setText(new_val);

                });
    }
}