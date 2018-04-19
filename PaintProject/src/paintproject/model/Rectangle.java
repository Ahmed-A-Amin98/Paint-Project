/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paintproject.model;

import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Point;
import java.util.Map;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;

import javafx.application.Platform;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javax.imageio.ImageIO;
import java.io.File;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import static javafx.scene.paint.Color.color;
import static javafx.scene.paint.Color.color;

import static javafx.scene.paint.Color.color;
import jdk.nashorn.internal.codegen.CompilerConstants;
import paintproject.model.Circle;
import paintproject.model.Line;
import paintproject.model.Rectangle;

/**
 *
 * @author Ahmed Bahey
 */
public class Rectangle extends AbstractShape {

    private double w, h;
    private GraphicsContext g;

    public Rectangle(double w, double h, GraphicsContext g, Point p, Color c, Color fillc, Map<String, Double> myMap) {
        super(p, c, fillc, myMap);
        this.w = w;
        this.h = h;
        this.g = g;
    }

   

   

    
   

    public void setFill(Color green) {

    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }

    //@Override
    public void draw(Canvas canvas) {
        // super.draw(canvas);
        GraphicsContext g = canvas.getGraphicsContext2D();
        canvas.setOnMousePressed(e -> {
            g.beginPath();
            p.x = (int) e.getX();
            p.y= (int) e.getY();
        });

        canvas.setOnMouseDragged(e -> {
            this.w = e.getX() - x;
            this.h = e.getY() - y;
          
            g.clearRect(x, y, w, h);

            g.strokeRect(x, y, w, h);

        });
        canvas.setOnMouseReleased(e -> {

            g.strokeRect(x, y, w, h);
            g.closePath();
            Point p=new Point();
         //   p=MouseInfo.getPointerInfo().getLocation();
         //   System.out.println("x is"+p.x+"y is "+p.y);


        });

    }

    @Override
    public Color getFillColor() {
        return super.getFillColor(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setFillColor(Color color) {
        super.setFillColor(color); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Color getColor() {
        return super.getColor(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setColor(Color color) {
        super.setColor(color); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Map<String, Double> getProperties() {
        return super.getProperties(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setProperties(Map<String, Double> properties) {
        super.setProperties(properties); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Point getPosition() {
        return super.getPosition(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setPosition(Point position) {
        super.setPosition(position); //To change body of generated methods, choose Tools | Templates.
    }

    public double getWidth() {
        return w;
    }

    public void setWidth(double width) {
        this.w = width;
    }

    public double getHeight() {
        return h;
    }

    public void setHeight(double height) {
        this.h = height;
    }

}
