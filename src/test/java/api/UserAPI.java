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
