// tag::comment[]
/*******************************************************************************
 * Copyright (c) 2017, 2020 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
 // end::comment[]
package it.io.openliberty.guides.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import javax.json.JsonObject;
import javax.json.JsonArray;
import javax.json.Json;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import javax.ws.rs.client.Entity;

import org.apache.cxf.jaxrs.provider.jsrjsonp.JsrJsonpProvider;

public class EndpointIT {

    @Test
    public void testGetProperties() {
        // tag::systemProperties[]
        String port = System.getProperty("liberty.test.port");
        String url = "http://localhost:" + port + "/";
        // end::systemProperties[]

        // tag::clientSetup[]
        Client client = ClientBuilder.newClient();
        client.register(JsrJsonpProvider.class);
        // end::clientSetup[]

        // tag::request[]
        WebTarget target = client.target(url + "system/properties-new");
        Response response = target.request().get();
        // end::request[]

        // tag::response[]
        assertEquals(200, response.getStatus(), "Incorrect response code from " + url);
        // end::response[]

        // tag::body[]
        JsonObject obj = response.readEntity(JsonObject.class);

        assertEquals("/opt/ol/wlp/output/defaultServer/", obj.getString("server.output.dir"),
                    "The system property for the server output directory should match the Open Liberty container image.");
        // end::body[]
        response.close();
    }
}
