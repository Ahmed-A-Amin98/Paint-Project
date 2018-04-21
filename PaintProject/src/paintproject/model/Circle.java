package paintproject.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javax.swing.*;

public class Circle extends AbstractShape {

    protected Point pc = new Point();
    protected Map<String, Double> propCircle;
    protected Color c;
    protected Color fc;
    int gr, b, a, opacity, r;
    int gr2, b2, a2, opacity2;

    public Circle(Point p, Color c, Color fillc) {

        super(p, c, fillc);
        propCircle = new HashMap<>();
        propCircle.put("r", 0.0);
        propCircle.put("r", 0.0);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        //return super.clone(); //To change body of generated methods, choose Tools | Templates.

        AbstractShape r = new Circle(p, c, fillc);
        r.setColor(c);
        r.setFillColor(fc);
        r.setPosition(p);
        Map newprop = new HashMap<>();
        for (Map.Entry s : propCircle.entrySet()) {
            newprop.put(s.getKey(), s.getValue());
        }
        r.setProperties(newprop);
        return r;

    }

    public void draw(Canvas canvas) {

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
            propCircle.put("r", 0.0);
            propCircle.put("r", 0.0);
            pc.x = (int) e.getX();
            pc.y = (int) e.getY();

            //g.strokeLine(5, 10, 60, 50);
        });

        canvas.setOnMouseDragged(e -> {

            propCircle.put("r", e.getX() - (int) pc.getX());
            propCircle.put("r", e.getY() - (int) pc.getY());

            //g.clearRect((int) pc.getX(), (int) pc.getY(), (int) propCircle.get("r").intValue(), (int) propCircle.get("r").intValue());
            //g.strokeOval((int) pc.getX(), (int) pc.getY(), (int) propCircle.get("r").intValue(), (int) propCircle.get("r").intValue());

            //g.strokeLine((int) p1.getX(), (int) p1.getY(), (int) propLine.get("x").intValue(), (int) propLine.get("y").intValue());
        });
        canvas.setOnMouseReleased(e -> {
            g.fillOval((int) pc.x, (int) pc.y, propCircle.get("r").intValue(), propCircle.get("r").intValue());

            //g.strokeOval((int)pc.x, (int)pc.y, 2*r, 2*r);            
            g.closePath();

            originator.set(this);
            caretaker.addMemento(originator.storeInMemento());
           AbstractShape.saveFiles++;
            AbstractShape.currentArticle++;

            System.out.println("Save Files " + AbstractShape.saveFiles);
        });

    }

}
