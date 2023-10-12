package org.crisphealth.helpers;


import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.crisphealth.base.Endpoints;
import org.crisphealth.utilities.ConfigReader;

import static io.restassured.RestAssured.given;

public class PatientService {
    public static Response getPatientById(String id) {

        return given()
                .baseUri(ConfigReader.getBaseUrl())
                .contentType(ContentType.JSON)
                .queryParam("Id", id)
                .when()
                .get(Endpoints.PATIENTS)
                .then()
                .extract().response();
    }

    public static Response getPatientByName(String name) {
        return given()
                .baseUri(ConfigReader.getBaseUrl())
                .contentType(ContentType.JSON)
                .queryParam("Name", name)
                .when()
                .get(Endpoints.PATIENTS)
                .then()
                .extract().response();
    }

    public static Response getPatientByDOB(String dateOfBirth) {
        return given()
                .baseUri(ConfigReader.getBaseUrl())
                .contentType(ContentType.JSON)
                .queryParam("DateOfBirth", dateOfBirth)
                .when()
                .get(Endpoints.PATIENTS)
                .then()
                .extract().response();
    }

    public static Response getPatientByAddress(String address) {
        return given()
                .baseUri(ConfigReader.getBaseUrl())
                .contentType(ContentType.JSON)
                .queryParam("Address", address)
                .when()
                .get(Endpoints.PATIENTS)
                .then()
                .extract().response();
    }
}
