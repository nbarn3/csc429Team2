// specify the package
package userinterface;

// system imports
import javafx.event.Event;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.util.Properties;

// project imports
import impresario.IModel;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/** The class containing the Modify Color View  for the Professional Clothes
 *  Closet application 
 */
//==============================================================
public class ModifyColorView extends AddColorView
{

	//

	// constructor for this class -- takes a model object
	//----------------------------------------------------------
	public ModifyColorView(IModel cr)
	{
		super(cr);
	}

	//-------------------------------------------------------------
	protected String getActionText()	
	{
		return "** MODIFYING COLOR **";
	}

	//-------------------------------------------------------------
	public void populateFields()
	{
		String bcPrefix = (String)myModel.getState("BarcodePrefix");
		if (bcPrefix != null)
		{
			barcodePrefix.setText(bcPrefix);
		}
		String desc = (String)myModel.getState("Description");
		if (desc != null)
		{
			description.setText(desc);
		}
		String alfaC = (String)myModel.getState("AlphaCode");
		if (alfaC != null)
		{
			alphaCode.setText(alfaC);
		}
                
                submitButton.setText("Save"); //fix submitbutton
                ImageView icon = new ImageView(new Image("/images/savecolor.png"));
                icon.setFitHeight(15);
                icon.setFitWidth(15);
                submitButton.setGraphic(icon);
	}

}

//---------------------------------------------------------------
//	Revision History:
//


