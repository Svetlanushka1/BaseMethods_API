package tests.okhttp;

import com.google.gson.Gson;
import dto.AuthDTO;
import dto.UserDTO;
import okhttp3.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTestsOkHTTP {

    public static final MediaType JSON = MediaType.get("application/json");
    Gson gson = new Gson();
    OkHttpClient okHttpClient = new OkHttpClient();
    String baseUrl =  "https://ilcarro-backend.herokuapp.com";

    @Test
    public void loginTest() {
        UserDTO user = UserDTO.builder()
                .username("testqa20@gmail.com")
                .password("123456Aa$")
                .build();

        RequestBody requestBody = RequestBody.create(gson.toJson(user), JSON);
        Request request = new Request.Builder()
                .url(baseUrl + "/v1/user/login/usernamepassword")
                .post(requestBody)
                .build();

        Response response;

        try {
            response = okHttpClient.newCall(request).execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if(response == null) {
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
            AuthDTO authDTO = gson.fromJson(responseJson, AuthDTO.class);
            System.out.println(authDTO.getAccessToken());
        } else {
            System.out.println(response.code());
            Assert.fail();
        }
    }
}
