
package paintproject.model;

import java.awt.Color;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class Triangle extends AbstractShape {

 protected Point p1 = new Point();
  protected Point p2 = new Point();

    protected Map<String, Double> propt;
    protected Color c;
    protected Color fc;
    int gr,b,a,opacity;
    int gr2, b2, a2, opacity2;
    public Triangle(Point p, Color c, Color fillc) {
        super(p, c, fillc);
        propt = new HashMap<>();
        propt.put("w", 0.0);
    }

  

     

    @Override
    public Object clone() throws CloneNotSupportedException {
        //return super.clone(); //To change body of generated methods, choose Tools | Templates.
        
            AbstractShape r = new Triangle(p, c, fillc);
        r.setColor(c);
        r.setFillColor(fc);
        r.setPosition(p);
        Map newprop = new HashMap<>();
        for (Map.Entry s: propt.entrySet())
            newprop.put(s.getKey(), s.getValue());
        r.setProperties(newprop);
        return r;
    }

       public void draw( Canvas canvas )
    {
      GraphicsContext g = canvas.getGraphicsContext2D();
            java.awt.Color awtColor = getColor() ;
            int rr =awtColor.getRed();
 gr = awtColor.getGreen();
  b = awtColor.getBlue();
 a = awtColor.getAlpha();
  opacity =  (int) (a / 255.0) ;
 javafx.scene.paint.Color zz = javafx.scene.paint.Color.rgb(rr, gr, b, opacity);
   java.awt.Color fillColor = getFillColor();
        int rr2 = fillColor.getRed();
        gr2 = fillColor.getGreen();
        b2 = fillColor.getBlue();
        a2 = fillColor.getAlpha();
        opacity2 = (int) (a2 / 255.0);
        javafx.scene.paint.Color z = javafx.scene.paint.Color.rgb(rr2, gr2, b2, opacity2);
        g.setStroke(zz);
        g.setFill(z);

 
  canvas.setOnMousePressed(e -> {
                
                g.beginPath();
               propt.put("w", 0.0);
               p1.x= (int) e.getX();
                p1.y = (int) e.getY();
            });
      canvas.setOnMouseDragged(e -> {
                
                      propt.put("w", e.getX() - (int)p1.getX());


           
            });
       canvas.setOnMouseReleased(e -> {
       p2.x= (int) e.getX();
                p2.y = (int) e.getY();
        double[] Xcoord = { (int)p1.getX()+Math.abs((int)propt.get("w").intValue())/2 ,(int)p1.getX() ,(int)p2.getX() };
        double[] Ycoord = { (int)p1.getY(),(int) p2.getY(),(int) p2.getY()};
          g.setStroke(g.getStroke()); //sets the color
          g.strokePolygon(Xcoord, Ycoord, 3); //draws a regular triangle
              
        g.closePath();
        });
    }
               

   
}