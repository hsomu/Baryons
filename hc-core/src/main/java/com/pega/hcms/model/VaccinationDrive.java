/*
 * VaccinationDrive$
 *
 * Copyright (c) 2021  Pegasystems Inc.
 * All rights reserved.
 *
 * This  software  has  been  provided pursuant  to  a  License
 * Agreement  containing  restrictions on  its  use.   The  software
 * contains  valuable  trade secrets and proprietary information  of
 * Pegasystems Inc and is protected by  federal   copyright law.  It
 * may  not be copied,  modified,  translated or distributed in  any
 * form or medium,  disclosed to third parties or used in any manner
 * not provided for in  said  License Agreement except with  written
 * authorization from Pegasystems Inc.
 */
package com.pega.hcms.model;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author vagrant
 * @version VaccinationDrive$ 11/25/21
 */
@Entity
@Table(
        name="vaccinationdrive"
)
public class VaccinationDrive {

    @JsonCreator
    public VaccinationDrive(@JsonProperty("userid") Long userid,
                            @JsonProperty("vaccinename") String vaccinename,
                            @JsonProperty("startdate")Date startdate,
                            @JsonProperty("enddate")Date enddate,
                            @JsonProperty("hcprovidername") String hcprovidername) {
        this.userid = userid;
        this.vaccinename = vaccinename;
        this.startdate = startdate;
        this.enddate = enddate;
        this.hcprovidername = hcprovidername;
    }

    public VaccinationDrive() {
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonIgnore
    private Long id;

    @Column(name = "userid")
    private Long userid;

    @Column(name = "vaccinename")
    private String vaccinename;

    @Column(name = "startdate")
    private Date startdate;

    @Column(name = "enddate")
    private Date enddate;

    @Column(name = "hcprovidername")
    private String hcprovidername;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getVaccinename() {
        return vaccinename;
    }

    public void setVaccinename(String vaccinename) {
        this.vaccinename = vaccinename;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public String getHcprovidername() {
        return hcprovidername;
    }

    public void setHcprovidername(String hcprovidername) {
        this.hcprovidername = hcprovidername;
    }
}
