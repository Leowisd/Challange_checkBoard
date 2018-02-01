/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge_checkerboard;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 *
 * @author Yifu
 */
public class FXMLDocumentController implements Initializable, Startable
{
    @FXML
    private VBox vBoxParent;
    @FXML
    private MenuBar menuBar;
    @FXML
    private AnchorPane anchorPane;
    private checkerBoard board;
    private Boolean defaultColor;

    @FXML
    private void handleMenuAction(ActionEvent event)
    {
        int rows = 0;
        int columns = 0;

        if (event.getSource().equals(this.menuBar.getMenus().get(0).getItems().get(0)))
        { 
            rows = columns = 3;
        } 
        else if (event.getSource().equals(this.menuBar.getMenus().get(0).getItems().get(1)))
        { 
            rows = columns = 8;
        }
        else if (event.getSource().equals(this.menuBar.getMenus().get(0).getItems().get(2)))
        { 
            rows = columns = 10;
        } 
        else if (event.getSource().equals(this.menuBar.getMenus().get(0).getItems().get(3)))
        { 
            rows = columns = 16;
        } 
        
        if (this.defaultColor)
        {
            this.print(rows, columns, Color.RED, Color.BLACK);
        } 
        else
        {
            this.print(rows, columns, Color.SKYBLUE, Color.DARKBLUE);
        }
    } 

    @FXML
    private void handleColorAction(ActionEvent event)
    {
        if (event.getSource().equals(this.menuBar.getMenus().get(1).getItems().get(0)))
        { 
            if (!this.defaultColor)
            {
                this.defaultColor = true;
                this.print(this.board.getColumns(), this.board.getRows(), Color.RED, Color.BLACK);
            }
        }
        else if (event.getSource().equals(this.menuBar.getMenus().get(1).getItems().get(1)))
        { 
            if (this.defaultColor)
            {
                this.defaultColor = false;
                this.print(this.board.getColumns(), this.board.getRows(), Color.SKYBLUE, Color.DARKBLUE);
            } 
            this.defaultColor = false;
        }     
    } 
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        
    } 

    public void refresh()
    {
        if (this.defaultColor)
        {
            this.print(this.board.getRows(), this.board.getColumns(), Color.RED, Color.BLACK);
        } 
        else
        {
            this.print(this.board.getRows(), this.board.getColumns(), Color.SKYBLUE, Color.DARKBLUE);
        } 
        
        this.anchorPane.getChildren().clear();
        this.anchorPane.getChildren().addAll(this.board.build().getChildren());
    } 
     
    public void start()
    {
        this.defaultColor = true;  
        this.print(8, 8, Color.RED, Color.BLACK);   
        this.vBoxParent.widthProperty().addListener((x, y, z) ->
        {
            this.refresh();
        }); 
        this.vBoxParent.heightProperty().addListener((x, y, z) ->
        {
            this.refresh();
        });
    }
    
    public void print(int numRows, int numCols, Color lightColor, Color darkColor)
    {
        this.board = new checkerBoard(numRows, numCols, this.vBoxParent.getWidth(), this.vBoxParent.getHeight() - this.menuBar.getHeight(), lightColor, darkColor);
        
        this.anchorPane.getChildren().clear();
        this.anchorPane.getChildren().addAll(this.board.build().getChildren());
    } 
} 
