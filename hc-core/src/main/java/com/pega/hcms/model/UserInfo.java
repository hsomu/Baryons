package com.pega.hcms.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.validation.Validated;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Objects;

/**
 * @author vagrant
 * @version Operator$ 5/6/21
 */
@Schema(description = "The User Info")
@Validated
public class UserInfo {
    public static final String COPYRIGHT = "Copyright (c) 2021  Pegasystems Inc.";

    @JsonProperty("Name")
    private String name;

    @JsonProperty("Aadhar")
    private String aadhar;

    @JsonProperty("Email")
    private String email;

    @JsonProperty("MobileNumber")
    private String mobileNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAadhar() {
        return aadhar;
    }

    public void setAadhar(String aadhar) {
        this.aadhar = aadhar;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserInfo userInfo = (UserInfo) o;
        return name.equals(userInfo.name) &&
                aadhar.equals(userInfo.aadhar) &&
                email.equals(userInfo.email) &&
                mobileNumber.equals(userInfo.mobileNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, aadhar, email, mobileNumber);
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "name='" + name + '\'' +
                ", aadhar='" + aadhar + '\'' +
                ", email='" + email + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                '}';
    }
}