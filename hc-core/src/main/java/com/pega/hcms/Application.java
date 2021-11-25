/*
 * Copyright 2017 original authors
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 */
package com.pega.hcms;

import com.pega.hcms.model.HCProvider;
import com.pega.hcms.model.Vaccines;
import com.pega.hcms.repository.HCProviderRepository;
import com.pega.hcms.repository.VaccinesRepository;
import io.micronaut.runtime.Micronaut;

/**
 * @author Graeme Rocher
 * @since 1.0
 */
import io.micronaut.runtime.event.annotation.EventListener;
import io.micronaut.runtime.server.event.ServerStartupEvent;
import io.micronaut.scheduling.annotation.Async;
import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.info.*;
import io.swagger.v3.oas.annotations.tags.*;
import io.swagger.v3.oas.annotations.servers.*;
import io.swagger.v3.oas.annotations.security.*;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author graemerocher
 * @since 1.0
 */
@OpenAPIDefinition(
        info = @Info(
                title = "the title",
                version = "0.0",
                description = "My API",
                license = @License(name = "Apache 2.0", url = "http://foo.bar"),
                contact = @Contact(url = "http://gigantic-server.com", name = "Fred", email = "Fred@gigagantic-server.com")
        ),
        tags = {
                @Tag(name = "Tag 1", description = "desc 1", externalDocs = @ExternalDocumentation(description = "docs desc")),
                @Tag(name = "Tag 2", description = "desc 2", externalDocs = @ExternalDocumentation(description = "docs desc 2")),
                @Tag(name = "Tag 3")
        },
        externalDocs = @ExternalDocumentation(description = "definition docs desc"),
        security = {
                @SecurityRequirement(name = "req 1", scopes = {"a", "b"}),
                @SecurityRequirement(name = "req 2", scopes = {"b", "c"})
        },
        servers = {
                @Server(
                        description = "server 1",
                        url = "http://foo",
                        variables = {
                                @ServerVariable(name = "var1", description = "var 1", defaultValue = "1", allowableValues = {"1", "2"}),
                                @ServerVariable(name = "var2", description = "var 2", defaultValue = "1", allowableValues = {"1", "2"})
                        })
        }
)
@Singleton
public class Application {

    @Inject
    private VaccinesRepository vaccinesRepository;

    @Inject
    private HCProviderRepository hcProviderRepository;

    public static void main(String[] args) {
        Micronaut.run(Application.class);
    }


    @EventListener
    @Async
    public void onStartup(ServerStartupEvent event) {
        // setup vaccine data
        if(vaccinesRepository.count() < 1){
            vaccinesRepository.deleteAll();
            var vaccinesList = Map.of("BCG", "Tuberculosis", "Hep B", "Hepatitis B",
                            "Polio", "Poliovirus", "Covishield","Covid-19", "Covaxin","Covid-19" )
                    .entrySet()
                    .stream()
                    .map( e -> new Vaccines(e.getKey(), e.getValue()))
                    .collect(Collectors.toList());
            vaccinesRepository.saveAll(vaccinesList);
        }

        //setup hc providers
        if(hcProviderRepository.count() < 1){
            hcProviderRepository.deleteAll();
            var hcProviderData = Arrays.stream(new String[][]{
                            {"Apollo Banjara", "Banjara Hills", "Hyderabad"},
                            {"Apollo Secunderabad", "SP Road, Secunderabad", "Secunderabad"},
                            {"Apollo Somajiguda", "Somajiguda", "Hyderabad"},
                            {"Sunshine Secunderabad", "SP Road, Secunderabad", "Secunderabad"},
                            {"Rainbow Kharkhana", "Kharkhana", "Secunderabad"}})
                    .map(strings -> new HCProvider(strings[0],strings[1],strings[2]))
                    .collect(Collectors.toList());
            hcProviderRepository.saveAll(hcProviderData);
        }
    }
}
