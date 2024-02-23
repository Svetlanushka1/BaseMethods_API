package tests.restassured;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import dto.AuthRequestDTO;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import data.ConfigProperties;

import static org.hamcrest.Matchers.anything;
import data.DataProviderLogin;

public class LoginAssuredTests extends BaseAPITest {
    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return new Object[][]{
                {"testqa20@gmail.com", "123456Aa$"},
                {"testqa201@gmail.com", "123456Aa$"},
                {"testqa202@gmail.com", "123456Aa$"}
        };
    }

    @Test
    public void loginPositiveStep1() {
        String loginBody = "{\n" +
                "   \"username\": \"abc@def.com\", \n" +
                "   \"password\": \"$Abcdef12345\" \n" +
                "}";
        String loginURI = "https://ilcarro-backend.herokuapp.com/v1/user/login/usernamepassword";

        RestAssured
                .given()
                .log().all()
                .when()
                .contentType(ContentType.JSON)
                .body(loginBody)
                .post(loginURI)
                .then()
                .log().ifStatusCodeIsEqualTo(200)
                .assertThat().body("token", anything());
    }

    @Test(groups = {"smoke"})
    public void loginPositiveStep2() {
        String loginURI = "https://ilcarro-backend.herokuapp.com/v1/user/login/usernamepassword";
        AuthRequestDTO loginBody = AuthRequestDTO.builder()
                .username("haifa@gmail.com")
                .password("haifa082022$").build();


        RestAssured
                .given()
                .log().all()
                .when()
                .contentType(ContentType.JSON)
                .body(loginBody)
                .post(loginURI)
                .then()
                .log().ifStatusCodeIsEqualTo(200)
                .assertThat().body("token", anything());
    }

   // @Test(dataProvider = "loginCSV",dataProviderClass = DataProviderLogin.class)
    @Test
    public void loginPositiveUsingProperties() {

        AuthRequestDTO loginBody = AuthRequestDTO.builder()
                .username(ConfigProperties.getProperty("username"))
                .password(ConfigProperties.getProperty("password"))
                .build();

        RestAssured
                .given()
                .log().all()
                .when()
                .contentType(ContentType.JSON)
                .body(loginBody)
                .post(BASE_URI + "/v1/user/login/usernamepassword")
                .then()
                .log().ifStatusCodeIsEqualTo(200)
                .extract().response().jsonPath().getString("token");
        //.assertThat().body("token", anything());
    }
    /*
    eyJhbGciOiJIUzI1NiJ9.eyJyb2xlcyI6WyJST0xFX1VTRVIiXSwic3ViIjoiaGFpZmFAZ21haWwuY29tIiwiaXNzIjoiUmVndWxhaXQiLCJleHAiOjE3MDQ1MjkwOTcsImlhdCI6MTcwMzkyOTA5N30.ZtFCQi2WsAXeJLIgi0j5zU-QOMHMyM-pIkQ23aFGJ1g
     */

}
