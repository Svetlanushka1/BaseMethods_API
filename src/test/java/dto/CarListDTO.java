package dto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.List;
@Setter
@Getter
@Builder
@ToString

public class CarListDTO {
    List<CarDTO> carsList;
}
