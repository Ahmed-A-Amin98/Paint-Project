/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paintproject.controller;

import javafx.scene.paint.Color;
import paintproject.model.AbstractShape;
import paintproject.model.Circle;
import paintproject.model.Ellipse;
import paintproject.model.Line;
import paintproject.model.Rectangle;
import paintproject.model.Square;
import paintproject.model.Triangle;

/**
 *
 * @author amrak
 */
public class Factory {
    
    public Object chooseshape(String Shape){

        if(Shape.equalsIgnoreCase("RECTANGLE")){
          return new Rectangle(null,java.awt.Color.BLACK,java.awt.Color.BLACK); 
        }
        
        if(Shape.equalsIgnoreCase("SQUARE")){
          return new Square(null,java.awt.Color.BLACK,java.awt.Color.BLACK);
        }if(Shape.equalsIgnoreCase("LINE")){
         // return new Line();
        }
        
        if(Shape.equalsIgnoreCase("ELLIPSE")){
        //  return new Ellipse(); 
        }
        
        if(Shape.equalsIgnoreCase("TRIANGLE")){
        //   return new Triangle();
        }
        
        if(Shape.equalsIgnoreCase("CIRCLE")){
       //  return new Circle();
        }
        return null;
        
    }
    
}