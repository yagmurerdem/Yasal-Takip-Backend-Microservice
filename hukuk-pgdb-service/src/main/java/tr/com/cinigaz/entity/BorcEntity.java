package tr.com.cinigaz.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import tr.com.cinigaz.enumer.ReferansTurleri;

import javax.persistence.*;
import java.util.Date;


@Data
@Entity
@Table(name="borc")
@NoArgsConstructor
@AllArgsConstructor



public class BorcEntity extends MainEntity{



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="borc_id")
    @JsonProperty("borcId")
    private Long borcId;


    @Column(name="ad" , length = 50)
    @JsonProperty("ad")
    private String ad;


    @Column(name="soyad" , length = 50)
    @JsonProperty("soyad")
    private String soyad;


    @Column(name="islem_tarihi")
    @Temporal(TemporalType.DATE)
    @JsonProperty("islemTarihi")
    private Date islemTarihi;


    @Enumerated(EnumType.STRING)
    @Column(name="referans_turu")
    @JsonProperty("referansTuru")
    private ReferansTurleri referansTuru;


    @Column(name = "referans_no" , length = 50)
    @JsonProperty("referansNo")
    private String referansNo;

}
