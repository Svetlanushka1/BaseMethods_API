package tests.restassured;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthTests extends BaseAPITest{

    @Test
    public void loginApiTest() {
        softAssert.assertEquals(100, 200,
                "100 not equal 200");

        softAssert.assertEquals(userAPI.getStatusCodeResponseLogin(user), 201,
                "status code not 200");

        softAssert.assertAll();
    }

    @Test
    public void loginApiTest2() {
        Assert.assertEquals(100, 200,
                "100 not equal 200");

        Assert.assertEquals(userAPI.getStatusCodeResponseLogin(user), 201,
                "status code not 200");

    }
}
