package tests.okhttpapi;

import api_restassured.CarController;
import com.google.gson.Gson;
import data.RandomUtils;
import dto.UserDTO;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import org.testng.annotations.BeforeSuite;
import data.ConfigProperties;

public class BaseOkhttpTest {
   // public static final MediaType JSON = MediaType.get("application/json; charset=utf-8");
    public static final MediaType JSON = MediaType.get("application/json");
    Gson gson = new Gson();
    OkHttpClient okhttpClient = new OkHttpClient();
    UserDTO userDTO;
    CarController carController;
    RandomUtils randomUtils = new RandomUtils();
    String token;
    // String baseUrl = "https://ilcarro-backend.herokuapp.com";
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





    @BeforeSuite
    public void setUp() {

    }
    /*


//    public String getToken() {
//        return token;
//    }

//    public void setToken(UserDTO userDTO) {
//        AuthenticationController authenticationController = new AuthenticationController();
//        token = authenticationController.setTokenFromResponse(userDTO);
//        System.out.println("token from base api " + token);
//    }

     */
}
