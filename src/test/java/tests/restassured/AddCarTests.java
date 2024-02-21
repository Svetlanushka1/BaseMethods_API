package tests.restassured;

import dto.AddNewCarDTO;
import org.testng.annotations.Test;

public class AddCarTests extends BaseAPITest{

    @Test
    public void testAddNewCarResponse() {

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
        softAssert.assertEquals(carsAPI.getStatusCodeResponseAddNewCar(addNewCar, token), 200);
        softAssert.assertEquals(carsAPI.getMessageResponseAddNewCar(addNewCar, token),
                "Car added successfully");
        softAssert.assertAll();
    }
}
