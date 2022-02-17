package tr.com.cinigaz.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.util.Date;



@Data
@Entity
@Table(name="borc_detay")
@NoArgsConstructor
@AllArgsConstructor
public class    BorcDetayEntity extends MainEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "borc_detay_id")
    @JsonProperty("borcDetayId")
    private Long borcDetayId;

    @Column(name="odeme_tarihi" )
    @JsonProperty("odemeTarihi")
    private Date odemeTarihi;

    @Column(name="son_odeme_tarihi" )
    @JsonProperty("sonodeme")
    private Date sonOdeme;

    @Column(name="gecikme_faiz_orani")
    @JsonProperty("gecikmeFaizOrani")
    private double gecikmeFaizOrani;

    @Column(name="tutar")
    @JsonProperty("tutar")
    private double tutar;

    @Column(name = "borc_id")
    @JsonProperty("borcId")
    private Long  borcId;



}
