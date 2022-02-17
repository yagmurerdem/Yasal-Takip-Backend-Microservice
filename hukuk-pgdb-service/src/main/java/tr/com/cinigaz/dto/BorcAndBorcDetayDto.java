package tr.com.cinigaz.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BorcAndBorcDetayDto {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("odemetarihi")
    private Date odemetarihi;
    @JsonProperty("sonodeme")
    private Date sonodeme;
    @JsonProperty("faiz")
    private double faiz;
    @JsonProperty("tutar")
    private double tutar;
    @JsonProperty("borcId")
    private Long  borcId;
}
