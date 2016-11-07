package au.com.equicord.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Class responsible for holding attributes from Contact's Object
 * 
 * @author Gustavo <gustavotavaresdias@gmail.com>
 */
@XmlRootElement
public class Contact {

	private int id;
	private String name;
	private int phone;
	private String address;
	private int postcode;
	private String email;
	private boolean clsPrivate;
	private int categoryId;
	private String categoryType;
	private String categoryDescription;
	private int periodId;
	private Date start;
	private Date end;
	private double price;
	private int searchId;
	private String googleId;
	private boolean paypal;
	private int cSNumber;
	private String cSName;
	private String cSuburb;
	private String cState;
	private String cCountry;
	private String cPicture;
	private int uID;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPostcode() {
		return postcode;
	}

	public void setPostcode(int postcode) {
		this.postcode = postcode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isClsPrivate() {
		return clsPrivate;
	}

	public void setClsPrivate(boolean clsPrivate) {
		this.clsPrivate = clsPrivate;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryType() {
		return categoryType;
	}

	public void setCategoryType(String categoryType) {
		this.categoryType = categoryType;
	}

	public String getCategoryDescription() {
		return categoryDescription;
	}

	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}

	public int getPeriodId() {
		return periodId;
	}

	public void setPeriodId(int periodId) {
		this.periodId = periodId;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getSearchId() {
		return searchId;
	}

	public void setSearchId(int searchId) {
		this.searchId = searchId;
	}

	public String getGoogleId() {
		return googleId;
	}

	public void setGoogleId(String googleId) {
		this.googleId = googleId;
	}

	public boolean isPaypal() {
		return paypal;
	}

	public void setPaypal(boolean paypal) {
		this.paypal = paypal;
	}

	public int getcSNumber() {
		return cSNumber;
	}

	public void setcSNumber(int cSNumber) {
		this.cSNumber = cSNumber;
	}

	public String getcSName() {
		return cSName;
	}

	public void setcSName(String cSName) {
		this.cSName = cSName;
	}

	public String getcSuburb() {
		return cSuburb;
	}

	public void setcSuburb(String cSuburb) {
		this.cSuburb = cSuburb;
	}

	public String getcState() {
		return cState;
	}

	public void setcState(String cState) {
		this.cState = cState;
	}

	public String getcCountry() {
		return cCountry;
	}

	public void setcCountry(String cCountry) {
		this.cCountry = cCountry;
	}

	public String getcPicture() {
		return cPicture;
	}

	public void setcPicture(String cPicture) {
		this.cPicture = cPicture;
	}

	public int getuID() {
		return uID;
	}

	public void setuID(int uID) {
		this.uID = uID;
	}
	
	@Override
	public String toString() {
		return "Contact [id=" + id + ", name=" + name + ", phone=" + phone
				+ ", address=" + address + ", postcode=" + postcode
				+ ", email=" + email + ", isPrivate=" + clsPrivate
				+ ", categoryId=" + categoryId + ", categoryType="
				+ categoryType + ", categoryDescription=" + categoryDescription
				+ ", periodId=" + periodId + ", start=" + start + ", end="
				+ end + ", price=" + price + ", searchId=" + searchId
				+ ", googleId=" + googleId + ", paypal=" + paypal
				+ ", cSNumber=" + cSNumber + ", cSName=" + cSName
				+ ", cSuburb=" + cSuburb + ", cState=" + cState + ", cCountry="
				+ cCountry + ", cPicture=" + cPicture + ", uID=" + uID + "]";
	}
}
