package com.springrest.springrest.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springrest.springrest.model.OTPDetails;
import com.springrest.springrest.repository.OTPDetailsRepository;

import org.json.JSONArray;
import org.json.JSONObject;

@Service
public class OTPService {

    @Autowired
    private OTPDetailsRepository otpDetailsRepository;

    public String generateOTP(String mobileNumber) {
        Random rand = new Random();
        String otp = String.format("%04d", rand.nextInt(10000)); // Generate a 4 digit OTP
        String misc1 = String.format("%04d", rand.nextInt(10000)); // Generate a unique MISC1

        JSONObject metaData = new JSONObject();
        metaData.put("MISC1", misc1);

        JSONObject templateData = new JSONObject();
        templateData.put("OTP", otp);

        JSONObject transportType = new JSONObject();
        transportType.put("SourceId", "51");
        transportType.put("InteractionId", "SENDING_OTP");
        transportType.put("Identifier", misc1);
        transportType.put("TemplateId", "1352");

        JSONObject addressTo = new JSONObject();
        addressTo.put("SMSMobileNumber", mobileNumber);
        addressTo.put("EmailTo", "joy.abilash@newgensoft.com");
        addressTo.put("EmailCc", "");
        addressTo.put("EmailBcc", new JSONArray());
        addressTo.put("EmailFrom", "");

        JSONObject response = new JSONObject();
        response.put("MetaData", metaData);
        response.put("Templatedata", templateData);
        response.put("TransportType", transportType);
        response.put("AddressTo", addressTo);

        // Create an OTPDetails object and save it in the database
        OTPDetails otpDetails = new OTPDetails();
        otpDetails.setMobileNumber(mobileNumber);
        otpDetails.setOtp(otp);
        otpDetails.setMisc1(misc1);
        otpDetails.setSourceId("51");
        otpDetails.setIdentifier(misc1);
        otpDetails.setTemplateId("1352");
        
        otpDetailsRepository.save(otpDetails);

        return response.toString();
    }
}
