package au.com.equicord.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Class responsible for holding attributes from Horse Object
 * 
 * @author Gustavo <gustavotavaresdias@gmail.com>
 */
@XmlRootElement
public class Horse {

	private int hID;
	private String hName;
	private String hNickname;
	private String hDame;
	private String hSire;
	private String hBreed;
	private String hColour;
	private Date hDOB;
	private String hSex;
	private float hHeight;
	private String hMarksScars;
	private String hPicture;
	private String hMicrochip;
	private String hDietary;
	private int uID;

	public int gethID() {
		return hID;
	}

	public void sethID(int hID) {
		this.hID = hID;
	}

	public String gethName() {
		return hName;
	}

	public void sethName(String hName) {
		this.hName = hName;
	}

	public String gethNickname() {
		return hNickname;
	}

	public void sethNickname(String hNickname) {
		this.hNickname = hNickname;
	}

	public String gethDame() {
		return hDame;
	}

	public void sethDame(String hDame) {
		this.hDame = hDame;
	}

	public String gethSire() {
		return hSire;
	}

	public void sethSire(String hSire) {
		this.hSire = hSire;
	}

	public String gethBreed() {
		return hBreed;
	}

	public void sethBreed(String hBreed) {
		this.hBreed = hBreed;
	}

	public String gethColour() {
		return hColour;
	}

	public void sethColour(String hColour) {
		this.hColour = hColour;
	}

	public Date gethDOB() {
		return hDOB;
	}

	public void sethDOB(Date hDOB) {
		this.hDOB = hDOB;
	}

	public String gethSex() {
		return hSex;
	}

	public void sethSex(String hSex) {
		this.hSex = hSex;
	}

	public float gethHeight() {
		return hHeight;
	}

	public void sethHeight(float hHeight) {
		this.hHeight = hHeight;
	}

	public String gethMarksScars() {
		return hMarksScars;
	}

	public void sethMarksScars(String hMarksScars) {
		this.hMarksScars = hMarksScars;
	}

	public String gethPicture() {
		return hPicture;
	}

	public void sethPicture(String hPicture) {
		this.hPicture = hPicture;
	}

	public String gethMicrochip() {
		return hMicrochip;
	}

	public void sethMicrochip(String hMicrochip) {
		this.hMicrochip = hMicrochip;
	}

	public String gethDietary() {
		return hDietary;
	}

	public void sethDietary(String hDietary) {
		this.hDietary = hDietary;
	}

	public int getuID() {
		return uID;
	}

	public void setuID(int uID) {
		this.uID = uID;
	}
	
	@Override
	public String toString() {
		return "Horse [hID=" + hID + ", hName=" + hName + ", hNickname="
				+ hNickname + ", hDame=" + hDame + ", hSire=" + hSire
				+ ", hBreed=" + hBreed + ", hColour=" + hColour + ", hDOB="
				+ hDOB + ", hSex=" + hSex + ", hHeight=" + hHeight
				+ ", hMarksScars=" + hMarksScars + ", hPicture=" + hPicture
				+ ", hMicrochip=" + hMicrochip + ", hDietary=" + hDietary
				+ ", uID=" + uID + "]";
	}

}
