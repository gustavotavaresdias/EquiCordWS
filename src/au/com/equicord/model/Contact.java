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
	private boolean isPrivate;
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

	public boolean isPrivate() {
		return isPrivate;
	}

	public void setPrivate(boolean isPrivate) {
		this.isPrivate = isPrivate;
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

	@Override
	public String toString() {
		return "Contact [id=" + id + ", name=" + name + ", phone=" + phone
				+ ", address=" + address + ", postcode=" + postcode
				+ ", email=" + email + ", isPrivate=" + isPrivate
				+ ", categoryId=" + categoryId + ", periodId=" + periodId
				+ ", start=" + start + ", end=" + end + ", price=" + price
				+ ", searchId=" + searchId + ", googleId=" + googleId
				+ ", paypal=" + paypal + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + categoryId;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((end == null) ? 0 : end.hashCode());
		result = prime * result
				+ ((googleId == null) ? 0 : googleId.hashCode());
		result = prime * result + id;
		result = prime * result + (isPrivate ? 1231 : 1237);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + (paypal ? 1231 : 1237);
		result = prime * result + periodId;
		result = prime * result + phone;
		result = prime * result + postcode;
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + searchId;
		result = prime * result + ((start == null) ? 0 : start.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contact other = (Contact) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (categoryId != other.categoryId)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (end == null) {
			if (other.end != null)
				return false;
		} else if (!end.equals(other.end))
			return false;
		if (googleId == null) {
			if (other.googleId != null)
				return false;
		} else if (!googleId.equals(other.googleId))
			return false;
		if (id != other.id)
			return false;
		if (isPrivate != other.isPrivate)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (paypal != other.paypal)
			return false;
		if (periodId != other.periodId)
			return false;
		if (phone != other.phone)
			return false;
		if (postcode != other.postcode)
			return false;
		if (Double.doubleToLongBits(price) != Double
				.doubleToLongBits(other.price))
			return false;
		if (searchId != other.searchId)
			return false;
		if (start == null) {
			if (other.start != null)
				return false;
		} else if (!start.equals(other.start))
			return false;
		return true;
	}

}
