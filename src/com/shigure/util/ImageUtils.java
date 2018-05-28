package com.shigure.util;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.net.MalformedURLException;

public class ImageUtils {


    //setImg方法，调用资源管理器选择图片，并将选择的图片路径调用setImage方法设置img并返回图片路径
    public static String setImg(ImageView imageView){
        String localUrl = null;
        String path = null;
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("选择图片");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("image", "*.jpg","*.gif","*.png")
        );
        File file = fileChooser.showOpenDialog(new Stage());
        if(file != null) {
            try {
                localUrl = file.toURI().toURL().toString();
                path = file.getPath();
            } catch (MalformedURLException e) {
                imageView.setImage(new javafx.scene.image.Image("com/shigure/material/wrong.png"));
            }
            assert localUrl != null;
            imageView.setImage(new javafx.scene.image.Image(localUrl));
        }
        return path;
    }

    //setImg方法,提供路径调用setImage方法设置img
    public static void setImg(ImageView imageView, String path){
        imageView.setImage(new Image(path));
    }

    //imageType方法,提供图片路径判断图片后缀名并返回
    public static String imageType(String localPath){
        String fileType = "";
        if(localPath.toLowerCase().endsWith("jpg")){
            fileType = ".jpg";
        }else if(localPath.toLowerCase().endsWith("png")){
            fileType = ".png";
        }else if(localPath.toLowerCase().endsWith("gif")){
            fileType = ".gif";
        }
        return fileType;
    }

}
