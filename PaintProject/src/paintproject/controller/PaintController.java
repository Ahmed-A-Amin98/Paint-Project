package paintproject.controller;

import paintproject.model.Caretaker;
import paintproject.model.Originator;
import com.sun.java.accessibility.util.AWTEventMonitor;
import static com.sun.java.accessibility.util.AWTEventMonitor.addMouseListener;
import static com.sun.java.accessibility.util.AWTEventMonitor.addMouseMotionListener;
import java.awt.AWTEventMulticaster;
import java.awt.Color;
import static java.awt.Color.red;
import java.awt.Point;
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
import javafx.scene.Node;
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
import javafx.scene.shape.Shape;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import paintproject.model.AbstractShape;
import paintproject.model.Ellipse;
import paintproject.model.Select;
import paintproject.model.Square;
import paintproject.model.Triangle;
import paintproject.view.DrawingEngine;
//import jfxtras.labs.util.event.MouseControlUtil;

public class PaintController implements DrawingEngine {
     @FXML
private Button undobtn;
      @FXML
private Button redobtn;
    double x, y, Tx, Ty;
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
    
    @FXML
    private ComboBox comboColors;
    
    private Stage stage;
      

  public void initialize() {
         
       /* comboBox.getItems().addAll("Rectangle", "Square", "Line", "Circle", "Ellipse", "Triangle");
         comboBox.setOnAction(e->{
            if(comboBox.getValue()=="Rectangle")
                drawR();
            else
                if (comboBox.getValue()=="Square")
                    drawS();
            else
                    if (comboBox.getValue()=="Line")
                        drawL();
            else
                        if (comboBox.getValue()=="Circle")
                            drawC();
            else
                            if (comboBox.getValue()=="Ellipse")
                                drawEll();
            else
                                if (comboBox.getValue()=="Triangle")
                                    drawT();
                                  
        });
         
         comboColors.getItems().addAll("BlACK","BlUE","CYAN","DARK_GRAY","GRAY","GREEN","LIGHT_GRAY","MAGENTA","ORANGE","PINK","RED","WHITE","YELLOW");
        
       
         */
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
    
     public void save(){
         FileChooser fileChooser = new FileChooser();
         FileChooser.ExtensionFilter extFilter1 = new FileChooser.ExtensionFilter("xml files (*.xml)", "xml");
           FileChooser.ExtensionFilter extFilter2 = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
         fileChooser.getExtensionFilters().add(extFilter1);
         fileChooser.getExtensionFilters().add(extFilter2);
         File file = fileChooser.showOpenDialog(stage);
    }

    public void drawR() {
        try {
<<<<<<< HEAD
   
=======
<<<<<<< HEAD
   
=======

>>>>>>> d17d9d6ec4e228c9f1b4d312ebea25aea12eb833
>>>>>>> 7b2893297c64d53b19fcec4570c36cbec4fbf2d2
            Factory f=new Factory();
            AbstractShape R;
            R=f.chooseshape("RECTANGLE");
           R.setColor(Color.YELLOW);
           R.setFillColor(Color.WHITE);
            R.draw(canvas);
<<<<<<< HEAD

=======
<<<<<<< HEAD

=======
        } catch (Exception e) {
            e.printStackTrace();
        }
>>>>>>> d17d9d6ec4e228c9f1b4d312ebea25aea12eb833
>>>>>>> 7b2893297c64d53b19fcec4570c36cbec4fbf2d2

    }
    public void Select() {
        try {
      
           Factory f=new Factory();
            AbstractShape R;
            R=f.chooseshape("SELECT");
           R.setColor(Color.YELLOW);
           R.setFillColor(Color.WHITE);
            R.draw(canvas);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void drawS() {

        try {
            Factory f=new Factory();
            AbstractShape R;
            R=f.chooseshape("SQUARE");
           R.setColor(Color.YELLOW);
           R.setFillColor((Color) comboColors.getValue());
            R.draw(canvas);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void drawL() {

        try {
            Factory f=new Factory();
            AbstractShape R;
            R=f.chooseshape("LINE");
           R.setColor(Color.YELLOW);
           R.setFillColor(Color.WHITE);
            R.draw(canvas);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void drawC() {

        try {
            Factory f=new Factory();
            AbstractShape R;
            R=f.chooseshape("CIRCLE");
           R.setColor(Color.YELLOW);
           R.setFillColor(Color.WHITE);
            R.draw(canvas);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void drawEll() {

        try {
            Factory f=new Factory();
            AbstractShape R;
            R=f.chooseshape("ELLIPSE");
           R.setColor(Color.YELLOW);
           R.setFillColor(Color.WHITE);
            R.draw(canvas);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void Select() {
        try {
      
            Factory f=new Factory();
            AbstractShape R;
            R=f.chooseshape("SELECT");
           R.setColor(Color.YELLOW);
           R.setFillColor(Color.WHITE);
            R.draw(canvas);
            Point p=new Point();
            p=R.getPosition();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



    public void drawT() {
        try {

            Factory f=new Factory();
            AbstractShape R;
            R=f.chooseshape("TRIANGLE");
           R.setColor(Color.YELLOW);
           R.setFillColor(Color.WHITE);
            R.draw(canvas);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    //////////////////////////////////////////////////////

   public void Drag() {
        GraphicsContext g = canvas.getGraphicsContext2D();
        canvas.setOnMouseMoved(canvasonmousepressEventHandler);
        canvas.setOnMouseDragged(canvasOnMouseDraggedEventHandler);

    }

    EventHandler<MouseEvent> canvasonmousepressEventHandler = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event) {
        Select s= new Select(null, red, red);
        Point p = new Point();
            GraphicsContext g = canvas.getGraphicsContext2D();
            g.beginPath();
            x = event.getX();
            y = event.getY();
            Tx =s.getX();
            Ty =s.getY() ;
        }
    };

    EventHandler<MouseEvent> canvasOnMouseDraggedEventHandler = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent mouseEvent) {
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

    @Override
    public void refresh(Object canvas) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addShape(paintproject.model.Shape shape) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeShape(paintproject.model.Shape shape) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateShape(paintproject.model.Shape oldShape, paintproject.model.Shape newShape) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public paintproject.model.Shape[] getShapes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void undo() {
        
    }

    @Override
    public void redo() {
       
    }

    @Override
    public void save(String path) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void load(String path) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

