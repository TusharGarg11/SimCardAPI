package com.Verifone.SimCardAPI.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
public class SIMDetails {
    @Id
    private long SimCardNumber;
    private long mobileNumber;
    private String status;
    private boolean KYC;
    private String stateOfRegistration;
    private String telecomProvider;
    private String fullName;

    @JsonFormat(pattern = "yyyy-MM-dd",shape = JsonFormat.Shape.STRING)
    @JsonIgnore
    private String  expiryDate;

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getTelecomProvider() {
        return telecomProvider;
    }

    public void setTelecomProvider(String telecomProvider) {
        this.telecomProvider = telecomProvider;
    }

    public long getSimCardNumber() {
        return SimCardNumber;
    }

    public void setSimCardNumber(long simCardNumber) {
        SimCardNumber = simCardNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public boolean isKYC() {
        return KYC;
    }

    public void setKYC(boolean KYC) {
        this.KYC = KYC;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStateOfRegistration() {
        return stateOfRegistration;
    }

    public void setStateOfRegistration(String stateOfRegistration) {
        this.stateOfRegistration = stateOfRegistration;
    }

    public long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
}
