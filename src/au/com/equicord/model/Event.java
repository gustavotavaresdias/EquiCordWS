package au.com.equicord.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Class responsible for holding attributes from Event Object
 * 
 * @author Gustavo <gustavotavaresdias@gmail.com>
 */
@XmlRootElement
public class Event {

	private int eID;
	private String eName;
	private String eAddress;
	private int ePostcode;
	private String eWeb;
	private int ePhone;
	private String eMail;
	private String ecName;
	private String ecAddress;
	private int ecPhone;
	private String ecEmail;
	private boolean elsPrivate;
	private int eTypeID;
	private String eType;
	private Date eDate;
	private int ePeriod;
	private Date eTime;
	private String eGoogleID;
	private int eSNumber;
	private String eSName;
	private String eSuburb;
	private String eState;
	private String eCountry;
	private String ePicture;
	private int uID;

	public int geteID() {
		return eID;
	}

	public void seteID(int eID) {
		this.eID = eID;
	}

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public String geteAddress() {
		return eAddress;
	}

	public void seteAddress(String eAddress) {
		this.eAddress = eAddress;
	}

	public int getePostcode() {
		return ePostcode;
	}

	public void setePostcode(int ePostcode) {
		this.ePostcode = ePostcode;
	}

	public String geteWeb() {
		return eWeb;
	}

	public void seteWeb(String eWeb) {
		this.eWeb = eWeb;
	}

	public int getePhone() {
		return ePhone;
	}

	public void setePhone(int ePhone) {
		this.ePhone = ePhone;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getEcName() {
		return ecName;
	}

	public void setEcName(String ecName) {
		this.ecName = ecName;
	}

	public String getEcAddress() {
		return ecAddress;
	}

	public void setEcAddress(String ecAddress) {
		this.ecAddress = ecAddress;
	}

	public int getEcPhone() {
		return ecPhone;
	}

	public void setEcPhone(int ecPhone) {
		this.ecPhone = ecPhone;
	}

	public String getEcEmail() {
		return ecEmail;
	}

	public void setEcEmail(String ecEmail) {
		this.ecEmail = ecEmail;
	}

	public boolean isElsPrivate() {
		return elsPrivate;
	}

	public void setElsPrivate(boolean elsPrivate) {
		this.elsPrivate = elsPrivate;
	}

	public int geteTypeID() {
		return eTypeID;
	}

	public void seteTypeID(int eTypeID) {
		this.eTypeID = eTypeID;
	}

	public String geteType() {
		return eType;
	}

	public void seteType(String eType) {
		this.eType = eType;
	}

	public Date geteDate() {
		return eDate;
	}

	public void seteDate(Date eDate) {
		this.eDate = eDate;
	}

	public int getePeriod() {
		return ePeriod;
	}

	public void setePeriod(int ePeriod) {
		this.ePeriod = ePeriod;
	}

	public Date geteTime() {
		return eTime;
	}

	public void seteTime(Date eTime) {
		this.eTime = eTime;
	}

	public String geteGoogleID() {
		return eGoogleID;
	}

	public void seteGoogleID(String eGoogleID) {
		this.eGoogleID = eGoogleID;
	}

	public int geteSNumber() {
		return eSNumber;
	}

	public void seteSNumber(int eSNumber) {
		this.eSNumber = eSNumber;
	}

	public String geteSName() {
		return eSName;
	}

	public void seteSName(String eSName) {
		this.eSName = eSName;
	}

	public String geteSuburb() {
		return eSuburb;
	}

	public void seteSuburb(String eSuburb) {
		this.eSuburb = eSuburb;
	}

	public String geteState() {
		return eState;
	}

	public void seteState(String eState) {
		this.eState = eState;
	}

	public String geteCountry() {
		return eCountry;
	}

	public void seteCountry(String eCountry) {
		this.eCountry = eCountry;
	}

	public String getePicture() {
		return ePicture;
	}

	public void setePicture(String ePicture) {
		this.ePicture = ePicture;
	}

	public int getuID() {
		return uID;
	}

	public void setuID(int uID) {
		this.uID = uID;
	}

	@Override
	public String toString() {
		return "Event [eID=" + eID + ", eName=" + eName + ", eAddress="
				+ eAddress + ", ePostcode=" + ePostcode + ", eWeb=" + eWeb
				+ ", ePhone=" + ePhone + ", eMail=" + eMail + ", ecName="
				+ ecName + ", ecAddress=" + ecAddress + ", ecPhone=" + ecPhone
				+ ", ecEmail=" + ecEmail + ", elsPrivate=" + elsPrivate
				+ ", eTypeID=" + eTypeID + ", eType=" + eType + ", eDate="
				+ eDate + ", ePeriod=" + ePeriod + ", eTime=" + eTime
				+ ", eGoogleID=" + eGoogleID + ", eSNumber=" + eSNumber
				+ ", eSName=" + eSName + ", eSuburb=" + eSuburb + ", eState="
				+ eState + ", eCountry=" + eCountry + ", ePicture=" + ePicture
				+ ", uID=" + uID + "]";
	}
}
