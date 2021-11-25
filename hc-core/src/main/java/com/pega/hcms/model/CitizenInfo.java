/*
 * CitizenInfo$
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

import java.util.Objects;

/**
 * @author vagrant
 * @version CitizenInfo$ 11/25/21
 */
public class CitizenInfo {
    public static final String COPYRIGHT = "Copyright (c) 2021  Pegasystems Inc.";

    @JsonProperty("User")
    private UserInfo user;

    @JsonProperty("Location")
    private LocationInfo location;

    public UserInfo getUser() {
        return user;
    }

    public void setUser(UserInfo user) {
        this.user = user;
    }

    public LocationInfo getLocation() {
        return location;
    }

    public void setLocation(LocationInfo location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CitizenInfo that = (CitizenInfo) o;
        return user.equals(that.user) &&
                location.equals(that.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, location);
    }

    @Override
    public String toString() {
        return "CitizenInfo{" +
                "user=" + user +
                ", location=" + location +
                '}';
    }
}
