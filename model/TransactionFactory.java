// specify the package
package model;

// system imports
import java.util.Vector;


// project imports

/** The class containing the TransactionFactory for the Professional Clothes 
 *  Closet application 
 */
//==============================================================
public class TransactionFactory
{

	/**
	 *
	 */
	//----------------------------------------------------------
	public static Transaction createTransaction(String transType)
		throws Exception
	{
		Transaction retValue = null;

		if (transType.equals("AddArticleType") == true)
		{
			retValue = new AddArticleTypeTransaction();
		} 
		else
		if (transType.equals("UpdateArticleType") == true)
		{
			retValue = new UpdateArticleTypeTransaction();
		}
		else
		if(transType.equals("AddColor") == true)
		{
			retValue = new AddColorTransaction();
		}
		else
		if(transType.equals("UpdateColor") == true)
		{
			retValue = new UpdateColorTransaction();
		}
                else if(transType.equals("RemoveColor") == true){
                    retValue = new RemoveColorTransaction();
                }
                else
                if(transType.equals("ListAvailableInventory") == true){
                        retValue = new ListAvailableInventoryTransaction();
                    }
                else
                    if(transType.equals("RemoveArticleType") == true){
                        retValue = new RemoveArticleTypeTransaction();
                    }
                else
                    if(transType.equals("AddClothingItem") == true){
                        retValue = new AddClothingItemTransaction();
                    }
                /*
		else
		if (transType.equals("Transfer") == true)
		{
			retValue = new TransferTransaction(cust);
		}
		else
		if (transType.equals("BalanceInquiry") == true)
		{
			retValue = new BalanceInquiryTransaction(cust);
		}
		else
		if (transType.equals("ImposeServiceCharge") == true)
		{
			retValue = new ImposeServiceChargeTransaction(cust);
		} */

		return retValue;
	}
}
