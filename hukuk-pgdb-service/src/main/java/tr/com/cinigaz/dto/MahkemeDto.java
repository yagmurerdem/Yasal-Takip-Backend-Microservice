package tr.com.cinigaz.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MahkemeDto {

    @JsonProperty("mahkemeId")
    private Long mahkemeId;
    @JsonProperty("mahkemeKod")
    private String mahkemeKod;
    @JsonProperty("mahkemeSalon")
    private String mahkemeSalon;
    @JsonProperty("davaciAdi")
    private String davaciAdi;
    @JsonProperty("davaciSalon")
    private String davaciSalon;
    @JsonProperty("davaciAdres")
    private String davaciAdres;
    @JsonProperty("davaliAd")
    private String davaliAd;
    @JsonProperty("davaliSoyad")
    private String davaliSoyad;
    @JsonProperty("davaliAdres")
    private String davaliAdres;
    @JsonProperty("davaKonusu")
    private String davaKonusu;
    @JsonProperty("status")
    private Boolean status;
}
