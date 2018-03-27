// specify the package
package userinterface;

// system imports
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

// project imports
import impresario.IModel;
import model.Gender;
import model.ArticleType;
import model.ColorX;

/**
 * The class containing the Remove Clothing Item View for the Professional Clothes
 * Closet application
 */
// ==============================================================
public class RemoveClothingItemView extends AddClothingItemView {

	// constructor for this class -- takes a model object
	//----------------------------------------------------------
	public RemoveClothingItemView(IModel ac)
	{
		super(ac);
	}

	//-------------------------------------------------------------
	protected String getActionText()
	{
		return "** REMOVING CLOTHING ITEM **";
	}

	//-------------------------------------------------------------
	public void populateFields()
	{
		String bar = (String)myModel.getState("Barcode");
		if (bar != null)
		{
			barcode.setText(bar);
		}
		String gen = (String)myModel.getState("Gender");
		if (gen != null)
		{
                    try{
                       gender.getSelectionModel().select(new Gender(gen));
                    }
                    catch(Exception e){
                            gender.getSelectionModel().select(null);
                    }
		}
                else
                    gender.getSelectionModel().select(null);
		String article = (String)myModel.getState("ArticleType");
		if (article != null)
		{
                    if(Integer.parseInt(article) < 10)
                        article = "0"+article;
                    try{
                      articleType.getSelectionModel().select(new ArticleType(article));
                    }
                    catch(Exception e){
                            articleType.getSelectionModel().select(null);
                    }
		}
                else
                    articleType.getSelectionModel().select(null);
		String col1 = (String)myModel.getState("Color1");
		if (col1 != null)
		{
                    if(Integer.parseInt(col1) < 10)
                        col1 = "0"+col1;
                    try{
                      color1.getSelectionModel().select(new ColorX(col1));
                    }
                    catch(Exception e){
                            color1.getSelectionModel().select(null);
                    }
		}
                else
                    color1.getSelectionModel().select(null);
		String col2 = (String)myModel.getState("Color2");
		if (col2 != null)
		{
                    if(Integer.parseInt(col2) < 10)
                        col2 = "0"+col2;
                    try{
                      color2.getSelectionModel().select(new ColorX(col2));
                    }
                    catch(Exception e){
                            color2.getSelectionModel().select(null);
                    }
		}
                else
                    color2.getSelectionModel().select(null);
		String sz = (String)myModel.getState("Size");
		if (sz != null)
		{
                    size.getSelectionModel().select(sz);
		}
                else
                    size.getSelectionModel().select(null);
		String brnd = (String)myModel.getState("Brand");
		if (brnd != null)
		{
			brand.setText(brnd);
		}
		String nts = (String)myModel.getState("Notes");
		if (nts != null)
		{
			notes.setText(nts);
		}
		String donorFirst = (String)myModel.getState("DonorFirstName");
		if (donorFirst != null)
		{
			donorFName.setText(donorFirst);
		}
		String donorLast = (String)myModel.getState("DonorLastName");
		if (donorLast != null)
		{
			donorLName.setText(donorLast);
		}
		String donorP = (String)myModel.getState("DonorPhone");
		if (donorP != null)
		{
			donorPhone.setText(donorP);
		}
		String donorMail = (String)myModel.getState("DonorEmail");
		if (donorMail != null)
		{
			donorEmail.setText(donorMail);
		}
                
                barcode.setDisable(true);
                gender.setDisable(true);
                articleType.setDisable(true);
                color1.setDisable(true);
                color2.setDisable(true);
                size.setDisable(true);
                brand.setDisable(true);
                notes.setDisable(true);
                donorFName.setDisable(true);
                donorLName.setDisable(true);
                donorPhone.setDisable(true);
                donorEmail.setDisable(true);
                actionText.setFill(Color.PALEVIOLETRED);
                
                prompt.setText("Clothing Item Information:");
                submitButton.setText("Remove"); //fix submitbutton
                ImageView icon = new ImageView(new Image("/images/trashcolor.png"));
                icon.setFitHeight(15);
                icon.setFitWidth(15);
                submitButton.setGraphic(icon);
	}
        
        public void clearValues(){
            
        }
}
