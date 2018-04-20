package paintproject.controller;

import com.sun.java.accessibility.util.AWTEventMonitor;
import static com.sun.java.accessibility.util.AWTEventMonitor.addMouseListener;
import static com.sun.java.accessibility.util.AWTEventMonitor.addMouseMotionListener;
import java.awt.AWTEventMulticaster;
import java.awt.Color;
import static java.awt.Color.red;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
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
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import static javafx.scene.paint.Color.color;
import static javafx.scene.paint.Color.color;

import static javafx.scene.paint.Color.color;
import paintproject.model.Circle;
import paintproject.model.Line;
import paintproject.model.Rectangle;
import javafx.scene.paint.Paint;
import paintproject.model.AbstractShape;
import paintproject.model.Ellipse;
import paintproject.model.Square;
import paintproject.model.Triangle;

public class PaintController {

    double x,y,Tx,Ty;
    @FXML
    private Canvas canvas;

    @FXML
    public ColorPicker colorPicker;

    @FXML
    private TextField brushSize;

    @FXML
    private CheckBox eraser;
    @FXML
    private Button Rec;

    @FXML
    private ComboBox comboBox;

    public void initialize() {
        comboBox.getItems().addAll("Rectangle", "Square", "Line", "Circle", "Ellipse", "Triangle");
    }

    public void freedraw() {
        GraphicsContext g = canvas.getGraphicsContext2D();
        canvas.setOnMouseDragged(e -> {
            double size = Double.parseDouble(brushSize.getText());
            double x = e.getX();
            double y = e.getY();
            if (eraser.isSelected()) {
                g.clearRect(x, y, size, size);
            } else {
                g.setFill(colorPicker.getValue());
                g.fillRect(x, y, size, size);
            }
        });
    }

    public void drawR() {
        try {

           Rectangle r = new Rectangle(null, Color.BLACK, Color.BLACK);
           r.setColor(Color.BLUE);
           r.setFillColor(Color.YELLOW);
            r.draw(canvas);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void drawS() {

        try {
            Square s = new Square(null, Color.BLACK, Color.BLACK);

            s.setColor(Color.YELLOW);
            s.setFillColor(Color.YELLOW);

            s.draw(canvas);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void drawL() {

        try {
            Line l = new Line(null, Color.BLACK, Color.BLACK);

            l.setColor(Color.RED);

            l.draw(canvas);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     public void drawC() {

        try {
            Circle c = new Circle(null, Color.BLACK, Color.BLACK);

            c.setColor(Color.RED);
             c.setFillColor(Color.BLUE);
             javafx.scene.paint.Color str=colorPicker.getValue();
             

            c.draw(canvas);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     
     
      public void drawEll() {

        try {
            Ellipse e = new Ellipse(null, Color.BLACK, Color.BLACK);

            e.setColor(Color.RED);

            e.draw(canvas);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
      public void drawT() {
        try {

            Triangle r = new Triangle(null, Color.BLACK, Color.BLACK);
            r.setColor(Color.RED);
            r.setFillColor(Color.BLUE);

            r.draw(canvas);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
      //////////////////////////////////////////////////////
       public void Drag(){
        GraphicsContext g = canvas.getGraphicsContext2D();
        canvas.setOnMouseMoved(canvasonmousepressEventHandler);
        canvas.setOnMouseDragged(canvasOnMouseDraggedEventHandler);
       
        
    }
    
    EventHandler<MouseEvent>canvasonmousepressEventHandler=new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event) {
           GraphicsContext g = canvas.getGraphicsContext2D();
           g.beginPath();
           x=event.getX();
           y=event.getY();
           Tx = ((Canvas)(event.getSource())).getTranslateX();
          Ty = ((Canvas) (event.getSource())).getTranslateY();
        }
    };
    
    
     EventHandler<MouseEvent> canvasOnMouseDraggedEventHandler = new EventHandler<MouseEvent>()
    {
        @Override
        public void handle(MouseEvent mouseEvent)
        {
            double offsetX = mouseEvent.getSceneX() - x;
            double offsetY = mouseEvent.getSceneY() - y;
            double newTranslateX = Tx + offsetX;
            double newTranslateY = Ty + offsetY;

            ((Canvas) (mouseEvent.getSource())).setTranslateX(newTranslateX);  //transform the object
            ((Canvas) (mouseEvent.getSource())).setTranslateY(newTranslateY);
        }
    };
     
     ///////////////////////////////////////////////////////////////
    /* 
    EventHandler<MouseEvent>canvasonmousepressEventHandler2=new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event) {
           x=event.getX();
           y=event.getY();
           //canvas.setCursor(Cursor.MOVE);
           //canvas.requestFocus();
          //Tx = ((Canvas)(event.getSource())).getTranslateX();
          //Ty = ((Canvas) (event.getSource())).getTranslateY();
        }
    };
    
    
     EventHandler<MouseEvent> canvasOnMouseDraggedEventHandler2 = new EventHandler<MouseEvent>()
    {
        @Override
        public void handle(MouseEvent mouseEvent)
        {
           
        }
    };
     
      EventHandler<MouseEvent> canvasOnMouseRelesedEventHandler2 = new EventHandler<MouseEvent>()
    {
        @Override
        public void handle(MouseEvent mouseEvent)
        {
          xe=mouseEvent.getX();
          ye=mouseEvent.getY(); 
          
        }
    };
       g.strokeRect(x, y, x-xe, y-ye);
     }
    
   ////////////////////////////////////////////////////////////////
    public void Drag(){
        GraphicsContext g = canvas.getGraphicsContext2D();
        canvas.setOnMouseMoved(canvasonmousepressEventHandler);
        canvas.setOnMouseDragged(canvasOnMouseDraggedEventHandler);
       
        
    }
    
    EventHandler<MouseEvent>canvasonmousepressEventHandler=new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event) {
           GraphicsContext g = canvas.getGraphicsContext2D();
           g.beginPath();
           x=event.getX();
           y=event.getY();
          // Tx = ((Canvas)(event.getSource())).getTranslateX();
         // Ty = ((Canvas) (event.getSource())).getTranslateY();
        }
    };
    
    
     EventHandler<MouseEvent> canvasOnMouseDraggedEventHandler = new EventHandler<MouseEvent>()
    {
        @Override
        public void handle(MouseEvent mouseEvent)
        {
            double offsetX = mouseEvent.getSceneX() - x;
            double offsetY = mouseEvent.getSceneY() - y;
            double newTranslateX = Tx + offsetX;
            double newTranslateY = Ty + offsetY;

            ((Canvas) (mouseEvent.getSource())).setTranslateX(newTranslateX);  //transform the object
            ((Canvas) (mouseEvent.getSource())).setTranslateY(newTranslateY);
        }
    };
    
  
    
 /*public MouseListener mousehandlerListener=new MouseAdapter() {

 public  void mousepressed(MouseEvent e){
      
      GraphicsContext g = canvas.getGraphicsContext2D();
      g.beginPath();
      g.setLineWidth(2);
      g.lineTo(50, 100);
      x=xe=w=e.getX();
      y=ye=h=e.getY();
      System.out.println("");
 }
 public void mouserelesed(MouseEvent e){
     GraphicsContext g = canvas.getGraphicsContext2D();
    xe=e.getX();
    ye=e.getY();
    g.strokeRect(x, y, w, h);
    g.closePath();
 }
 
 };
 
 public MouseMotionListener mouseMotionHandler=new MouseMotionAdapter() {

 public void mouseDragged(MouseEvent e){
   w=e.getScreenX();
   h=e.getScreenY();
 }
 };
         
    
  
       
         
       
        canvas.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
    @Override
    public void handle(MouseEvent e) {
     g.beginPath();
      g.setLineWidth(2);
      g.lineTo(50, 100);
      x=xe=w=e.getX();
      y=ye=h=e.getY();
      System.out.println("");
  
         canvas.addEventFilter(MouseEvent.MOUSE_DRAGGED, new EventHandler<MouseEvent>() {
    @Override
    public void handle(MouseEvent e) {
      
      //g.strokeRect(0, 0,mouseEvent.getSceneX(), mouseEvent.getSceneY());
     w=e.getScreenX();
     h=e.getScreenY();
      g.stroke();
           canvas.addEventFilter(MouseEvent.MOUSE_RELEASED, new EventHandler<MouseEvent>() {
    @Override
    public void handle(MouseEvent e) {
    xe=e.getX();
    ye=e.getY();
    g.strokeRect(x, y, w, h);
    g.closePath();
    g.stroke();
    }
});
    }
});
         
           }
});
    }     
       
     */
    public void onSave() {
        try {
            Image snapshot = canvas.snapshot(null, null);

            ImageIO.write(SwingFXUtils.fromFXImage(snapshot, null), "png", new File("paint.png"));
        } catch (Exception e) {
            System.out.println("Failed to save image: " + e);
        }
    }

    public void onExit() {
        Platform.exit();
    }
    
    
   
}
