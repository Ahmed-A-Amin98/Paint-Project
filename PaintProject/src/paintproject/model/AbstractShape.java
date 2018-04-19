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
public  abstract class AbstractShape implements Shape{
    protected Point p;
    protected Color c;
    protected Color fillc;
    protected Map<String, Double> myMap;

    public AbstractShape(Point p,Color c, Color fillc) {
       this.p=p;
        this.c =c;
        this.fillc = fillc;
       
    }
    
    @Override
    public void setPosition(Point position) {
        p=position;
    }

    @Override
    public Point getPosition() {
      return p;
    }

    @Override
    public void setProperties(Map<String, Double> properties) {
       myMap=properties;
    }

    @Override
    public Map<String, Double> getProperties() {
       return  myMap;
    }

    @Override
    public void setColor(Color color) {
        c=color;
    }

    @Override
    public Color getColor() {
       return c;
    }

    @Override
    public void setFillColor(Color color) {
       fillc=color;
    }

    @Override
    public Color getFillColor() {
        return fillc;
    }

    @Override
    public void draw(Object canvas) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    

   
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }
    
   
    
   
    
    
     
     
    
}
