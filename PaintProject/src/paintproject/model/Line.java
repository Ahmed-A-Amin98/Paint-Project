/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paintproject.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javax.swing.*;
/**
 *
 * @author Ahmed Bahey
 */
public class Line extends AbstractShape{
    
      protected Point p1 = new Point();

    protected Map<String, Double> propLine;
    protected Color c;
    protected Color fc;
    int gr, b, a, opacity;
    
     public Line(Point p, Color c, Color fillc) {
        super(p, c, fillc);
         propLine = new HashMap<>();
        propLine.put("x", 0.0);
        propLine.put("y", 0.0);
    }

    
   

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }

    
    public void draw(Canvas canvas) {
        //super.draw(canvas); //To change body of generated methods, choose Tools | Templates.
        GraphicsContext g = canvas.getGraphicsContext2D();
       
        java.awt.Color awtColor = getColor();
        int rr = awtColor.getRed();
        gr = awtColor.getGreen();
        b = awtColor.getBlue();
        a = awtColor.getAlpha();
        opacity = (int) (a / 255.0);
        javafx.scene.paint.Color zz = javafx.scene.paint.Color.rgb(rr, gr, b, opacity);
        g.setStroke(zz);
        canvas.setOnMousePressed(e -> {

            g.beginPath();
            p1.x = (int) e.getX();
            p1.y = (int) e.getY();
           
              //g.strokeLine(5, 10, 60, 50);
        });

        canvas.setOnMouseDragged(e -> {

            propLine.put("x", e.getX()); 
            propLine.put("y", e.getY());
         g.clearRect((int)p1.getX(),(int) p1.getY(), (int)propLine.get("x").intValue(), (int)propLine.get("y").intValue());

            g.strokeLine((int) p1.getX(), (int) p1.getY(), (int) propLine.get("x").intValue(), (int) propLine.get("y").intValue());
            
 
           

        });
        canvas.setOnMouseReleased(e -> {

            g.strokeLine((int) p1.getX(), (int) p1.getY(), (int) propLine.get("x").intValue(), (int) propLine.get("y").intValue());
            g.closePath();

            //   System.out.println("x is"+p.x+"y is "+p.y);
        });

        
        
        
    }
    
}
