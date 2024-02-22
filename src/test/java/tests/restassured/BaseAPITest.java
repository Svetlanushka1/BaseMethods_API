package tests.restassured;

import api.CarsAPI;
import api.UserAPI;
import dto.UserDTO;

import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;
import data.RandomUtils;
import property.ConfigProperties;

public class BaseAPITest {
    //String token = "";
    String token ="";//!= null
    UserAPI userAPI = new UserAPI();
    CarsAPI carsAPI = new CarsAPI();
    SoftAssert softAssert = new SoftAssert();
    RandomUtils randomUtils = new RandomUtils();

    public String BASE_URI = "https://ilcarro-backend.herokuapp.com";
    public String apiLoginURI = "/v1/user/login/usernamepassword";
    public String authHeader = "Authorizations";
    public String endPointCarAdd = "/v1/cars";
    public String endPointCarEdit = "/v1/cars/edit";
    public String endPointCarSearch = "/v1/cars/search";
    public String endPointGetCars = "/v1/cars/my";
    public String endPointCarBooking = "/v1/cars/{serialNumber}/booking";
    UserDTO userHardCode = UserDTO.builder()
            .username("testqa20@gmail.com")
            .password("123456Aa$")
            .build();
    UserDTO userFromProperty = UserDTO.builder()
            .username(ConfigProperties.getProperty("username"))
            .password(ConfigProperties.getProperty("password"))
            .build();
    //TODO use BASE_URI and endpoints

  /*  @BeforeSuite(alwaysRun = true)
    public void getToken() {
        // get token from API response to the service user
        token = userAPI.getToken(userHardCode);
        System.out.println(token);
    }*/
  @BeforeSuite(alwaysRun = true)
  public void getToken(){
      token = userAPI.getToken(userFromProperty);
      System.out.println("token: " + token);
  }
}
