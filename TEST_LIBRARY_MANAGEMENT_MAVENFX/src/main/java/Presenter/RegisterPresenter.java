
package Presenter;

import IViews.IRegisterViews;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class RegisterPresenter {
    private IRegisterViews _views;
    
    public RegisterPresenter(IRegisterViews views){
        this._views = views;
    }
    
    public void GotoLogin(BorderPane borderpane, AnchorPane anchorPane){
        try {
            borderpane.setRight(anchorPane);
        } catch (Exception e) {
            e.printStackTrace();
        }
    
    }
}
    