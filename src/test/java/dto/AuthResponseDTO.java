package dto;

import lombok.*;

@Setter
@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponseDTO {
    /*
    TokenDto{
accessToken	string
}
     */
    String accessToken;
}
