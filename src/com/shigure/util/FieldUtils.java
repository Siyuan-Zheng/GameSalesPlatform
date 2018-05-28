package com.shigure.util;

import com.jfoenix.controls.*;
import com.jfoenix.validation.RequiredFieldValidator;
import de.jensd.fx.glyphs.GlyphsBuilder;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.ImageView;

public class FieldUtils {

    public static void checkEmpty(JFXPasswordField...jfxPasswordFields){
        for (JFXPasswordField jfxPasswordField:jfxPasswordFields) {
            RequiredFieldValidator validator = new RequiredFieldValidator();
            validator.setMessage("不能为空");
            validator.setIcon(GlyphsBuilder.create(FontAwesomeIconView.class)
                    .glyph(FontAwesomeIcon.WARNING)
                    .size("1em")
                    .styleClass("error")
                    .build());
            jfxPasswordField.getValidators().add(validator);
            jfxPasswordField.focusedProperty().addListener((o, oldVal, newVal) -> {
                if (!newVal) {
                    jfxPasswordField.validate();
                }
            });
        }
    }

    public static void checkEmpty(JFXTextField...jfxTextFields){
        for (JFXTextField jfxTextField:jfxTextFields) {
            RequiredFieldValidator validator = new RequiredFieldValidator();
            validator.setMessage("不能为空");
            validator.setIcon(GlyphsBuilder.create(FontAwesomeIconView.class)
                    .glyph(FontAwesomeIcon.WARNING)
                    .size("1em")
                    .styleClass("error")
                    .build());
            jfxTextField.getValidators().add(validator);
            jfxTextField.focusedProperty().addListener((o, oldVal, newVal) -> {
                if (!newVal) {
                    jfxTextField.validate();
                }
            });
        }
    }

    public static void checkEmpty(JFXTextArea...JFXTextAreas){
        for (JFXTextArea JFXTextArea:JFXTextAreas) {
            RequiredFieldValidator validator = new RequiredFieldValidator();
            validator.setMessage("不能为空");
            validator.setIcon(GlyphsBuilder.create(FontAwesomeIconView.class)
                    .glyph(FontAwesomeIcon.WARNING)
                    .size("1em")
                    .styleClass("error")
                    .build());
            JFXTextArea.getValidators().add(validator);
            JFXTextArea.focusedProperty().addListener((o, oldVal, newVal) -> {
                if (!newVal) {
                    JFXTextArea.validate();
                }
            });
        }
    }

    public static void imageRed(ImageView...imageViews){
        for (ImageView imageView: imageViews) {
            imageView.setBlendMode(BlendMode.RED);
        }
    }

    public static void imageNormal(ImageView...imageViews){
        for (ImageView imgeView: imageViews) {
            imgeView.setBlendMode(BlendMode.SRC_OVER);
        }
    }

    public static void loginFailed(JFXTextField jfxTextField){
        jfxTextField.setPromptText("用户名或密码错误");
        jfxTextField.getStyleClass().add("wrong-passport");
    }

    public static void loginFailed(JFXPasswordField jfxPasswordField){
        jfxPasswordField.setPromptText("用户名或密码错误");
        jfxPasswordField.getStyleClass().add("wrong-passport");
    }
}
