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

    public Circle(Point p, Color c, Color fillc, Map<String, Double> myMap) {
        super(p, c, fillc, myMap);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void draw(Object canvas) {
        super.draw(canvas); //To change body of generated methods, choose Tools | Templates.
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

  
   
    

}
