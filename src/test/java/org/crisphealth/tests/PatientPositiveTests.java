package org.crisphealth.tests;

import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.crisphealth.base.BaseTest;
import org.crisphealth.base.Endpoints;
import org.crisphealth.helpers.PatientService;
import org.crisphealth.models.Patient;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class PatientPositiveTests extends BaseTest {


    @Test
    public void getAllPatientsAndValidateSchemaTest() {
        given()
                .contentType(ContentType.JSON)
                .when()
                .get(Endpoints.PATIENTS)
                .then()
                .statusCode(200)
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("patients-schema.json"))
                .log().all();
    }

    @Test
    public void getPatientByIdTest() {

        Patient testPatient = new Patient("111", "Jenn D.", "1934-06-01", "CA");

        Response response = PatientService.getPatientById(testPatient.getId());

        response
                .then()
                .statusCode(200)
                .body("size()", is(1))
                .body("[0].Id", is(testPatient.getId()))
                .body("[0].Name", is(testPatient.getName()))
                .body("[0].Address", is(testPatient.getAddress()))
                .body("[0].DateOfBirth", is(testPatient.getDateOfBirth()))
                .log().all();
    }

    @Test
    public void getPatientByAddressTest() {
        Patient testPatient = new Patient("222", "Jack", "1956-05-01", "MD");

        Response response = PatientService.getPatientByAddress(testPatient.getAddress());

        response.then()
                .statusCode(200)
                .body("size()", is(1))
                .body("[0].Id", is(testPatient.getId()))
                .body("[0].Name", is(testPatient.getName()))
                .body("[0].Address", is(testPatient.getAddress()))
                .body("[0].DateOfBirth", is(testPatient.getDateOfBirth()));
    }

    @Test
    public void getPatientByNameTest() {

        Patient testPatient = new Patient("333", "Bernard", "1966-04-01", "CA State");

        Response response = PatientService.getPatientByName(testPatient.getName());

        response.then()
                .statusCode(200)
                .body("size()", is(1))
                .body("[0].Id", is(testPatient.getId()))
                .body("[0].Name", is(testPatient.getName()))
                .body("[0].Address", is(testPatient.getAddress()))
                .body("[0].DateOfBirth", is(testPatient.getDateOfBirth()))
                .log().all();
    }

    @Test
    public void getPatientByDateOfBirthTest() {
        Patient testPatient = new Patient("333", "Bernard", "1966-04-01", "CA State");

        Response response = PatientService.getPatientByDOB(testPatient.getDateOfBirth());

        response.then()
                .statusCode(200)
                .body("size()", is(1))
                .body("[0].Id", is(testPatient.getId()))
                .body("[0].Name", is(testPatient.getName()))
                .body("[0].Address", is(testPatient.getAddress()))
                .body("[0].DateOfBirth", is(testPatient.getDateOfBirth()))
                .log().all();

    }

    @Test
    public void getPatientByMultipleParametersTest() {

        Patient testPatient = new Patient("222", "Jack", "1956-05-01", "MD");

        given()
                .contentType(ContentType.JSON)
                .queryParam("Id", testPatient.getId())
                .queryParam("Name", testPatient.getName())
                .queryParam("DateOfBirth", testPatient.getDateOfBirth())
                .when()
                .get(Endpoints.PATIENTS)
                .then()
                .statusCode(200)
                .body("size()", is(1))
                .body("[0].Id", is(testPatient.getId()))
                .body("[0].Name", is(testPatient.getName()))
                .body("[0].Address", is(testPatient.getAddress()))
                .body("[0].DateOfBirth", is(testPatient.getDateOfBirth()))
                .log().all();
    }

    @Test
    public void getPatientUsingIdAndNameTest() {

        Patient testPatient = new Patient("222", "Jack", "1956-05-01", "MD");

        given()
                .contentType(ContentType.JSON)
                .queryParam("Id", testPatient.getId())
                .queryParam("Name", testPatient.getName())
                .when()
                .get(Endpoints.PATIENTS)
                .then()
                .statusCode(200)
                .body("size()", is(1))
                .body("[0].Id", is(testPatient.getId()))
                .body("[0].Name", is(testPatient.getName()))
                .body("[0].Address", is(testPatient.getAddress()))
                .log().all();
    }

    @Test
    public void getPatientUsingIdAndAddressTest() {

        Patient testPatient = new Patient("222", "Jack", "1956-05-01", "MD");

        given()
                .contentType(ContentType.JSON)
                .queryParam("Id", testPatient.getId())
                .queryParam("Address", testPatient.getAddress())
                .when()
                .get(Endpoints.PATIENTS)
                .then()
                .statusCode(200)
                .body("size()", is(1))
                .body("[0].Id", is(testPatient.getId()))
                .body("[0].Name", is(testPatient.getName()))
                .body("[0].Address", is(testPatient.getAddress()))
                .body("[0].DateOfBirth", is(testPatient.getDateOfBirth()))
                .log().all();
    }

    @Test
    public void getPatientUsingIdAndDateOfBirthTest() {

        Patient testPatient = new Patient("222", "Jack", "1956-05-01", "MD");

        given()
                .contentType(ContentType.JSON)
                .queryParam("Id", testPatient.getId())
                .queryParam("DateOfBirth", testPatient.getDateOfBirth())
                .when()
                .get(Endpoints.PATIENTS)
                .then()
                .statusCode(200)
                .body("size()", is(1))
                .body("[0].Id", is(testPatient.getId()))
                .body("[0].Name", is(testPatient.getName()))
                .body("[0].Address", is(testPatient.getAddress()))
                .body("[0].DateOfBirth", is(testPatient.getDateOfBirth()))
                .log().all();
    }
}
