package org.crisphealth.tests;

import io.restassured.response.Response;
import org.crisphealth.helpers.PatientService;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.is;

public class PatientNegativeTests {

    @Test
    public void testNonExistingIdValue() {

        Response response = PatientService.getPatientById("899999999");

        response.then()
                .assertThat()
                .statusCode(200)
                .body("size()", is(0))
                .log().all();
    }

    @Test
    public void testNonNumericIdValue() {

        Response response = PatientService.getPatientById("ABC");

        response.then()
                .assertThat()
                .statusCode(200)
                .body("size()", is(0))
                .log().all();
    }

    @Test
    public void testNonExistingAddress() {

        Response response = PatientService.getPatientByAddress("123 Main St");

        response.then()
                .assertThat()
                .statusCode(200)
                .body("size()", is(0))
                .log().all();
    }

    @Test
    public void testLongAddress() {

        Response response = PatientService.getPatientByAddress("123 Main St This Is An Extremely Long Address That Should Not Be Valid");

        response.then()
                .assertThat()
                .statusCode(200)
                .body("size()", is(0))
                .log().all();
    }

    @Test
    public void testSpecialCharactersInAddress() {

        Response response = PatientService.getPatientByAddress("@#%&*!");

        response.then()
                .assertThat()
                .statusCode(200)
                .body("size()", is(0))
                .log().all();
    }


    @Test
    public void testNonExistingDOB() {

        Response response = PatientService.getPatientByDOB("9999-12-31");

        response.then()
                .assertThat()
                .statusCode(200)
                .body("size()", is(0))
                .log().all();
    }

    @Test
    public void testInvalidDobFormat() {

        Response response = PatientService.getPatientByDOB("01-31-2023");

        response.then()
                .assertThat()
                .statusCode(200)
                .body("size()", is(0))
                .log().all();
    }

    @Test
    public void testNonExistingName() {
        Response response = PatientService.getPatientByName("Spider");

        response.then()
                .assertThat()
                .statusCode(200)
                .body("size()", is(0))
                .log().all();
    }

    @Test
    public void testSpecialCharactersName() {
        Response response = PatientService.getPatientByName("@#%&*!");

        response.then()
                .assertThat()
                .statusCode(200)
                .body("size()", is(0))
                .log().all();
    }

}
