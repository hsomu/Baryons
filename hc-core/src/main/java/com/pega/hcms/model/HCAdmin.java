/*
 * HCAdmin$
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
 * @version HCAdmin$ 11/25/21
 */
public class HCAdmin {
    public static final String COPYRIGHT = "Copyright (c) 2021  Pegasystems Inc.";

    @JsonProperty("User")
    private UserInfo user;

    @JsonProperty("HealthCareProvider")
    private HealthCareProvider healthCareProvider;

    public UserInfo getUser() {
        return user;
    }

    public void setUser(UserInfo user) {
        this.user = user;
    }

    public HealthCareProvider getHealthCareProvider() {
        return healthCareProvider;
    }

    public void setHealthCareProvider(HealthCareProvider healthCareProvider) {
        this.healthCareProvider = healthCareProvider;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HCAdmin hcAdmin = (HCAdmin) o;
        return user.equals(hcAdmin.user) &&
                healthCareProvider.equals(hcAdmin.healthCareProvider);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, healthCareProvider);
    }

    @Override
    public String toString() {
        return "HCAdmin{" +
                "user=" + user +
                ", healthCareProvider=" + healthCareProvider +
                '}';
    }
}
