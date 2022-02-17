package tr.com.cinigaz.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tr.com.cinigaz.enumer.ReferansTurleri;

import java.util.Date;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BorcDto {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("ad")
    private String ad;
    @JsonProperty("soyad")
    private String soyad;
    private ReferansTurleri referansTuru;
    private String referansNo;
    @JsonProperty("islem_tarihi")
    private Date islemTarihi;
}
