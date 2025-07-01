
package com.mycompany.Library_Management_Maven.ViewController;

import IViews.IUserProfileView;
import Presenter.SearchPresenter;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;




public class SearchController implements IUserProfileView {
    private SearchPresenter presenter ;
    private String searchBook;
    
    @FXML
    private VBox SearchContainer;
    private AnchorPane container;
    
  
    
    public void initialize(){
            this.presenter = new SearchPresenter();
           
    }
    
    public void getSearch(String searchBook){
        this.searchBook=searchBook;
    }
    public void setContainer(AnchorPane container){
        this.container = container;
         loadData();
    }
    
    private void loadData(){
        presenter.DisplayData(SearchContainer, container);
    }
  

    @Override
    public String SearchInput() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}
