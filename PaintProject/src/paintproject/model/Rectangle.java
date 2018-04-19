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
import java.util.HashMap;
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

   protected Point p = new Point();
    protected Map<String, Double> proprec;
    protected Color c;
    protected Color fc;
     int gr,b,a,opacity;


    public Rectangle( Point p, Color c, Color fillc) {
        super(p, c, fillc);
        proprec = new HashMap<>();
        proprec.put("w", 0.0);
        proprec.put("h", 0.0);
        
    }
    
    

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }

    

    

    //@Override
    public void draw(Canvas canvas) {
        // super.draw(canvas);
            GraphicsContext g = canvas.getGraphicsContext2D();
            java.awt.Color awtColor = getColor() ;
            int rr =awtColor.getRed();
 gr = awtColor.getGreen();
  b = awtColor.getBlue();
 a = awtColor.getAlpha();
  opacity =  (int) (a / 255.0) ;
 javafx.scene.paint.Color zz = javafx.scene.paint.Color.rgb(rr, gr, b, opacity);
 g.setStroke(zz);
            canvas.setOnMousePressed(e -> {
                g.beginPath();
             
               p.x= (int) e.getX();
                p.y = (int) e.getY();
            });
               
            canvas.setOnMouseDragged(e -> {
                
               proprec.put("w", e.getX() - (int)p.getX());
               proprec.put("h",  e.getY() - (int)p.getY() ); 
                   
                g.clearRect((int)p.getX(),(int) p.getY(), (int)proprec.get("w").intValue(), (int)proprec.get("h").intValue());
                g.strokeRect((int)p.getX(),(int) p.getY(), (int)proprec.get("w").intValue(), (int)proprec.get("h").intValue());

            });
            canvas.setOnMouseReleased(e -> {

                g.strokeRect((int)p.getX(),(int) p.getY(), (int)proprec.get("w").intValue(), (int)proprec.get("h").intValue());
                g.closePath();
                

                //   System.out.println("x is"+p.x+"y is "+p.y);
                
            });
            
        } 
    

    public double getWidth() {
        return (int)proprec.get("w").intValue();
    }

    public void setWidth(double width) {
        proprec.put("w",width);
    }

    public double getHeight() {
        return (int)proprec.get("h").intValue();
    }

    public void setHeight(double height) {
        proprec.put("h",height);
    }

}
