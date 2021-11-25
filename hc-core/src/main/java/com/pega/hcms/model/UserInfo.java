package com.pega.hcms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.util.Objects;

/**
 * @author vagrant
 * @version Operator$ 5/6/21
 */
@Entity
@Table(
        name="userinfo",
        uniqueConstraints=
        @UniqueConstraint(columnNames={"aadhar"})
)
public class UserInfo {

    public UserInfo() {
    }

    public UserInfo(String name, String aadhar, String email, String mobileNumber, int accessLevel) {
        this.name = name;
        this.aadhar = aadhar;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.accessLevel = accessLevel;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long userid;

    @Column(name = "name")
    private String name;

    @Column(name = "aadhar")
    private String aadhar;

    @Column(name = "email")
    private String email;

    @Column(name = "mobilenumber")
    private String mobileNumber;

    @Column(name = "accesslevel")
    private int accessLevel;


    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

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

    public int getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(int accessLevel) {
        this.accessLevel = accessLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserInfo userInfo = (UserInfo) o;
        return accessLevel == userInfo.accessLevel && Objects.equals(userid, userInfo.userid) && Objects.equals(name, userInfo.name) && Objects.equals(aadhar, userInfo.aadhar) && Objects.equals(email, userInfo.email) && Objects.equals(mobileNumber, userInfo.mobileNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userid, name, aadhar, email, mobileNumber, accessLevel);
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "userID=" + userid +
                ", name='" + name + '\'' +
                ", aadhar='" + aadhar + '\'' +
                ", email='" + email + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", accessLevel=" + accessLevel +
                '}';
    }
}