package tr.com.cinigaz.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OdemeDto {
    @JsonProperty("odemeid")
    private Long odemeId;
    @JsonProperty("ilkodemetarihi")
    private Date ilkOdemeTarihi;
    @JsonProperty("sonodemetarihi")
    private Date sonodemeTarihi;
    @JsonProperty("tutar")
    private double tutar;
    @JsonProperty("faizlitutar")
    private double faizliTutar;
}
