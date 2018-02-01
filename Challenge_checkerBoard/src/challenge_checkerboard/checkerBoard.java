/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge_checkerboard;


import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Yifu
 */
public class checkerBoard 
{
    private int rows;
    private int columns;
    private double width;
    private double height;
    private Color color1;
    private Color color2;
    private AnchorPane pane;

    public checkerBoard(int rows, int columns, double width, double height)
    {
        this.rows = rows;
        this.columns = columns;
        this.width = width;
        this.height = height;
        this.color1 = Color.BLACK;
        this.color2 = Color.RED;    
        this.pane = new AnchorPane();
    } 
    public checkerBoard(int rows, int columns, double width, double height, Color color2, Color color1)
    {
        this(rows, columns, width, height);    
        this.color2 = color2;
        this.color1 = color1;
    } 
    
    public AnchorPane build()
    {
        Rectangle rect = null;
        this.pane.getChildren().clear();       
      
        for (int i = 0; i < this.rows; i++)
        {
            for (int j = 0; j < this.columns; j++)
            {
                if (i % 2 == 0)
                { 
                    if (j % 2 == 0)
                    { 
                        rect = new Rectangle(i * this.getRectangleWidth(), j * this.getRectangleHeight(), this.getRectangleWidth(), this.getRectangleHeight());
                        rect.setFill(this.getColor2());
                        this.pane.getChildren().add(rect);
                    } 
                    else
                    { 
                        rect = new Rectangle(i * this.getRectangleWidth(), j * this.getRectangleHeight(), this.getRectangleWidth(), this.getRectangleHeight());
                        rect.setFill(this.getColor1());
                        this.pane.getChildren().add(rect);
                    }
                } 
                else 
                { 
                    if (j % 2 == 0)
                    {
                        rect = new Rectangle(i * this.getRectangleWidth(), j * this.getRectangleHeight(), this.getRectangleWidth(), this.getRectangleHeight());
                        rect.setFill(this.getColor1());
                        this.pane.getChildren().add(rect);
                    } 
                    else
                    { 
                        rect = new Rectangle(i * this.getRectangleWidth(), j * this.getRectangleHeight(), this.getRectangleWidth(), this.getRectangleHeight());
                        rect.setFill(this.getColor2());
                        this.pane.getChildren().add(rect);
                    } 
                } 
            } 
        }
        
        return this.pane;
    } 
    
    public AnchorPane getPane()
    {
        if (this.pane == null)
        {
            return null;
        }
        else
        {
            return this.pane;
        } 
    } 
    
    public int getRows()
    {
        return this.rows;
    } 
    public int getColumns()
    {
        return this.columns;
    } 
    public double getWidth()
    {
        return this.width;
    }
    public double getHeight()
    {
        return this.height;
    } 
    public Color getColor1()
    {
        return this.color1;
    }
    public Color getColor2()
    {
        return this.color2;
    } 
    public double getRectangleWidth()
    {
        return this.width / this.columns;
    } 
    public double getRectangleHeight()
    {
        return this.height / this.rows;
    } 
} 
