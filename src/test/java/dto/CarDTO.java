package dto;

import lombok.*;

@Setter
@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CarDTO {

    // {
    //  "serialNumber": "1234578983",
    //  "manufacture": "opel",
    //  "model": "corsa",
    //  "year": 1990,
    //  "fuel": "Petrol",
    //  "seats": 2,
    //  "carClass": "1",
    //  "pricePerDay": 7,
    //  "about": "abc",
    //  "city": "Tel Aviv"
    //}
        /*
    CarDto{
serialNumber*	string
manufacture*	string
model*	string
year*	string
fuel*	string
seats*	integer($int32)
carClass*	string
pricePerDay*	number($double)
about	string
city*	string
lat	number($double)
lng	number($double)
image	string
owner	string
bookedPeriods	[...]
}
     */

    String serialNumber;
    String manufacture;
    String model;
    int year;
    String fuel;
    int seats;
    String carClass;
   // int pricePerDay;
    double pricePerDay;
    String about;
    String city;







}
