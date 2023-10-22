package com.springrest.springrest.model;



import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import jakarta.persistence.Column;
import jakarta.persistence.Table;



@Entity
@Table(name = "otpdetails")
public class OTPDetails {
    @Id
    @Column(name = "mobileNumber")
    private String mobileNumber;
    
    @Column(name = "otp")
    private String otp;
    
    @Column(name = "misc1")
    private String misc1;
    @Column(name = "sourceId")
    private String sourceId = "51";
    @Column(name = "identifier")
    private String identifier;
    @Column(name = "templateId")
    private String templateId = "1352";
    
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	public String getMisc1() {
		return misc1;
	}
	public void setMisc1(String misc1) {
		this.misc1 = misc1;
	}
	public String getSourceId() {
		return sourceId;
	}
	public void setSourceId(String sourceId) {
		this.sourceId = sourceId;
	}
	public String getIdentifier() {
		return identifier;
	}
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	public String getTemplateId() {
		return templateId;
	}
	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}
	@Override
	public String toString() {
		return "OTPDetails [mobileNumber=" + mobileNumber + ", otp=" + otp + ", misc1=" + misc1 + ", sourceId="
				+ sourceId + ", identifier=" + identifier + ", templateId=" + templateId + "]";
	}
	public OTPDetails(String mobileNumber, String otp, String misc1, String sourceId, String identifier,
			String templateId) {
		super();
		this.mobileNumber = mobileNumber;
		this.otp = otp;
		this.misc1 = misc1;
		this.sourceId = sourceId;
		this.identifier = identifier;
		this.templateId = templateId;
	}
	public OTPDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    // getters and setters...
    
    
}
