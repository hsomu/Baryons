/*
 * AccessRole$
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

public enum AccessRole {
    CITIZEN(0, "Citizen"),
    HCPROVIDER(1,"HCProvider"),
    HEALTHMINISTRY(2,"healthministry");

    private int accessLevel;
    private String roleName;

    AccessRole(int accessLevel, String roleName) {
        this.accessLevel = accessLevel;
        this.roleName = roleName;
    }

    public int getAccessLevel() {
        return accessLevel;
    }

    public String getRoleName() {
        return roleName;
    }
    }

