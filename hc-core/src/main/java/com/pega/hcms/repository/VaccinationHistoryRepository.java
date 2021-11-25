/*
 * VaccinationHistoryRepository$
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
package com.pega.hcms.repository;

import com.pega.hcms.model.VaccinationHistory;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

/**
 * @author vagrant
 * @version VaccinationHistoryRepository$ 11/25/21
 */
@Repository
public interface VaccinationHistoryRepository extends CrudRepository<VaccinationHistory, Long> {

}
