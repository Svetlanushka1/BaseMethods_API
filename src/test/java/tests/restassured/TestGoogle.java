package tests.restassured;



import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import org.testng.annotations.Test;

public class TestGoogle {
 /*   @Test
    public void makeSureThatGoogleIsUp(){
        //RestAssured
        // .given() - what needs to send
        // .when() - conditions
        // .then(); - result
        RestAssured
                .given()
                .contentType(ContentType.JSON)
                .when()
                .log().uri()
                .get("http://google.com")
                .then()
                .log().all()
                .assertThat()
                .statusCode(200);
    }*/
}
