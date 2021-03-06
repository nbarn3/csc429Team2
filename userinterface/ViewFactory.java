package userinterface;

import impresario.IModel;

//==============================================================================
public class ViewFactory {

	public static View createView(String viewName, IModel model)
	{
		if(viewName.equals("ReceptionistView") == true)
		{
			return new ReceptionistView(model);
		} 
		else if(viewName.equals("AddArticleTypeView") == true)
		{
			return new AddArticleTypeView(model);
		} 
		else if(viewName.equals("ModifyArticleTypeView") == true)
		{
			return new ModifyArticleTypeView(model);
		} 
		else if(viewName.equals("ArticleTypeCollectionView") == true)
		{
			return new ArticleTypeCollectionView(model);
		}
		else if(viewName.equals("SearchArticleTypeView") == true)
		{
			return new SearchArticleTypeView(model);
		}
		else if(viewName.equals("AddColorView") == true)
		{
			return new AddColorView(model);
		}
		else if(viewName.equals("ModifyColorView") == true)
		{
			return new ModifyColorView(model);
		}
		else if(viewName.equals("SearchColorView") == true)
		{
			return new SearchColorView(model);
		}
                else if(viewName.equals("ColorCollectionView") == true)
                {
                    return new ColorCollectionView(model);
                }
                else if(viewName.equals("AddClothingItemView") == true)
                {
                    return new AddClothingItemView(model);
                }
                else if(viewName.equals("ModifyClothingItemView") == true)
                {
                    return new ModifyClothingItemView(model);
                }
                else if(viewName.equals("RemoveClothingItemView") == true)
                {
                    return new RemoveClothingItemView(model);
                }
                else if(viewName.equals("InventoryCollectionView") == true)
                {
                    return new InventoryCollectionView(model);
                }
                else if(viewName.equals("SearchInventoryView") == true)
                {
                    return new SearchInventoryView(model);
                }
		else if(viewName.equals("ListInventoryAvailableView") == true)
		{
			return new AvailableInventoryView(model);
		}
                else if(viewName.equals("ClothingRequestPendingCollectionView") == true)
		{
			return new ClothingRequestPendingCollectionView(model);
		}
                else if(viewName.equals("MatchingInventoryView") == true)
		{
			return new MatchingInventoryView(model);
		}
                else if(viewName.equals("RemoveRequestCollectionView") == true)
                {
                    return new RemoveRequestCollectionView(model);
                }
                else if(viewName.equals("EnterRecepientInfoView") == true)
                {
                    return new EnterRecepientInfoView(model);
                }
		else if(viewName.equals("AddRequestView") == true)
                {
                    return new AddRequestView(model);
                }
                else if(viewName.equals("UntillDateReportView") == true)
                {
                    return new UntillDateReportView(model);
                }
                else if(viewName.equals("TopDonatorReportView") == true)
                {
                    return new TopDonatorReportView(model);
                }
		else
			return null;
	}
}
