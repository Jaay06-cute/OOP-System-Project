
package com.mycompany.Library_Management_Maven.ViewController;

import IViews.IFavoritesView;
import Presenter.FavoritePresenter;
import Presenter.ReservationPresenter;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;


public class ReservationController implements IFavoritesView{
    @FXML
    private AnchorPane ReservationContainer;
    @FXML
    private VBox ReservationPanelContainer;
    @FXML
    private Label ReservationLabel;
    
    private ReservationPresenter presenter;
    private FavoritePresenter FavPresenter;
    
    
    public void initialize(){
        this.presenter= new ReservationPresenter();
        this.FavPresenter = new FavoritePresenter(this);
        loadData();
    }

    private void loadData(){
        presenter.DisplayData(ReservationPanelContainer);
    }
    
    public void setFavoriteData(String Label){
        SetTitlePage(Label);
        FavoriteData();
    }
    
    private void FavoriteData(){
        FavPresenter.ShowFavoriteBook(ReservationPanelContainer);
    }
    
    

    @Override
    public void SetTitlePage(String TitleName) {
        ReservationLabel.setText(TitleName);
    }
    
}
