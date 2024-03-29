package tests.okhttpapi;

import data.DataProviderLogin;
import dto.*;
import okhttp3.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import data.ConfigProperties;

import java.io.IOException;

public class LoginTestsOkHTTP extends BaseOkhttpTest {

   /* public static final MediaType JSON = MediaType.get("application/json");
    Gson gson = new Gson();
    OkHttpClient okHttpClient = new OkHttpClient();
    String baseUrl = "https://ilcarro-backend.herokuapp.com";
    */

    @Test
    public void loginTestHardCode() {
        UserDTO user = UserDTO.builder()
                .username("testqa20@gmail.com")
                .password("123456Aa$")
                .build();

        RequestBody requestBody = RequestBody.create(gson.toJson(user), JSON);
        Request request = new Request.Builder()
                .url(BASE_URI + "/v1/user/login/usernamepassword")
                .post(requestBody)
                .build();

        Response response;

        try {
            response = okhttpClient.newCall(request).execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (response == null) {
            Assert.fail();
        } else if (response.isSuccessful()) {
            System.out.println(response.code());
            System.out.println(response.message());

            String responseJson;
            try {
                responseJson = response.body().string();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            AuthResponseToken authResponseToken = gson.fromJson(responseJson, AuthResponseToken.class);
            System.out.println(authResponseToken.getAccessToken());
        } else {
            System.out.println(response.code());
            Assert.fail();
        }
    }

    @Test

    public void loginPositiveAuthRequestDTO() throws IOException {

      /*  Gson gson = new Gson();
        OkHttpClient client = new OkHttpClient();
        final MediaType JSON = MediaType.get("application/json; charset=utf-8");*/

        //1 create the request
        AuthRequestDTO authRequestDTO = AuthRequestDTO.builder()
                .username("haifa@gmail.com")
                .password("Haifa082022$")
                .build();
        //2 send this request to the server
        RequestBody requestBody = RequestBody.create(gson.toJson(authRequestDTO), JSON);

       /* Request request = new Request.Builder()
                .url("https://ilcarro-backend.herokuapp.com/v1/user/login/usernamepassword")
                .post(requestBody)
                .build();*/
        Request request = new Request.Builder()
                .url(BASE_URI + apiLoginURI)
                .post(requestBody)
                .build();

        // 3 get the response
        Response response = okhttpClient.newCall(request).execute();
        //4 convert the received response to JavaFormat
        if (response.isSuccessful()) {
            AuthResponseToken authResponseToken = gson.fromJson(response.body().string(), AuthResponseToken.class);
            String token = authResponseToken.getAccessToken();
            System.out.println("Token: " + token);
            System.out.println(response.code());
            Assert.assertEquals(response.code(), 200);
        } else {
            ErrorDTO errorDTO = gson.fromJson(response.body().string(), ErrorDTO.class);
            Assert.assertEquals(response.code(), 401);
            Assert.assertEquals(response.message(), "Login or Password incorrect");


        }
    }
    @Test

    public void loginPositiveDataFromPropertiesFile() throws IOException {

    /*    Gson gson = new Gson();
        OkHttpClient client = new OkHttpClient();
        final MediaType JSON = MediaType.get("application/json; charset=utf-8");
*/

        //1 create the request form Properties

        AuthRequestDTO authRequestDTO = AuthRequestDTO.builder()
                .username(ConfigProperties.getProperty("username"))
                .password(ConfigProperties.getProperty("password"))
                .build();
        System.out.println("Auth " + ConfigProperties.getProperty("username"));
        //2 send this request to the server
        RequestBody requestBody = RequestBody.create(gson.toJson(authRequestDTO), JSON);

        Request request = new Request.Builder()
                .url("https://ilcarro-backend.herokuapp.com/v1/user/login/usernamepassword")
                .post(requestBody)
                .build();

        // 3 get the response
        Response response = okhttpClient.newCall(request).execute();
        //4 convert the received response to JavaFormat
        if (response.isSuccessful()) {
            AuthResponseToken authResponseToken = gson.fromJson(response.body().string(), AuthResponseToken.class);
            String token = authResponseToken.getAccessToken();
            System.out.println("Token: " + token);
            System.out.println(response.code());
            Assert.assertEquals(response.code(), 200);
        } else {
            ErrorDTO errorDTO = gson.fromJson(response.body().string(), ErrorDTO.class);
            Assert.assertEquals(response.code(), 401);
            // Assert.assertEquals(response.message(), "Login or Password incorrect");


        }
    }
    @Test(groups = {"smoke"}, dataProvider = "loginCSV",dataProviderClass = DataProviderLogin.class)
    public void loginPositiveFromCSVfile(AuthRequestDTO authRequestDTO) throws IOException {
        //@DataProvider
        //    public Iterator<Object[]> loginCSV() {

   /*     Gson gson = new Gson();
        OkHttpClient client = new OkHttpClient();
        final MediaType JSON = MediaType.get("application/json; charset=utf-8");*/

        // take the data from SCV file
        //2 send this request to the server
        RequestBody requestBody = RequestBody.create(gson.toJson(authRequestDTO), JSON);

        Request request = new Request.Builder()
                .url("https://ilcarro-backend.herokuapp.com/v1/user/login/usernamepassword")
                .post(requestBody)
                .build();

        // 3 get the response
        Response response = okhttpClient.newCall(request).execute();
        //4 convert the received response to JavaFormat
        if (response.isSuccessful()) {
            AuthResponseToken authResponseToken = gson.fromJson(response.body().string(), AuthResponseToken.class);
            String token = authResponseToken.getAccessToken();
            System.out.println("Token: " + token);
            System.out.println(response.code());
            Assert.assertEquals(response.code(), 200);
        } else {
            ErrorDTO errorDTO = gson.fromJson(response.body().string(), ErrorDTO.class);
            Assert.assertEquals(response.code(), 401);
            Assert.assertEquals(response.message(), "Login or Password incorrect");


        }

    }
    @Test(groups = {"smoke"}, dataProvider = "loginCSV_negative()",dataProviderClass = DataProviderLogin.class)
    public void loginCSV_negative(AuthRequestDTO authRequestDTO) throws IOException {
        // public Iterator<Object[]> loginCSV_negative() {

    /*    Gson gson = new Gson();
        OkHttpClient client = new OkHttpClient();
        final MediaType JSON = MediaType.get("application/json; charset=utf-8");*/

        // take the data from SCV file
        //2 send this request to the server
        RequestBody requestBody = RequestBody.create(gson.toJson(authRequestDTO), JSON);

        Request request = new Request.Builder()
                .url("https://ilcarro-backend.herokuapp.com/v1/user/login/usernamepassword")
                .post(requestBody)
                .build();

        // 3 get the response
        Response response = okhttpClient.newCall(request).execute();
        //4 convert the received response to JavaFormat
        if (response.isSuccessful()) {
            AuthResponseToken authResponseToken = gson.fromJson(response.body().string(), AuthResponseToken.class);
            String token = authResponseToken.getAccessToken();
            System.out.println("Token: " + token);
            System.out.println(response.code());
            Assert.assertEquals(response.code(), 200);
        } else {
            ErrorDTO errorDTO = gson.fromJson(response.body().string(), ErrorDTO.class);
            Assert.assertEquals(response.code(), 401);
            Assert.assertEquals(response.message(), "Login or Password incorrect");


        }

    }
}
