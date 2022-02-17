package tr.com.cinigaz.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="mahkeme")

public class MahkemeEntity extends MainEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="mahkeme_id")
    private Long mahkemeId;
    @Column(name="mahkeme_kod",  length = 50)
    private String mahkemeKod;
    @Column(name="mahkeme_salon",  length = 50)
    private String mahkemeSalon;
    @Column(name="davaci_adi",  length = 50)
    private String davaciAdi;
    @Column(name="davaci_salon",  length = 50)
    private String davaciSalon;
    @Column(name="davaci_adres",  length = 50)
    private String davaciAdres;
    @Column(name="davali_ad",  length = 50)
    private String davaliAd;
    @Column(name="davali_soyad",  length = 50)
    private String davaliSoyad;
    @Column(name="davali_adres",  length = 50)
    private String davaliAdres;
    @Column(name="dava_konusu",  length = 50)
    private String davaKonusu;
    @Column(name="status",  length = 50)
    private Boolean status;


}
