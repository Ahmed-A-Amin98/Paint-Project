/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paintproject.model;

import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Point;
import java.util.Map;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;

import javafx.application.Platform;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javax.imageio.ImageIO;
import java.io.File;
import java.util.HashMap;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import static javafx.scene.input.KeyCode.R;
import javafx.scene.input.MouseEvent;
import static javafx.scene.paint.Color.color;
import static javafx.scene.paint.Color.color;

import static javafx.scene.paint.Color.color;
import jdk.nashorn.internal.codegen.CompilerConstants;
import paintproject.model.Circle;
import paintproject.model.Line;
import paintproject.model.Rectangle;

/**
 *
 * @author Ahmed Bahey
 */
public class Rectangle extends AbstractShape {

    protected Point p = new Point();
    protected Map<String, Double> proprec;
    protected Color c;
    protected Color fillc;
    int gr, b, a, opacity;
    int gr2, b2, a2, opacity2;

    public Rectangle(Point p, Color c, Color fillc) {
        super(p, c, fillc);
        proprec = new HashMap<>();
        proprec.put("w", 0.0);
        proprec.put("h", 0.0);

    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        // return super.clone(); //To change body of generated methods, choose Tools | Templates.

        AbstractShape r = new Rectangle(p, c, fillc);
        r.setColor(c);
        r.setFillColor(fillc);
        r.setPosition(p);
        Map newprop = new HashMap<>();
        for (Map.Entry s : proprec.entrySet()) {
            newprop.put(s.getKey(), s.getValue());
        }
        r.setProperties(newprop);
        return r;
    }

    @Override
    public void draw(Canvas canvas) {
        // super.draw(canvas);
        GraphicsContext g = canvas.getGraphicsContext2D();
        java.awt.Color awtColor = getColor();
        int rr = awtColor.getRed();
        gr = awtColor.getGreen();
        b = awtColor.getBlue();
        a = awtColor.getAlpha();
        opacity = (int) (a / 255.0);
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

            proprec.put("w", 0.0);
            proprec.put("h", 0.0);
            p.x = Math.abs((int) e.getX());
            p.y = Math.abs((int) e.getY());
        });

        canvas.setOnMouseDragged(e -> {

            proprec.put("w", Math.abs(e.getX() - (int) p.getX()));
            proprec.put("h", Math.abs(e.getY() - (int) p.getY()));

            //g.clearRect(Math.abs((int) p.getX()), Math.abs((int) p.getY()), Math.abs((int) proprec.get("w").intValue()), Math.abs((int) proprec.get("h").intValue()));
            //g.strokeRect(Math.abs((int) p.getX()),Math.abs((int) p.getY()),Math.abs((int) proprec.get("w").intValue()),Math.abs((int) proprec.get("h").intValue()));
            // g.clearRect(Math.abs((int) p.getX())+1, Math.abs((int) p.getY())+1, Math.abs((int) proprec.get("w").intValue())+1, Math.abs((int) proprec.get("h").intValue()+1));
        });
        canvas.setOnMouseReleased(e -> {

            g.strokeRect(Math.abs((int) p.getX()), Math.abs((int) p.getY()), Math.abs((int) proprec.get("w").intValue()), Math.abs((int) proprec.get("h").intValue()));

            g.closePath();

            originator.set(this);
            caretaker.addMemento(originator.storeInMemento());
            AbstractShape.saveFiles++;
            AbstractShape.currentArticle++;

            System.out.println("Save Files " + AbstractShape.saveFiles);

        });

    }

    public double getWidth() {
        return (int) proprec.get("w").intValue();
    }

    public void setWidth(double width) {
        proprec.put("w", width);
    }

    public double getHeight() {
        return (int) proprec.get("h").intValue();
    }

    public void setHeight(double height) {
        proprec.put("h", height);
    }

    @Override
    public String toString() {//overriding the toString() method  
        return p + " " + proprec + " " + c + " " + fillc;
    }

}
