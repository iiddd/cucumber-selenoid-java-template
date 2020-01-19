package com.iiddd.base.utils;

import com.jayway.restassured.response.ValidatableResponse;
import com.jayway.restassured.specification.RequestSpecification;
import io.qameta.allure.Step;

import static com.jayway.restassured.RestAssured.given;

public class RestUtils {

    @Step
    public static ValidatableResponse delete(RequestSpecification request) {
        return given().log().all()
                .spec(request)
                .when()
                .delete()
                .then().log().all();
    }

    @Step
    public static ValidatableResponse post(RequestSpecification request) {
        return given().log().all()
                .spec(request)
                .when()
                .post()
                .then().log().all();
    }

    @Step
    public static ValidatableResponse put(RequestSpecification request) {
        return given().log().all()
                .spec(request)
                .when()
                .put()
                .then().log().all();
    }

    @Step
    public static ValidatableResponse get(RequestSpecification request) {
        return given().log().all()
                .spec(request)
                .when()
                .get()
                .then().log().all();
    }
}
