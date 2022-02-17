package tr.com.cinigaz.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode

public class DosyaMevzuatDto {

    @JsonProperty("takipBasvuruHarc")
    private String takipBasvuruHarc;

    @JsonProperty(" takipPesinHarc")
    private String  takipPesinHarc;

    @JsonProperty("takipVekaletnameHarc")
    private String takipVekaletnameHarc;

}
