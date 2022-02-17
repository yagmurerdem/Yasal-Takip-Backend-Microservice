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
public class HacizDto {

    @JsonProperty("alınanTur")
    private String alınanTur;


    @JsonProperty("bedeli")
    private String bedeli;
}
