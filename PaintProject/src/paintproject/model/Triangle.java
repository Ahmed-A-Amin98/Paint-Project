
package paintproject.model;

import java.awt.Color;
import java.awt.Point;
import java.util.Map;

public class Triangle extends AbstractShape {

    public Triangle(Point p, Color c, Color fillc) {
        super(p, c, fillc);
    }

  

     

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void draw(Object canvas) {
        super.draw(canvas); //To change body of generated methods, choose Tools | Templates.
    }

   
}