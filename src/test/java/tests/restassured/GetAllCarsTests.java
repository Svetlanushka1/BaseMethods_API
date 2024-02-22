package tests.restassured;


public class GetAllCarsTests {
    /*
    "eyJhbGciOiJIUzI1NiJ9.eyJyb2xlcyI6WyJST0xFX1VTRVIiXSwic3ViIjoiaGFpZmFAZ21haWwuY29tIiwiaXNzIjoiUmVndWxhaXQiLCJleHAiOjE3MDM4NTg3MTUsImlhdCI6MTcwMzI1ODcxNX0.1L6IchjLwK_wMoN_OTOC3VHENX9VtYryPboRjvxokus";
     */
    /*
    String endpointGetCars = "/v1/cars/my";
    @BeforeMethod
    public void precondition(){
        //RestAssured.baseURI = BASE_URI;

    }
  @Test
    public void getAllCars(){

    CarListDTO carsList =  RestAssured
                .given()
                    .log().all()
                .when()
                    .log().all()
                    .contentType(ContentType.JSON)
                    .header("Authorization", "Bearer: " + getToken())
                    .get(BASE_URI + endpointGetCars)
                .then()
                    .log().all()
                    .assertThat().statusCode(200)
                    .extract()
                    .as(CarListDTO.class);

      for(CarDTO car: carsList.getCarsList()){
          System.out.println(car.getSerialNumber());
          System.out.println(car.getCity());

      }
     // Assert.assertFalse(carsList.toString().isEmpty());}
*/

}
