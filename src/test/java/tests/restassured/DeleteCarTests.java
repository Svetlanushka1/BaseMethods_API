package tests.restassured;

import api.BaseAPI;
import dto.AddNewCarDTO;
import org.testng.annotations.Test;

public class DeleteCarTests extends BaseAPITest {

    @Test
    public void testDeleteNewCarResponse() {
        String serNumber = randomUtils.generateDigitsString(12);
        AddNewCarDTO addNewCar = AddNewCarDTO.builder()
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
        softAssert.assertEquals(carsAPI.getStatusCodeResponseAddNewCar(addNewCar, token), 200,
                "status code for add new car not 200");
//        softAssert.assertEquals(carsAPI.getMessageResponseAddNewCar(addNewCar, token),
//                "Car added successfully");
        softAssert.assertEquals(carsAPI.getStatusCodeDeleteCar(serNumber, token), 200,
                "status code for delete car not 200");
        softAssert.assertEquals(carsAPI.getMessageDeleteCar(serNumber, token), "Car deleted successfully");
        System.out.println(carsAPI.getMessageDeleteCar(serNumber, token));
        softAssert.assertAll();
    }
}
