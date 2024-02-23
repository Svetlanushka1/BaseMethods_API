package api_restassured;


import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import dto.CarDTO;

import static com.jayway.restassured.RestAssured.given;

public class CarController extends BaseAPI {
    Response responseAddNewCar = null;
    Response responseDeleteCar = null;

    private Response getResponseAddNewCar(CarDTO addNewCarDTO, String token) {
        System.out.println("token from request add car " + token);
        responseAddNewCar = given()
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .body(addNewCarDTO)
                .when()
                .post(baseUrl + "/v1/cars")
                .thenReturn();
        return responseAddNewCar;
    }
    public Response requestNewCar(CarDTO carDTO, String token) {
        System.out.println("token from request add car " + token);
        return RestAssured.given()
                .header("Authorization", token)
                .body(carDTO)
                .contentType(ContentType.JSON)
                .when()
                .post("/v1/cars");
    }

    public Response requestNewCarWithWrongToken(CarDTO carDTO) {
        return RestAssured.given()
                .header("Authorization", "..")
                .contentType(ContentType.JSON)
                .when()
                .post("/v1/cars");
    }

    public String getMessageResponseAddNewCar(CarDTO carDTO, String token) {
        if(responseAddNewCar == null) {
            responseAddNewCar = getResponseAddNewCar(carDTO, token);
        }
        return responseAddNewCar.then().extract().path("message");
    }

    public int getStatusCodeResponseAddNewCar(CarDTO carDTO, String token) {
        if(responseAddNewCar == null) {
            responseAddNewCar = getResponseAddNewCar(carDTO, token);
        }
        return responseAddNewCar.getStatusCode();
    }

    public void setResponseAddNewCarNull() {
        responseAddNewCar = null;
    }

    //------------------------------------------------

    private Response getResponseDeleteCar(String serNumber, String token) {
        System.out.println("token from request Delete car " + token);
        responseDeleteCar = given()
                .header("Authorization", token)
                .when()
                .delete(baseUrl + "/v1/cars/" + serNumber)
                .thenReturn();
        return responseDeleteCar;
    }
    public Response requestDeleteCar(String serNumber, String token) {
        System.out.println("Delete car " + serNumber);
        return RestAssured.given()
                .header("Authorization", token)
                .contentType(ContentType.JSON)
                .when()
                .delete("/v1/cars/"+serNumber);

    }

    public int getStatusCodeDeleteCar(String serNumber, String token) {
        if(responseDeleteCar == null) {
            responseDeleteCar = getResponseDeleteCar(serNumber, token);
        }
        return responseDeleteCar.getStatusCode();
    }

    public String getMessageDeleteCar(String serNumber, String token) {
        if(responseDeleteCar == null) {
            responseDeleteCar = getResponseDeleteCar(serNumber, token);
        }
        return responseDeleteCar.then().extract().path("message");
    }


}
