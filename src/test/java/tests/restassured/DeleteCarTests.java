package tests.restassured;

import com.jayway.restassured.response.Response;
import dto.CarDTO;
import org.testng.annotations.Test;

public class DeleteCarTests extends BaseAPITest {

    @Test
    public void testDeleteNewCarResponse() {
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
        softAssert.assertEquals(carController.getStatusCodeResponseAddNewCar(addNewCar, token), 200,
                "status code for add new car not 200");
//        softAssert.assertEquals(carsAPI.getMessageResponseAddNewCar(addNewCar, token),
//                "Car added successfully");
        softAssert.assertEquals(carController.getStatusCodeDeleteCar(serNumber, token), 200,
                "status code for delete car not 200");
        softAssert.assertEquals(carController.getMessageDeleteCar(serNumber, token), "Car deleted successfully");
        System.out.println(carController.getMessageDeleteCar(serNumber, token));
        softAssert.assertAll();
    }
    @Test
    public void addNewCarPositive() {
        String serNumber = randomUtils.generateRandomString(10);

        CarDTO carDTO = CarDTO.builder()
                .serialNumber(serNumber)
                .manufacture("opel")
                .model("corsa")
                .year(Integer.parseInt("2000"))
                .fuel("Petrol")
                .seats(2)
                .carClass("first")
                .pricePerDay(25)
                .about("blabla")
                .city("Tel Aviv")
                .build();

        Response response = carController.requestNewCar(carDTO, token);

        response.then().assertThat().statusCode(200);

        response = carController.requestDeleteCar(serNumber, token);

        response.then().assertThat().statusCode(400);

    }
}
