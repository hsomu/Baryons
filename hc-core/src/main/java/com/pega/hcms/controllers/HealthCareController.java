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

import com.pega.hcms.model.AccessRole;
import com.pega.hcms.model.HCProvider;
import com.pega.hcms.model.UserInfo;
import com.pega.hcms.model.VaccinationDrive;
import com.pega.hcms.model.VaccinationHistory;
import com.pega.hcms.repository.HCProviderRepository;
import com.pega.hcms.repository.UserInfoRepository;
import com.pega.hcms.repository.VaccinationDriveRepository;
import com.pega.hcms.repository.VaccinationHistoryRepository;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Put;
import io.micronaut.validation.Validated;
import io.reactivex.Single;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import javax.inject.Inject;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * @author vagrant
 * @version HealthCareController$ 11/25/21
 */
@Controller("/api/hcms")
@Validated
public class HealthCareController {
    public static final String COPYRIGHT = "Copyright (c) 2021  Pegasystems Inc.";

    @Inject
    private UserInfoRepository userInfoRepository;

    @Inject
    private VaccinationHistoryRepository vaccinationHistoryRepository;

    @Inject
    private VaccinationDriveRepository vaccinationDriveRepository;

    @Inject
    private HCProviderRepository hcProviderRepository;

    @Get(uri = "/citizen", produces = MediaType.TEXT_PLAIN)
    public Single<String> citizen() {
        return Single.just("Citizen info!");
    }

    @Get(uri = "/listVaccinationDrives", produces = MediaType.TEXT_PLAIN)
    public Single<String> listVaccinationDrives() {
        return Single.just("Vaccination drives info!");
    }

    @Get(uri = "/addUser", produces = MediaType.TEXT_PLAIN)
    public Single<String> addUser() {
        UserInfo user1 = new UserInfo("John", "1234567890", "abc@test.com", "9956635822",
                AccessRole.CITIZEN.getAccessLevel());
        UserInfo user2 = new UserInfo("John2", "1234567891", "abc1@test.com", "9956635821",
                AccessRole.HCPROVIDER.getAccessLevel());

        userInfoRepository.saveAll(List.of(user1, user2));
        return Single.just("Saved user details!");
    }

    @Get(uri = "/getUsers", produces = MediaType.APPLICATION_JSON)
    public List<UserInfo> getUsers() {
       return StreamSupport.stream(userInfoRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Get(uri = "/findUserByAadhar/{aadhar}", produces = MediaType.APPLICATION_JSON)
    public Optional<UserInfo> findUserByAadhar(String aadhar) {
        try{
            return Optional.ofNullable(userInfoRepository.findByAadhar(aadhar));
        }catch(Exception e){
            return Optional.empty();
        }
    }

    @Get(uri = "/findUserByEmail/{email}", produces = MediaType.APPLICATION_JSON)
    public Optional<UserInfo> findUserByEmail(String email) {
        try{
            return Optional.ofNullable(userInfoRepository.findByEmail(email));
        }catch(Exception e){
            return Optional.empty();
        }
    }

    @Get(uri = "/findUserByMobile/{mobileNumber}", produces = MediaType.APPLICATION_JSON)
    public Optional<UserInfo> findUserByMobile(String mobileNumber) {
        try{
            return Optional.ofNullable(userInfoRepository.findByMobileNumber(mobileNumber));
        }catch(Exception e){
            return Optional.empty();
        }
    }

    @Operation(summary = "Creates VaccinationHistory",
            operationId = "addVaccinationHistory",
            description = "Creates VaccinationHistory",
            tags = {"cpsapi"},
            requestBody = @RequestBody(
                    description = "Vaccination data to be sent",
                    required = true,
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = VaccinationHistory.class)
                            )
                    }
            )
    )
    @ApiResponse(responseCode = "200", description = "successful operation",
            content = @Content(
                    mediaType = "application/text",
                    schema = @Schema(implementation = String.class)
            )
    )
    @Put(value = "addVaccinationHistory")
    public String addVaccinationHistory(@Parameter(description = "vaccinationHistory data to be sent") @Valid @Body VaccinationHistory vaccinationHistory) {
        vaccinationHistoryRepository.save(vaccinationHistory);
        return "Success";
    }

    @Get(uri = "/getVaccinationHistory", produces = MediaType.APPLICATION_JSON)
    public List<VaccinationHistory> getVaccinationHistory() {
        return StreamSupport.stream(vaccinationHistoryRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Operation(summary = "Creates VaccinationDrive",
            operationId = "addVaccinationDrive",
            description = "Creates VaccinationDrive",
            tags = {"cpsapi"},
            requestBody = @RequestBody(
                    description = "Vaccination drive data to be sent",
                    required = true,
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = VaccinationDrive.class)
                            )
                    }
            )
    )
    @ApiResponse(responseCode = "200", description = "successful operation",
            content = @Content(
                    mediaType = "application/text",
                    schema = @Schema(implementation = String.class)
            )
    )
    @Put(value = "addVaccinationDrive")
    public String addVaccinationDrive(@Parameter(description = "VaccinationDrive data to be sent") @Valid @Body VaccinationDrive vaccinationDrive) {

        if(findHCProvider(vaccinationDrive.getHcprovidername()).isEmpty()){
            return "Unknown healthCare provider: " + vaccinationDrive.getHcprovidername();
        }
        vaccinationDriveRepository.save(vaccinationDrive);
        return "Success";
    }

    @Get(uri = "/getVaccinationDrive", produces = MediaType.APPLICATION_JSON)
    public List<VaccinationDrive> getVaccinationDrive() {
        return StreamSupport.stream(vaccinationDriveRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Operation(summary = "Creates HCProvider",
            operationId = "addHCProvider",
            description = "Creates HCProvider",
            tags = {"cpsapi"},
            requestBody = @RequestBody(
                    description = "HCProvider data to be sent",
                    required = true,
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = HCProvider.class)
                            )
                    }
            )
    )
    @ApiResponse(responseCode = "200", description = "successful operation",
            content = @Content(
                    mediaType = "application/text",
                    schema = @Schema(implementation = String.class)
            )
    )
    @Put(value = "addHCProvider")
    public String addHCProvider(@Parameter(description = "HCProvider data to be sent") @Valid @Body HCProvider hcProvider) {
        hcProviderRepository.save(hcProvider);
        return "Success";
    }

    @Get(uri = "/getHCProvider", produces = MediaType.APPLICATION_JSON)
    public List<HCProvider> getHCProvider() {
        return StreamSupport.stream(hcProviderRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Get(uri = "/findHCProvider/{hcProviderName}", produces = MediaType.APPLICATION_JSON)
    public Optional<HCProvider> findHCProvider(String hcProviderName) {
        try{
            return Optional.ofNullable(hcProviderRepository.findByHcprovidername(hcProviderName));
        }catch(Exception e){
            return Optional.empty();
        }
    }

}
