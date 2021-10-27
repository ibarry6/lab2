import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * This panel is the basic panel, inside which other panels are placed.  
 * Before beginning to implement, design the structure of your GUI in order to 
 * understand what panels go inside which ones, and what buttons or other components
 * go in which panels.  
 * @author ralexander
 *
 */
//make the main panel's layout be a VBox
public class FXMainPane extends VBox {

	//student Task #2:
	//  declare five buttons, a label, and a textfield
	//  declare two HBoxes
	private Button Button1, Button2, Button3,Button4, Button5;
	private TextField Textfield;
	private Label Label;
	HBox topBox,bottomBox;
	
	//student Task #4:
	//  declare an instance of DataManager
	DataManager DataManager=new DataManager();
	/**
	 * The MainPanel constructor sets up the entire GUI in this approach.  Remember to
	 * wait to add a component to its containing component until the container has
	 * been created.  This is the only constraint on the order in which the following 
	 * statements appear.
	 */
	FXMainPane() {
		//student Task #2:
		//  instantiate the buttons, label, and textfield
	    //  instantiate the HBoxes
		Button1=new Button("Hello");
		Button2=new Button("Howdy");
		Button3=new Button("Chinese");
		Button4=new Button("Clear");
		Button5=new Button("Exit");
		
		Label=new Label("Feedback");
		
		Textfield=new TextField();
		
		topBox= new HBox();
		bottomBox=new HBox();
		
		
		//student Task #4:
		//  instantiate the DataManager instance
		//  set margins and set alignment of the components
		DataManager DataManager=new DataManager();
		 
		Button1.setOnAction(new ButtonHandler());
		Button2.setOnAction(new ButtonHandler());
		Button3.setOnAction(new ButtonHandler());
		Button4.setOnAction(new ButtonHandler());
		Button5.setOnAction(new ButtonHandler());
		
		Insets inset = new Insets(10);
		topBox.setAlignment(Pos.CENTER);
		bottomBox.setMargin(Button1,inset);
		bottomBox.setMargin(Button2, inset);
		bottomBox.setMargin(Button3, inset);
		//System.out.println("");
		bottomBox.setMargin(Button4, inset);
		bottomBox.setMargin(Button5, inset);
		
		
		//student Task #3:
		//  add the label and textfield to one of the HBoxes
		topBox.getChildren().addAll(Label,Textfield);
		//  add the buttons to the other HBox
		bottomBox.getChildren().addAll(Button1,Button2,Button3,Button4, Button5);
		//  add the HBoxes to this FXMainPanel (a VBox)
		getChildren().addAll(topBox,bottomBox);
		
		
		
	}

	//Task #4:
	//  create a private inner class to handle the button clicks
	 class ButtonHandler implements EventHandler<ActionEvent>{

		@Override
		public void handle(ActionEvent event) {
			// TODO Auto-generated method stub
			Object handle=event.getTarget();
			
			if (handle==Button1) {
				Textfield.setText(DataManager.getHello());
			}
			else if (handle==Button2) {Textfield.setText(DataManager.getHowdy());}
			else if (handle==Button3) {Textfield.setText(DataManager.getChinese());}
			else if (handle==Button4) {Textfield.setText("");}
			else if (handle==Button5) {
				Platform.exit();
				System.exit(0);
			}
			
		}
		
		
	}
}
	