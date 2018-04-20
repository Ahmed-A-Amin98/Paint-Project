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
 * @author dell-pc
 */
public class Circle extends AbstractShape{
    
    protected Point pc = new Point();
    protected Map<String, Double> propCircle;
    protected Color c;
    protected Color fc;
     int gr,b,a,opacity,r;

    public Circle(Point p, Color c, Color fillc) {
      
        super(p, c, fillc);
         propCircle = new HashMap<>();
        propCircle.put("r", 0.0);
        propCircle.put("r", 0.0);
    }
    

    
   

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }

   
    public void draw(Canvas canvas) {
      
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
            pc.x = (int) e.getX();
            pc.y = (int) e.getY();
           
              //g.strokeLine(5, 10, 60, 50);
        });

        canvas.setOnMouseDragged(e -> {

            propCircle.put("x", e.getX()); 
            propCircle.put("y", e.getY());
            //g.strokeLine((int) p1.getX(), (int) p1.getY(), (int) propLine.get("x").intValue(), (int) propLine.get("y").intValue());
           
 
           

        });
        canvas.setOnMouseReleased(e -> {

        g.strokeOval((int)pc.x, (int)pc.y, r, 0);            
        g.closePath();

            //   System.out.println("x is"+p.x+"y is "+p.y);
        });

        
        
        
        
        
    }

   
    

}
