package ma.m0hamedait.appcustomerservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRequestDTO {
    private String id;
    private String name;
    private String email;
}
