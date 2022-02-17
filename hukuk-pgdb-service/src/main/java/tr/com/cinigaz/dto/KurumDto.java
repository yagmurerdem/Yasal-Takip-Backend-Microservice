package tr.com.cinigaz.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.Column;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class KurumDto {

    @JsonProperty("kurumAdi")
    private String kurumAdi;


    @JsonProperty("kurumTur")
    private String kurumTur;
}
