package dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@Builder
@ToString
public class ErrorDTO {
    /*
   {
ErrorMessageDtoString{
timestamp	string($date-time)
status	integer($int32)
error	string
message	string
path	string
}
    */
    String timestamp;
    int status;
    String error;
    //Object message;
    //ErrorDTO messageErrorDTO;
    String message;
    String path;

     /*
    401
    {
  "timestamp": "2023-12-19T08:29:24",
  "status": 401,
  "error": "Unauthorized",
  "message": "Login or Password incorrect",
  "path": "/v1/user/login/usernamepassword"
}
     */
}
