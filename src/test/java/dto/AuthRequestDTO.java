package dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@Builder
@ToString
public class AuthRequestDTO {
    /*
    RegistrationBodyDto{
username*	string
password*	string
pattern: ^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@$#^&*!])(?=.*[a-zA-Z]).{8,}$
firstName*	string
lastName*	string
}
     */
    String username;
    String password;
    String firstName;
    String lastName;

}
