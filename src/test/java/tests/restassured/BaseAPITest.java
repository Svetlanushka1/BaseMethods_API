package tests.restassured;

import api.CarsAPI;
import api.UserAPI;
import dto.UserDTO;

import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;
import utils.RandomUtils;

public class BaseAPITest {
    String token = "";
    UserAPI userAPI = new UserAPI();
    CarsAPI carsAPI = new CarsAPI();
    SoftAssert softAssert = new SoftAssert();

RandomUtils randomUtils = new RandomUtils();
    UserDTO user = UserDTO.builder()
            .username("testqa20@gmail.com")
            .password("123456Aa$")
            .build();

    @BeforeSuite(alwaysRun = true)
    public void getToken() {
        // get token from API response to the service user
        token = userAPI.getToken(user);
        System.out.println(token);
    }
}
