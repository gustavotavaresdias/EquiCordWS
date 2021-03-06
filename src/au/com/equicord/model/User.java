package au.com.equicord.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Class responsible for holding attributes from User Object
 * 
 * @author Gustavo <gustavotavaresdias@gmail.com>
 */
@XmlRootElement
public class User {

	private int uID;
	private String uName;
	private int uPhone;
	private String uAddress;
	private String uEmail;
	private int uPostcode;
	private int uPasscode;
	private String uGoogleID;
	private String uPassword;
	private String uStreet;
	private String uSuburb;
	private String uTown;
	private String uCountry;
	private int uEmailConfirm;
	private int uConfirmation;
	

	public User() {
		this.uName = "";
		this.uAddress = "";
		this.uEmail = "";
		this.uGoogleID = "";
		this.uPassword = "";
		this.uStreet = "";
		this.uSuburb = "";
		this.uTown = "";
		this.uCountry = "";
	}


	public int getuID() {
		return uID;
	}

	public void setuID(int uID) {
		this.uID = uID;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public int getuPhone() {
		return uPhone;
	}

	public void setuPhone(int uPhone) {
		this.uPhone = uPhone;
	}

	public String getuAddress() {
		return uAddress;
	}

	public void setuAddress(String uAddress) {
		this.uAddress = uAddress;
	}

	public String getuEmail() {
		return uEmail;
	}

	public void setuEmail(String uEmail) {
		this.uEmail = uEmail;
	}

	public int getuPostcode() {
		return uPostcode;
	}

	public void setuPostcode(int uPostcode) {
		this.uPostcode = uPostcode;
	}

	public int getuPasscode() {
		return uPasscode;
	}

	public void setuPasscode(int uPasscode) {
		this.uPasscode = uPasscode;
	}

	public String getuGoogleID() {
		return uGoogleID;
	}

	public void setuGoogleID(String uGoogleID) {
		this.uGoogleID = uGoogleID;
	}
	
	public String getuPassword() {
		return uPassword;
	}

	public void setuPassword(String uPassword) {
		this.uPassword = uPassword;
	}

	public String getuStreet() {
		return uStreet;
	}

	public void setuStreet(String uStreet) {
		this.uStreet = uStreet;
	}

	public String getuSuburb() {
		return uSuburb;
	}

	public void setuSuburb(String uSuburb) {
		this.uSuburb = uSuburb;
	}

	public String getuTown() {
		return uTown;
	}

	public void setuTown(String uTown) {
		this.uTown = uTown;
	}

	public String getuCountry() {
		return uCountry;
	}

	public void setuCountry(String uCountry) {
		this.uCountry = uCountry;
	}

	public int getuEmailConfirm() {
		return uEmailConfirm;
	}


	public void setuEmailConfirm(int uEmailConfirm) {
		this.uEmailConfirm = uEmailConfirm;
	}


	public int getuConfirmation() {
		return uConfirmation;
	}


	public void setuConfirmation(int uConfirmation) {
		this.uConfirmation = uConfirmation;
	}


	@Override
	public String toString() {
		return "User [uID=" + uID + ", uName=" + uName + ", uPhone=" + uPhone + ", uAddress=" + uAddress + ", uEmail="
				+ uEmail + ", uPostcode=" + uPostcode + ", uPasscode=" + uPasscode + ", uGoogleID=" + uGoogleID
				+ ", uPassword=" + uPassword + ", uStreet=" + uStreet + ", uSuburb=" + uSuburb + ", uTown=" + uTown
				+ ", uCountry=" + uCountry + ", uEmailConfirm=" + uEmailConfirm + ", uConfirmation=" + uConfirmation +"]";
	}


	
	
	

}
