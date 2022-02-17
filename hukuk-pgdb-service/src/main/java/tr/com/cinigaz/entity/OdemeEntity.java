package tr.com.cinigaz.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="odeme")
public class OdemeEntity extends MainEntity{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="odeme_id")
    private Long odemeId;
    @Column(name="ilk_odeme_tarihi",  length = 50)
    private Date ilkOdemeTarihi;
    @Column(name="son_odeme_tarihi",  length = 50)
    private Date sonodemeTarihi;
    @Column(name="tutar",  length = 50)
    private double tutar;
    @Column(name="faizli_tutar",  length = 50)
    private double faizliTutar;


}
