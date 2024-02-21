package api;


import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import dto.AddNewCarDTO;

import static com.jayway.restassured.RestAssured.given;

public class CarsAPI extends BaseAPI {
    Response responseAddNewCar = null;
    Response responseDeleteCar = null;

    private Response getResponseAddNewCar(AddNewCarDTO addNewCarDTO, String token) {
        responseAddNewCar = given()
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .body(addNewCarDTO)
                .when()
                .post(baseUrl + "/v1/cars")
                .thenReturn();
        return responseAddNewCar;
    }

    public String getMessageResponseAddNewCar(AddNewCarDTO addNewCarDTO, String token) {
        if(responseAddNewCar == null) {
            responseAddNewCar = getResponseAddNewCar(addNewCarDTO, token);
        }
        return responseAddNewCar.then().extract().path("message");
    }

    public int getStatusCodeResponseAddNewCar(AddNewCarDTO addNewCarDTO, String token) {
        if(responseAddNewCar == null) {
            responseAddNewCar = getResponseAddNewCar(addNewCarDTO, token);
        }
        return responseAddNewCar.getStatusCode();
    }

    public void setResponseAddNewCarNull() {
        responseAddNewCar = null;
    }

    //------------------------------------------------

    private Response getResponseDeleteCar(String serNumber, String token) {
        responseDeleteCar = given()
                .header("Authorization", token)
                .when()
                .delete(baseUrl + "/v1/cars/" + serNumber)
                .thenReturn();
        return responseDeleteCar;
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
