/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paintproject.model;

import java.awt.Color;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

/**
 *
 * @author Ahmed Bahey
 */
public class Ellipse extends AbstractShape{

     protected Point pell = new Point();
    protected Map<String, Double> propell;
    protected Color c;
    protected Color fc;
     int gr,b,a,opacity;
    
    
    public Ellipse(Point p, Color c, Color fillc) {
        super(p, c, fillc);
          propell = new HashMap<>();
        propell.put("w", 0.0);
        propell.put("h", 0.0);
        
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }

    
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
             
               pell.x= (int) e.getX();
                pell.y = (int) e.getY();
            });
               
            canvas.setOnMouseDragged(e -> {
                
               propell.put("w", e.getX() - (int)pell.getX());
               propell.put("h",  e.getY() - (int)pell.getY() ); 
                   
                g.clearRect((int)pell.getX(),(int) pell.getY(), (int)propell.get("w").intValue(), (int)propell.get("h").intValue());
                g.strokeOval((int)pell.getX(),(int) pell.getY(), (int)propell.get("w").intValue(), (int)propell.get("h").intValue());

            });
            canvas.setOnMouseReleased(e -> {

                g.strokeOval((int)pell.getX(),(int) pell.getY(), (int)propell.get("w").intValue(), (int)propell.get("h").intValue());
                g.closePath();
                

                //   System.out.println("x is"+p.x+"y is "+p.y);
                
            });
            
        
        }
    
}
