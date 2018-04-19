/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paintproject.model;

import java.awt.Color;
import java.awt.Point;
import java.util.Map;

/**
 *
 * @author dell-pc
 */
public class Circle extends AbstractShape implements Cloneable{

    public Circle(Point p, Color c, Color fillc) {
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
