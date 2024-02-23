package tests.okhttpapi;

import dto.AuthResponseToken;
import dto.UserDTO;
import okhttp3.*;
import java.io.IOException;

public class AuthenticationController extends BaseOkhttpTest {

    Response responseAuth;

    public Response responseAuthSignIn(UserDTO userDTO) {
        RequestBody requestBody = RequestBody.create(gson.toJson(userDTO), JSON);
        Request request = new Request.Builder()
                .url(BASE_URI + "/v1/user/registration/usernamepassword")
                .post(requestBody)
                .build();
        try {
            responseAuth = okhttpClient.newCall(request).execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return responseAuth;
    }

    public String setTokenFromResponse(UserDTO userDTO) {
        if(responseAuth == null) {
            responseAuthSignIn(userDTO);
        }
        String tokenLocal;
        try {
            AuthResponseToken responseDTO = gson.fromJson(responseAuth.body().string(), AuthResponseToken.class);
            tokenLocal = responseDTO.getAccessToken();
            System.out.println("------ token " + tokenLocal);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return tokenLocal;
    }



}
