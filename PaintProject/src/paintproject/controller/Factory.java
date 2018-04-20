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


public class Factory {
    
    public AbstractShape chooseshape(String Shape){

        if(Shape.equalsIgnoreCase("RECTANGLE")){
          return new Rectangle(null,java.awt.Color.BLACK,java.awt.Color.BLACK); 
        }
        
        if(Shape.equalsIgnoreCase("SQUARE")){
          return new Square(null,java.awt.Color.BLACK,java.awt.Color.BLACK);
        }if(Shape.equalsIgnoreCase("LINE")){
       return new Line(null,java.awt.Color.BLACK,java.awt.Color.BLACK);
        }
        
        if(Shape.equalsIgnoreCase("ELLIPSE")){
         return new Ellipse(null,java.awt.Color.BLACK,java.awt.Color.BLACK);
        }
        
        if(Shape.equalsIgnoreCase("TRIANGLE")){
        return new Triangle(null,java.awt.Color.BLACK,java.awt.Color.BLACK);
        }
        
        if(Shape.equalsIgnoreCase("CIRCLE")){
      return new Circle(null,java.awt.Color.BLACK,java.awt.Color.BLACK);
        }
        return null;
        
    }
    
}
