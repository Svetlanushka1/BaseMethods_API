package tests.restassured;

import dto.CarDTO;
import org.testng.annotations.Test;

public class AddNewCarTests extends BaseAPITest{

    @Test
    public void testAddNewCarResponse() {

        String serNumber = randomUtils.generateDigitsString(12);
        CarDTO addNewCar = CarDTO.builder()
                .serialNumber(serNumber)
                .manufacture("qa40")
                .model("corsa")
                .year(1990)
                .fuel("Petrol")
                .seats(2)
                .carClass("ads")
                .pricePerDay(9)
                .about("fff")
                .city("Tel Aviv")
                .build();
        softAssert.assertEquals(carsAPI.getStatusCodeResponseAddNewCar(addNewCar, token), 200);
        softAssert.assertEquals(carsAPI.getMessageResponseAddNewCar(addNewCar, token),
                "Car added successfully");
        softAssert.assertAll();
    }
    /*   RestAssured
                .given()
                .log().all()
                .when()
                .log().all()
                .contentType(ContentType.JSON)
                .header("", "Bearer" + getToken())
                .body(car)
                .post(baseURI + apiAddCarURI)
                .then()
                .log().all()
                .satatusCode(200)
                .assertThat().body("message",startsWith("message",startsWith("message"));
        ;

    }*/
}
