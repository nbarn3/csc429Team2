// specify the package
package model;

// system imports
import javafx.stage.Stage;
import javafx.scene.Scene;
import java.util.Properties;
import java.util.Vector;

// project imports
import event.Event;
import exception.InvalidPrimaryKeyException;
import exception.MultiplePrimaryKeysException;

import userinterface.View;
import userinterface.ViewFactory;

/** The class containing the AddColorTransaction for the Professional Clothes Closet application */
//==============================================================
public class AddColorTransaction extends Transaction
{

	private ColorX myColor;
	

	// GUI Components

	private String transactionErrorMessage = "";

	/**
	 * Constructor for this class.
	 *
	 */
	//----------------------------------------------------------
	public AddColorTransaction() throws Exception
	{
		super();
	}

	//----------------------------------------------------------
	protected void setDependencies()
	{
		dependencies = new Properties();
		dependencies.setProperty("CancelAddC", "CancelTransaction");
		dependencies.setProperty("OK", "CancelTransaction");
		dependencies.setProperty("ColorData", "TransactionError");

		myRegistry.setDependencies(dependencies);
	}

	/**
	 * This method encapsulates all the logic of creating the color,
	 * verifying its uniqueness, etc.
	 */
	//----------------------------------------------------------
	public void processTransaction(Properties props)
	{
		if (props.getProperty("BarcodePrefix") != null)
		{
			String barcodePrefix = props.getProperty("BarcodePrefix");
			try
			{

				ColorX oldColor = new ColorX(barcodePrefix);
				transactionErrorMessage = "ERROR: Barcode Prefix " + barcodePrefix 
					+ " already exists!";
				new Event(Event.getLeafLevelClassName(this), "processTransaction",
						"Color with barcode prefix : " + barcodePrefix + " already exists!",
						Event.ERROR);
			}
			catch (InvalidPrimaryKeyException ex)
			{
				// Barcode prefix does not exist, validate data
				try
				{
					int barcodePrefixVal = Integer.parseInt(barcodePrefix);
					String descriptionOfAT = props.getProperty("Description");
					if (descriptionOfAT.length() > 30)
					{
						transactionErrorMessage = "ERROR: Color Description too long! ";
					}
					else
					{
						String alphaCode = props.getProperty("AlphaCode");
						if (alphaCode.length() > 5)
						{
							transactionErrorMessage = "ERROR: Alpha code too long (max length = 5)! ";
						}
						else
						{
								props.setProperty("Status", "Active");
								myColor = new ColorX(props);
								myColor.update();
								transactionErrorMessage = (String)myColor.getState("UpdateStatusMessage");
						}
					}
				}
				catch (Exception excep)
				{
					transactionErrorMessage = "ERROR: Invalid barcode prefix: " + barcodePrefix 
						+ "! Must be numerical.";
					new Event(Event.getLeafLevelClassName(this), "processTransaction",
						"Invalid barcode prefix : " + barcodePrefix + "! Must be numerical.",
						Event.ERROR);
				}

			}
			catch (MultiplePrimaryKeysException ex2)
			{
				transactionErrorMessage = "ERROR: Multiple colors with barcode prefix!";
				new Event(Event.getLeafLevelClassName(this), "processTransaction",
					"Found multiple colors with barcode prefix : " + barcodePrefix + ". Reason: " + ex2.toString(),
					Event.ERROR);

			}
		}
		
	}

	//-----------------------------------------------------------
	public Object getState(String key)
	{
		if (key.equals("TransactionError") == true)
		{
			return transactionErrorMessage;
		}
		
		
		return null;
	}

	//-----------------------------------------------------------
	public void stateChangeRequest(String key, Object value)
	{
		// DEBUG System.out.println("AddArticleTypeTransaction.sCR: key: " + key);

		if (key.equals("DoYourJob") == true)
		{
			doYourJob();
		}
		else
		if (key.equals("ColorData") == true)
		{
			processTransaction((Properties)value);
		}

		myRegistry.updateSubscribers(key, this);
	}

	/**
	 * Create the view of this class. And then the super-class calls
	 * swapToView() to display the view in the frame
	 */
	//------------------------------------------------------
	protected Scene createView()
	{
		Scene currentScene = myViews.get("AddColorView");

		if (currentScene == null)
		{
			// create our initial view
			View newView = ViewFactory.createView("AddColorView", this);
			currentScene = new Scene(newView);
			myViews.put("AddColorView", currentScene);

			return currentScene;
		}
		else
		{
			return currentScene;
		}
	}

}

