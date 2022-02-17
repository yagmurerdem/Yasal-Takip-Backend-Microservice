package tr.com.cinigaz.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of={"id"})
public class UserDto {

    //@JsonIgnore
    //private Integer id;
    @JsonProperty("adi")
    private String adi;
    @JsonProperty("soyadi")
    private String soyadi;
    @JsonProperty("baroBilgisi")
    private String baroBilgisi;
    @JsonProperty("sicilNo")
    private Integer sicilNo;

}
