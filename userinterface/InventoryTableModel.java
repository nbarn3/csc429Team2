package userinterface;

import java.util.Vector;

import javafx.beans.property.SimpleStringProperty;

//==============================================================================
public class InventoryTableModel
{
	private final SimpleStringProperty barcode;
	private final SimpleStringProperty gender;
	private final SimpleStringProperty size;
	private final SimpleStringProperty articleType;
	private final SimpleStringProperty color1;
	private final SimpleStringProperty color2;
	private final SimpleStringProperty brand;
	private final SimpleStringProperty notes;
	private final SimpleStringProperty status;
	private final SimpleStringProperty donorLastName;
	private final SimpleStringProperty donorFirstName;
	private final SimpleStringProperty donorPhone;
	private final SimpleStringProperty donorEmail;
	private final SimpleStringProperty recevierNetid;
	private final SimpleStringProperty receiverLastName;
	private final SimpleStringProperty receiverFirstName;
	private final SimpleStringProperty dateDonated;
	private final SimpleStringProperty dateTaken;

	//----------------------------------------------------------------------------
	public InventoryTableModel(Vector<String> atData)
	{
		barcode =  new SimpleStringProperty(atData.elementAt(0));
		gender =  new SimpleStringProperty(atData.elementAt(1));
		size =  new SimpleStringProperty(atData.elementAt(2));
		articleType =  new SimpleStringProperty(atData.elementAt(3));
		color1 =  new SimpleStringProperty(atData.elementAt(4));
		color2 =  new SimpleStringProperty(atData.elementAt(5));
		brand =  new SimpleStringProperty(atData.elementAt(6));
		notes =  new SimpleStringProperty(atData.elementAt(7));
		status =  new SimpleStringProperty(atData.elementAt(8));
		donorLastName =  new SimpleStringProperty(atData.elementAt(9));
		donorFirstName =  new SimpleStringProperty(atData.elementAt(10));
		donorPhone =  new SimpleStringProperty(atData.elementAt(11));
		donorEmail =  new SimpleStringProperty(atData.elementAt(12));
		recevierNetid =  new SimpleStringProperty(atData.elementAt(13));
		receiverLastName =  new SimpleStringProperty(atData.elementAt(14));
		receiverFirstName =  new SimpleStringProperty(atData.elementAt(15));
		dateDonated =  new SimpleStringProperty(atData.elementAt(16));
		dateTaken =  new SimpleStringProperty(atData.elementAt(17));
	}

	//----------------------------------------------------------------------------
	public String getBarcode() {
		return barcode.get();
	}

	//----------------------------------------------------------------------------
	public void setBarcode(String pref) {
		barcode.set(pref);
	}

	public String getGender() {
		return gender.get();
	}

	//----------------------------------------------------------------------------
	public void setGender(String pref) {
		gender.set(pref);
	}

	public String getSize() {
		return size.get();
	}

	//----------------------------------------------------------------------------
	public void setSize(String pref) {
		size.set(pref);
	}

	public String getArticleType() {
		return articleType.get();
	}

	//----------------------------------------------------------------------------
	public void setArticleType(String pref) {
		articleType.set(pref);
	}

	public String getColor1() {
		return color1.get();
	}

	//----------------------------------------------------------------------------
	public void setColor1(String pref) {
		color1.set(pref);
	}

	//----------------------------------------------------------------------------
	public String getColor2() {
		return color2.get();
	}

	//----------------------------------------------------------------------------
	public void setColor2(String pref) {
		color2.set(pref);
	}

	public String getBrand() {
		return brand.get();
	}

	//----------------------------------------------------------------------------
	public void setBrand(String pref) {
		brand.set(pref);
	}

	public String getNotes() {
		return notes.get();
	}

	//----------------------------------------------------------------------------
	public void setNotes(String pref) {
		notes.set(pref);
	}

	public String getDonorLastName() {
		return donorLastName.get();
	}

	//----------------------------------------------------------------------------
	public void setDonorLastName(String pref) {
		donorLastName.set(pref);
	}

	public String getDonorFirstName() {
		return donorFirstName.get();
	}

	//----------------------------------------------------------------------------
	public void setDonorFirstName(String pref) {
		donorFirstName.set(pref);
	}

	//----------------------------------------------------------------------------
	public String getDonorPhone() {
		return donorPhone.get();
	}

	//----------------------------------------------------------------------------
	public void setDonorPhone(String pref) {
		donorPhone.set(pref);
	}

	public String getDonorEmail() {
		return donorEmail.get();
	}

	//----------------------------------------------------------------------------
	public void setDonorEmail(String pref) {
		donorEmail.set(pref);
	}

	public String getRecevierNetid() {
		return recevierNetid.get();
	}

	//----------------------------------------------------------------------------
	public void setRecevierNetid(String pref) {
		recevierNetid.set(pref);
	}

	public String getReceiverLastName() {
		return 	receiverLastName.get();
	}

	//----------------------------------------------------------------------------
	public void setReceiverLastName(String pref) {
		receiverLastName.set(pref);
	}

	public String getReceiverFirstName() {
		return receiverFirstName.get();
	}

	//----------------------------------------------------------------------------
	public void setReceiverFirstName(String pref) {
		receiverFirstName.set(pref);
	}

	public String getDateDonated() {
		return dateDonated.get();
	}

	//----------------------------------------------------------------------------
	public void setDateDonated(String pref) {
		dateDonated.set(pref);
	}

	public String getDateTaken() {
		return 	dateTaken.get();
	}

	//----------------------------------------------------------------------------
	public void setDateTaken(String pref) {
		dateTaken.set(pref);
	}

	public String getStatus() {
		return 	status.get();
	}

	//----------------------------------------------------------------------------
	public void setStatus(String pref) {
		status.set(pref);
	}
}