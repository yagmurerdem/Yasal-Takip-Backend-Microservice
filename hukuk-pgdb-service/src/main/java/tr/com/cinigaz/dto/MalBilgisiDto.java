package tr.com.cinigaz.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MalBilgisiDto {

    @JsonProperty("malBilgisiId")
    private Long malBilgisiId;
    @JsonProperty("kayitliMal")
    private String kayitliMal;
    @JsonProperty("ad")
    private String ad;
    @JsonProperty("soyad")
    private String soyad;
}
