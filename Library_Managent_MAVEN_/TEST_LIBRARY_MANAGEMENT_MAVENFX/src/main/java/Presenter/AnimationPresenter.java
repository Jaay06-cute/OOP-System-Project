/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Presenter;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

/**
 *
 * @author Jiver
 */
public class AnimationPresenter {
    
    public void Hover(HBox box, ImageView image , Label label){
        box.setStyle(" -fx-background-color:  #C9C9C9;");
        label.setStyle(" -fx-text-fill:  white;");
    }
    
    public void Default(HBox box, ImageView image , Label label){
        box.setStyle(" -fx-background-color:  transparent;");
        label.setStyle(" -fx-text-fill:  black;");

    }
    
}
