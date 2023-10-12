package org.crisphealth.base;

import io.restassured.RestAssured;
import org.crisphealth.utilities.ConfigReader;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = ConfigReader.getProperty("baseUrl");
    }
}
