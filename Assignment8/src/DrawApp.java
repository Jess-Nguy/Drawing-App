
import java.util.InputMismatchException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.StrokeLineCap;
import javafx.stage.Stage;


/**
 *This class is a GUI drawing application.
 *
 * 
 * @author Jess Nguyen, 000747411
 */
public class DrawApp extends Application {
    /**Graphics Context called drawGC **/
    GraphicsContext  drawGC;
    /**all of the labels **/
    private Label labelLocation, labelRadius, labelColour, labelMessage, labelErrors;
    /**all of the text fields**/
    private TextField textX, textY, textRadius, textRed, textGreen, textBlue;
    /**radius of the circle draw tool**/
    private int radius = 20;
    /**number for rgb red, green and blue colour**/
    private int red;
    private int green;    
    private int blue;
    /**Past x and y location to draw a line for smooth brush work**/
    private double previousX;
    private double previousY;
    /**User input of x and y**/
    private int x;
    private int y;

    // TODO: Instance Variables for View Components and Model
    // TODO: Private Event Handlers and Helper Methods
    /**
     * Draws a circle from user input on canvas.
     * @param e The ActionEvent of draw
     **/
    private void drawing(ActionEvent e) {
        try {
            radius = Integer.parseInt(textRadius.getText());
            if (radius <= 0) {
                labelErrors.setText("Radius has to be greater than 0.");
                return;
            }
        } catch (NumberFormatException g) {
            labelErrors.setText("Bad input for Radius.");
            return;
        }
        try {
            red = Integer.parseInt(textRed.getText());
            if (red < 0 || red > 255) {
                labelErrors.setText("Red must be in range 0 to 255.");
                return;
            }
        } catch (NumberFormatException g) {
            labelErrors.setText("Bad input for Red.");
            return;
        }
        try {
            green = Integer.parseInt(textGreen.getText());
            if (green < 0 || green >255) {
                labelErrors.setText("Green must be in range 0 to 255.");
                return;
            }
        } catch (NumberFormatException g) {
            labelErrors.setText("Bad input for Green.");
            return;
        }
        try {
            blue = Integer.parseInt(textBlue.getText());
            if (blue < 0 || blue > 255) {
                labelErrors.setText("Blue must be in range 0 to 255.");
                return;
            }
        } catch (NumberFormatException g) {
            labelErrors.setText("Bad input for Blue. ");
            return;
        }
        try {
            x = Integer.parseInt(textX.getText());
            if (x < 0 || x > 800) {
                labelErrors.setText("X must be in range 0 to 800.");
                return;
            }
        } catch (NumberFormatException g) {
            labelErrors.setText("Bad input for X. ");
            return;
        }
        try {
            y = Integer.parseInt(textY.getText());
            if (y < 0 || y > 420) {
                labelErrors.setText("Y must be in range 0 to 420.");
                return;
            }
        } catch (NumberFormatException g) {
            labelErrors.setText("Bad input for Y. ");
            return;
        }
        drawGC.setFill(Color.rgb(red, green, blue));
        drawGC.fillOval(x, y, radius, radius);
        labelErrors.setText("No Errors");
    }

    /**
     * Draws a line when mouse is dragged.
     * @param me MouseEvent of draggedHandler
     **/
    private void draggedHandler(MouseEvent me) {
        try {
            radius = Integer.parseInt(textRadius.getText());
            if (radius <= 0) {
                labelErrors.setText("Radius has to be greater than 0.");
                return;
            }
        } catch (NumberFormatException g) {
            labelErrors.setText("Bad input for Radius.");
            return;
        }
        try {
            red = Integer.parseInt(textRed.getText());
            if (red < 0 || red > 255) {
                labelErrors.setText("Red must be in range 0 to 255.");
                return;
            }
        } catch (NumberFormatException g) {
            labelErrors.setText("Bad input for Red.");
            return;
        }
        try {
            green = Integer.parseInt(textGreen.getText());
            if (green < 0 || green >255) {
                labelErrors.setText("Green must be in range 0 to 255.");
                return;
            }
        } catch (NumberFormatException g) {
            labelErrors.setText("Bad input for Green.");
            return;
        }
        try {
            blue = Integer.parseInt(textBlue.getText());
            if (blue < 0 || blue > 255) {
                labelErrors.setText("Blue must be in range 0 to 255.");
                return;
            }
        } catch (NumberFormatException g) {
            labelErrors.setText("Bad input for Blue. ");
            return;
        }
        drawGC.setStroke(Color.rgb(red, green, blue));
        drawGC.setLineWidth(radius);
        drawGC.setLineCap(StrokeLineCap.ROUND);
        drawGC.strokeLine(previousX, previousY, me.getX(), me.getY());
        previousX = me.getX();
        previousY = me.getY();
    }
    
    /**
     * Draws a circle when mouse pressed.
     * @param me MouseEvent of pressedHandler
     **/
    private void pressedHandler(MouseEvent me) { 
        try {
            radius = Integer.parseInt(textRadius.getText());
            if (radius <= 0) {
                labelErrors.setText("Radius has to be greater than 0.");
                return;
            }
        } catch (NumberFormatException g) {
            labelErrors.setText("Bad input for Radius.");
            return;
        }
        try {
            red = Integer.parseInt(textRed.getText());
            if (red < 0 || red > 255) {
                labelErrors.setText("Red must be in range 0 to 255.");
                return;
            }
        } catch (NumberFormatException g) {
            labelErrors.setText("Bad input for Red.");
            return;
        }
        try {
            green = Integer.parseInt(textGreen.getText());
            if (green < 0 || green >255) {
                labelErrors.setText("Green must be in range 0 to 255.");
                return;
            }
        } catch (NumberFormatException g) {
            labelErrors.setText("Bad input for Green.");
            return;
        }
        try {
            blue = Integer.parseInt(textBlue.getText());
            if (blue < 0 || blue > 255) {
                labelErrors.setText("Blue must be in range 0 to 255.");
                return;
            }
        } catch (NumberFormatException g) {
            labelErrors.setText("Bad input for Blue. ");
            return;
        }
        drawGC.setFill(Color.rgb(red, green, blue));
        drawGC.fillOval(me.getX() - 5, me.getY() - 5, radius, radius);
        previousX = me.getX();
        previousY = me.getY();        
    }

    /**
     * This is where you create your components and the model and add event
     * handlers.
     *
     * @param stage The main stage
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        Pane root = new Pane();
        Scene scene = new Scene(root, 800, 500); // set the size here
        stage.setTitle("Mouse Events"); // set the window title here
        stage.setScene(scene);

        // TODO: Add your GUI-building code here
        /**GUI building for labels**/
        labelLocation = new Label("Location:");
        labelRadius = new Label("Radius:");
        labelColour = new Label("Colour:");
        labelMessage = new Label("Press the Button or Click on the canvas");
        labelErrors = new Label("No Errors");
        /**GUI building for textfields**/
        textX = new TextField("0");
        textY = new TextField("0");
        textRadius = new TextField("20");
        textRed = new TextField("255");
        textGreen = new TextField("140");
        textBlue = new TextField("0");
        /**GUI building for button**/
        Button drawIt = new Button("Draw It!");

        // 1. Create the model
        // 2. Create the GUI components
        
        Canvas drawCanvas = new Canvas(800, 420);
        // 3. Add components to the root

        root.getChildren().addAll(labelLocation, labelRadius, labelColour, labelMessage, labelErrors,
                textX, textY, textRadius, textRed, textGreen, textBlue, drawIt, drawCanvas);

        // 4. Configure the components (colors, fonts, size, location)
      
        drawGC = drawCanvas.getGraphicsContext2D();        
        
        /**Label placements on window**/
        labelLocation.setLayoutY(420);
        labelRadius.setLayoutY(420);
        labelColour.setLayoutY(420);
        labelMessage.setLayoutY(480);
        labelErrors.setLayoutY(450);
        labelRadius.setLayoutX(210);
        labelColour.setLayoutX(330);
        
        /**Label size**/
        labelErrors.setPrefWidth(800);       
        labelMessage.setPrefWidth(800);

        /**Text field placements on window**/
        textX.setLayoutY(420);        
        textY.setLayoutY(420);
        textX.setLayoutX(65);
        textY.setLayoutX(135);
        textRadius.setLayoutY(420);
        textRed.setLayoutY(420);        
        textGreen.setLayoutY(420);        
        textBlue.setLayoutY(420);
        textRadius.setLayoutX(260);
        textRed.setLayoutX(380);
        textGreen.setLayoutX(450);
        textBlue.setLayoutX(520);
        
        /**Text field size**/
        textX.setPrefWidth(70);
        textY.setPrefWidth(70);
        textRadius.setPrefWidth(70);
        textRed.setPrefWidth(70);
        textGreen.setPrefWidth(70);
        textBlue.setPrefWidth(70);        
        
        drawIt.setLayoutY(420);        
        drawIt.setLayoutX(590);

        labelErrors.setStyle("-fx-background-color:lightgray;-fx-alignment:center;-fx-text-fill:green;");
        labelMessage.setStyle("-fx-alignment:center;-fx-background-color:lightblue;");
                      
        // 5. Add Event Handlers and do final setup
        drawCanvas.addEventHandler(MouseEvent.MOUSE_DRAGGED, this::draggedHandler);
        drawCanvas.addEventHandler(MouseEvent.MOUSE_PRESSED, this::pressedHandler);        
        drawIt.setOnAction(this::drawing);

        // 6. Show the stage
        stage.show();
    }

    /**
     * Make no changes here.
     *
     * @param args unused
     */
    public static void main(String[] args) {
        launch(args);
    }
}
