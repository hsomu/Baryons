/*
 * LocationInfo$
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

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.validation.Validated;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Objects;

/**
 * @author vagrant
 * @version LocationInfo$ 11/25/21
 */
@Schema(description = "The Location Info")
@Validated
public class LocationInfo {
    public static final String COPYRIGHT = "Copyright (c) 2021  Pegasystems Inc.";

    @JsonProperty("Address")
    private String address;

    @JsonProperty("City")
    private String city;

    @JsonProperty("State")
    private String state;

    @JsonProperty("Country")
    private String country;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LocationInfo that = (LocationInfo) o;
        return address.equals(that.address) &&
                city.equals(that.city) &&
                state.equals(that.state) &&
                country.equals(that.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address, city, state, country);
    }

    @Override
    public String toString() {
        return "LocationInfo{" +
                "address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
