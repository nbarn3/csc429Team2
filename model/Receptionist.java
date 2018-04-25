// specify the package
package model;

// system imports
import java.util.Hashtable;
import java.util.Properties;

import javafx.stage.Stage;
import javafx.scene.Scene;

// project imports
import impresario.IModel;
import impresario.ISlideShow;
import impresario.IView;
import impresario.ModelRegistry;

import exception.InvalidPrimaryKeyException;
import event.Event;
import userinterface.MainStageContainer;
import userinterface.View;
import userinterface.ViewFactory;
import userinterface.WindowPosition;

/** The class containing the Receptionist  for the ATM application */
//==============================================================
public class Receptionist implements IView, IModel
// This class implements all these interfaces (and does NOT extend 'EntityBase')
// because it does NOT play the role of accessing the back-end database tables.
// It only plays a front-end role. 'EntityBase' objects play both roles.
{
	// For Impresario
	private Properties dependencies;
	private ModelRegistry myRegistry;


	// GUI Components
        private ClothingRequestCollection requestsCanBeFulfilled;
	private Hashtable<String, Scene> myViews;
	private Stage myStage;

	private String transactionErrorMessage = "";

	// constructor for this class
	//----------------------------------------------------------
	public Receptionist()
	{
		myStage = MainStageContainer.getInstance();
		myViews = new Hashtable<String, Scene>();

		// STEP 3.1: Create the Registry object - if you inherit from
		// EntityBase, this is done for you. Otherwise, you do it yourself
		myRegistry = new ModelRegistry("Receptionist");
		if(myRegistry == null)
		{
			new Event(Event.getLeafLevelClassName(this), "Receptionist",
					"Could not instantiate Registry", Event.ERROR);
		}

		// STEP 3.2: Be sure to set the dependencies correctly
		setDependencies();

		// Set up the initial view
		createAndShowReceptionistView();
	}

	//-----------------------------------------------------------------------------------
	private void setDependencies()
	{
		dependencies = new Properties();
		//dependencies.setProperty("Login", "LoginError");


		myRegistry.setDependencies(dependencies);
	}

	/**
	 * Method called from client to get the value of a particular field
	 * held by the objects encapsulated by this object.
	 *
	 * @param	key	Name of database column (field) for which the client wants the value
	 *
	 * @return	Value associated with the field
	 */
	//----------------------------------------------------------
	public Object getState(String key)
	{
		if (key.equals("MatchingRequests") == true)
		{
                    findMatching();
                    return requestsCanBeFulfilled;
		}
		else
		return "";
	}

	//----------------------------------------------------------------
	public void stateChangeRequest(String key, Object value)
	{
		// STEP 4: Write the sCR method component for the key you
		// just set up dependencies for
		// DEBUG System.out.println("Receptionist.sCR: key = " + key);

		if (key.equals("CancelTransaction") == true)
		{
			createAndShowReceptionistView();
		}
		else
			if (key.equals("ExitSystem") == true)
			{
				System.exit(0);
			}	
			else
				if ((key.equals("AddArticleType") == true) || (key.equals("UpdateArticleType") == true) ||
						(key.equals("RemoveArticleType") == true) || (key.equals("AddColor") == true) ||
						(key.equals("UpdateColor") == true) || (key.equals("RemoveColor") == true) ||
						(key.equals("AddClothingItem") == true) || (key.equals("UpdateClothingItem") == true) ||
						(key.equals("RemoveClothingItem") == true) || (key.equals("CheckoutClothingItem") == true) ||
						(key.equals("AddRequest") == true) || (key.equals("FulfillRequest") == true) ||
						(key.equals("RemoveRequest") == true) || (key.equals("ListAvailableInventory") == true)
						)
				{
					String transType = key;

					transType = transType.trim();

					doTransaction(transType);
				}

		myRegistry.updateSubscribers(key, this);
	}

	/** Called via the IView relationship */
	//----------------------------------------------------------
	public void updateState(String key, Object value)
	{
		// DEBUG System.out.println("Receptionist.updateState: key: " + key);

		stateChangeRequest(key, value);
	}
        
        public void findMatching(){
            requestsCanBeFulfilled = new ClothingRequestCollection();
            requestsCanBeFulfilled.findMatchingIds();
        }
	/**
	 * Create a Transaction depending on the Transaction type (deposit,
	 * withdraw, transfer, etc.). Use the AccountHolder holder data to do the
	 * create.
	 */
	//----------------------------------------------------------
	public void doTransaction(String transactionType)
	{
		try
		{
			Transaction trans = TransactionFactory.createTransaction(
					transactionType);

			trans.subscribe("CancelTransaction", this);
			trans.stateChangeRequest("DoYourJob", "");
		}
		catch (Exception ex)
		{
			transactionErrorMessage = "FATAL ERROR: TRANSACTION FAILURE: Unrecognized transaction!!";
			new Event(Event.getLeafLevelClassName(this), "createTransaction",
					"Transaction Creation Failure: Unrecognized transaction " + ex.toString(),
					Event.ERROR);
		} 
	}


	//------------------------------------------------------------
	private void createAndShowReceptionistView()
	{
            // create our initial view
            View newView = ViewFactory.createView("ReceptionistView", this); // USE VIEW FACTORY
            Scene currentScene = new Scene(newView);

            swapToView(currentScene);

	}


	/** Register objects to receive state updates. */
	//----------------------------------------------------------
	public void subscribe(String key, IView subscriber)
	{
		// DEBUG: System.out.println("Cager[" + myTableName + "].subscribe");
		// forward to our registry
		myRegistry.subscribe(key, subscriber);
	}

	/** Unregister previously registered objects. */
	//----------------------------------------------------------
	public void unSubscribe(String key, IView subscriber)
	{
		// DEBUG: System.out.println("Cager.unSubscribe");
		// forward to our registry
		myRegistry.unSubscribe(key, subscriber);
	}

	//-----------------------------------------------------------------------------
	public void swapToView(Scene newScene)
	{		
		if (newScene == null)
		{
			System.out.println("Receptionist.swapToView(): Missing view for display");
			new Event(Event.getLeafLevelClassName(this), "swapToView",
					"Missing view for display ", Event.ERROR);
			return;
		}

		myStage.setScene(newScene);
		myStage.sizeToScene();


		//Place in center
		WindowPosition.placeCenter(myStage);
	}

}

