package dto;

import lombok.*;

@Setter
@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AddNewCarDTO {

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

    String serialNumber;
    String manufacture;
    String model;
    int year;
    String fuel;
    int seats;
    String carClass;
    int pricePerDay;
    String about;
    String city;
}
