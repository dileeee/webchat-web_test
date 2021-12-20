package com.wechat.web.model;

/**
 * @author w29530
 * @date 2021/12/12
 * @desc 成员类
 */
public class Member {

	private String userName;

	private String englishName;

	private String acctId;

	private String phone;

	private String telephone;

	private String mail;

	private String address;

	private String title;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEnglishName() {
		return englishName;
	}

	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}

	public String getAcctId() {
		return acctId;
	}

	public void setAcctId(String acctId) {
		this.acctId = acctId;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Member{" +
				"userName='" + userName + '\'' +
				", englishName='" + englishName + '\'' +
				", acctId='" + acctId + '\'' +
				", phone='" + phone + '\'' +
				", telephone='" + telephone + '\'' +
				", mail='" + mail + '\'' +
				", address='" + address + '\'' +
				", title='" + title + '\'' +
				'}';
	}
}
