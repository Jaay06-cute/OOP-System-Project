
package com.mycompany.Library_Management_Maven.ViewController;

import IViews.IFavoritesView;
import Presenter.FavoritePresenter;
import Presenter.HistoryViewPresenter;
import Presenter.ReservationPresenter;
import java.time.LocalDate;
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
    
    private AnchorPane container;

     
    private ReservationPresenter presenter;
    private FavoritePresenter FavPresenter;
    private HistoryViewPresenter HistoryPresenter;
    
    
    public void initialize(){
        this.presenter= new ReservationPresenter();
        this.FavPresenter = new FavoritePresenter(this);
        this.HistoryPresenter = new HistoryViewPresenter();
        
    }
    
    public void FavoriteContainer( String Label){
        SetTitlePage(Label);
        FavoriteData();
    }
    
    public void loadHistoryData(String Title){
        SetTitlePage(Title);
        HistoryPresenter.DisplayData(ReservationPanelContainer);
        
    }

    public void loadData(String label){
        SetTitlePage(label);
        presenter.DisplayData(ReservationPanelContainer);
    }
    
    
    private void FavoriteData(){
        FavPresenter.ShowFavoriteBook(ReservationPanelContainer);
    }
    
    

    @Override
    public void SetTitlePage(String TitleName) {
        ReservationLabel.setText(TitleName);
    }

    

}
