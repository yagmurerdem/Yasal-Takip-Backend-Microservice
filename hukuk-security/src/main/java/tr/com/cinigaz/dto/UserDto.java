package tr.com.cinigaz.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Integer id;
    @JsonProperty("username")
    private String username;
    @JsonProperty("password")
    private String password;
    @JsonProperty("adi")
    private String adi;
    @JsonProperty("soyadi")
    private String soyadi;
    @JsonProperty("email")
    private String email;
    private String role;

}
