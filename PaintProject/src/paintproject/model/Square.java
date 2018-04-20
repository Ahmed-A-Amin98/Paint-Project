/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paintproject.model;

import java.awt.Color;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;
import javafx.scene.shape.*;

/**
 *
 * @author amrak
 */
public class Square extends AbstractShape {

    protected Point p = new Point();
    protected Map<String, Double> propsq;
    protected Color c;
    protected Color fc;
    int gr, b, a, opacity;
    int gr2, b2, a2, opacity2;

    public Square(Point p, Color c, Color fillc) {
        super(p, c, fillc);
        propsq = new HashMap<>();
        propsq.put("s", 0.0);

    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        // return super.clone(); //To change body of generated methods, choose Tools | Templates.

        AbstractShape r = new Square(p, c, fillc);
        r.setColor(c);
        r.setFillColor(fc);
        r.setPosition(p);
        Map newprop = new HashMap<>();
        for (Map.Entry s : propsq.entrySet()) {
            newprop.put(s.getKey(), s.getValue());
        }
        r.setProperties(newprop);
        return r;
    }

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
             propsq.put("s", 0.0);

            p.x = (int) e.getX();
            p.y = (int) e.getY();
        });

        canvas.setOnMouseDragged(e -> {

            //propsq.put("s", e.getX() - (int)p.getX());
            propsq.put("s", e.getY() - (int) p.getY());

            //g.clearRect((int) p.getX(), (int) p.getY(), (int) propsq.get("s").intValue(), (int) propsq.get("s").intValue());
            //g.strokeRect((int) p.getX(), (int) p.getY(), (int) propsq.get("s").intValue(), (int) propsq.get("s").intValue());

        });
        canvas.setOnMouseReleased(e -> {

            g.fillRect((int) p.getX(), (int) p.getY(), (int) propsq.get("s").intValue(), (int) propsq.get("s").intValue());
            g.closePath();

            //   System.out.println("x is"+p.x+"y is "+p.y);
        });

    }

}
