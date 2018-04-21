/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paintproject.controller;

import paintproject.model.AbstractShape;
import paintproject.model.Circle;
import paintproject.model.Ellipse;
import paintproject.model.Line;
import paintproject.model.Rectangle;
import paintproject.model.Square;
import paintproject.model.Triangle;
import java.awt.Color;
import paintproject.model.Select;

/**
 *
 * @author amrak
 */
public class Factory {
    
    public AbstractShape chooseshape(String Shape){

        AbstractShape A=null;
        if(Shape.equalsIgnoreCase("RECTANGLE")){
          A= new Rectangle(null,Color.BLACK,Color.BLACK); 
        }
        
        if(Shape.equalsIgnoreCase("SQUARE")){
         A=new Square(null,java.awt.Color.BLACK,java.awt.Color.BLACK);
        }if(Shape.equalsIgnoreCase("LINE")){
         A= new Line(null,java.awt.Color.BLACK,java.awt.Color.BLACK);
        }
        
        if(Shape.equalsIgnoreCase("ELLIPSE")){
      A=new Ellipse(null,java.awt.Color.BLACK,java.awt.Color.BLACK);
        }
        
        if(Shape.equalsIgnoreCase("TRIANGLE")){
    A=new Triangle(null,java.awt.Color.BLACK,java.awt.Color.BLACK);
        }
        
        if(Shape.equalsIgnoreCase("CIRCLE")){
      A= new Circle(null,java.awt.Color.BLACK,java.awt.Color.BLACK);
        }
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 7b2893297c64d53b19fcec4570c36cbec4fbf2d2
         if(Shape.equalsIgnoreCase("SELECT")){
      A= new Select(null,java.awt.Color.BLACK,java.awt.Color.BLACK);
        }
  
<<<<<<< HEAD
=======
=======
        
          if(Shape.equalsIgnoreCase("SELECT")){
      A= new Circle(null,java.awt.Color.BLACK,java.awt.Color.BLACK);
        }
>>>>>>> d17d9d6ec4e228c9f1b4d312ebea25aea12eb833
>>>>>>> 7b2893297c64d53b19fcec4570c36cbec4fbf2d2
        return A;
        
    }
    
    
}
