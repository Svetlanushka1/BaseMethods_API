package api;

import com.jayway.restassured.response.Response;
import dto.AuthDTO;
import dto.UserDTO;

import static com.jayway.restassured.RestAssured.given;

    public class UserAPI extends BaseAPI {

        Response responseLogin = null;

        private Response getResponseLogin(UserDTO user) {
            responseLogin = given()
                    .body(user)
                    .when()
                    .post(baseUrl + "/v1/user/login/usernamepassword")
                    .thenReturn();
            return responseLogin;
        }

        public String getToken(UserDTO user) {
            if(responseLogin == null) {
                getResponseLogin(user);
            }
            return responseLogin.getBody().as(AuthDTO.class).getAccessToken();
        }
            /*
    public String getToken() {

AuthenticationBodyDto{
username*	string
password*	string
pattern: ^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@$#^&*!])(?=.*[a-zA-Z]).{8,}$

/*

        AuthRequestDTO loginBody = AuthRequestDTO.builder()
                .username("haifa@gmail.com")
                .password("Haifa082022$").build();

    String token = RestAssured
            .given()
                 .log().all()
            .when()
                    .contentType(ContentType.JSON)
                    .body(loginBody)
                    .post(BASE_URI + apiLoginURI)
            .then()
                    .log().all()
                    .statusCode(200)
                    .extract().response().jsonPath().getString("token");
        System.out.println("token: " + token);
        return token;
    }
 */

        public int getStatusCodeResponseLogin(UserDTO user) {
            if(responseLogin == null) {
                getResponseLogin(user);
            }
            return responseLogin.getStatusCode();
        }

        public void setResponseLoginNull() {
            responseLogin = null;
        }

//    public String getToken(UserDTO user) {
//        responseLogin = given()
//                .body(user)
//                .when()
//                .post(baseUrl + "/v1/user/login/usernamepassword")
//                .thenReturn();
//        return responseLogin.getBody().as(AuthDTO.class).getAccessToken();
//    }
    }
