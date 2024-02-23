package tests.restassured;

import com.jayway.restassured.response.Response;
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
        softAssert.assertEquals(carController.getStatusCodeResponseAddNewCar(addNewCar, token), 200);
        softAssert.assertEquals(carController.getMessageResponseAddNewCar(addNewCar, token),
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
    @Test
    public void addNewCarPositive() {
        CarDTO addNewCar = CarDTO.builder()
                .serialNumber(randomUtils.generateRandomString(10))
                .manufacture("opel")
                .model("corsa")
                .year(Integer.parseInt("1990"))
                .fuel("Petrol")
                .seats(2)
                .carClass("first")
                .pricePerDay(25)
                .about("blabla")
                .city("Tel Aviv")
                .build();

        Response response = carController.requestNewCar(addNewCar, token);

        response.then().assertThat().statusCode(200);

    }

    @Test
    public void addDuplicateCarTest() {
        String serNumber = randomUtils.generateRandomString(10);
        CarDTO addNewCar = CarDTO.builder()
                .serialNumber(serNumber)
                .manufacture("opel")
                .model("corsa")
                .year(Integer.parseInt("1990"))
                .fuel("Petrol")
                .seats(2)
                .carClass("first")
                .pricePerDay(25)
                .about("blabla")
                .city("Tel Aviv")
                .build();

        Response response = carController.requestNewCar(addNewCar, token);

        response.then().assertThat().statusCode(200);

        response = carController.requestNewCar(addNewCar, token);
        System.out.println("200 above");

        response.then().assertThat().statusCode(400);
        System.out.println("400 above");

    }

    @Test
    public void addNewCarNegativeWrongToken() {
        CarDTO car = CarDTO.builder()
                .serialNumber(randomUtils.generateRandomString(10))
                .manufacture("opel")
                .model("corsa")
                .year(Integer.parseInt("1990"))
                .fuel("Petrol")
                .seats(2)
                .carClass("first")
                .pricePerDay(25)
                .about("blabla")
                .city("Tel Aviv")
                .build();

        Response response = carController.requestNewCarWithWrongToken(car);

        response.then().assertThat().statusCode(401);

    }
}
