package dto;

import lombok.*;

@Setter
@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class UserDTO {
    String username;
    String password;
    String firstName;
    String lastName;
}
