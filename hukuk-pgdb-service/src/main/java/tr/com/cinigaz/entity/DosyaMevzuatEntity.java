package tr.com.cinigaz.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="dosya_mevzuat")
public class DosyaMevzuatEntity extends MainEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="dosya_mevzuat_id")
    private Long dosyaMevzuatId;


    @Column(name="takip_basvuru_harc",  length = 50)
    private String takipBasvuruHarc;

    @Column(name="takip_pesin_harc", length = 50)
    private String takipPesinHarc;

    @Column(name="takip_vekaletname_harc", length = 50)
    private String takipVekaletnameHarc;


}
