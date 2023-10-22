package com.springrest.springrest.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class OTP {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String mobileNumber;
	    private String otp;

	    public OTP(String mobileNumber, String otp) {
	        this.mobileNumber = mobileNumber;
	        this.otp = otp;
	    }

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

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

		@Override
		public String toString() {
			return "OTP [id=" + id + ", mobileNumber=" + mobileNumber + ", otp=" + otp + "]";
		}

		public OTP(Long id, String mobileNumber, String otp) {
			super();
			this.id = id;
			this.mobileNumber = mobileNumber;
			this.otp = otp;
		}

		public OTP() {
			super();
			// TODO Auto-generated constructor stub
		}

	    // getters and setters...
	    
	    
}

