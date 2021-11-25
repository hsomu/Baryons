/*
 * HealthCareController$
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
package com.pega.hcms.controllers;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.validation.Validated;
import io.reactivex.Single;

import javax.validation.constraints.NotBlank;

/**
 * @author vagrant
 * @version HealthCareController$ 11/25/21
 */
@Controller("/api/hcms")
@Validated
public class HealthCareController {
    public static final String COPYRIGHT = "Copyright (c) 2021  Pegasystems Inc.";

    @Get(uri = "/citizen", produces = MediaType.TEXT_PLAIN)
    public Single<String> citizen() {
        return Single.just("Citizen info!");
    }

    @Get(uri = "/listVaccinationDrives", produces = MediaType.TEXT_PLAIN)
    public Single<String> listVaccinationDrives() {
        return Single.just("Vaccination drives info!");
    }

}
