package com.woniper.hibernate.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="member")
public class MemberDto implements Serializable {
	
	private static final long serialVersionUID = -8231034886383562071L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;
	private String memberId;
	private String password;
	private String memberName;
	private String phoneNumber;
	private String joinDate;
	private String companyName;
	private String address;
	private String email;
	private int delYn;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getDelYn() {
		return delYn;
	}
	public void setDelYn(int delYn) {
		this.delYn = delYn;
	}
	@Override
	public String toString() {
		return "MemberDto [id=" + id + ", memberId=" + memberId + ", password="
				+ password + ", memberName=" + memberName + ", phoneNumber="
				+ phoneNumber + ", joinDate=" + joinDate + ", companyName="
				+ companyName + ", address=" + address + ", email=" + email
				+ ", delYn=" + delYn + "]";
	}

}
