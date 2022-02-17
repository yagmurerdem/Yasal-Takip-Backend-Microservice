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
@Table(name = "kurum")
public class KurumEntity extends MainEntity{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "kurum_id")
    private Long kurumId;

    @Column(name = "kurum_adi", length = 50)
    private String kurumAdi;

    @Column(name = "kurum_tur", length = 50)
    private String kurumTur;


}
