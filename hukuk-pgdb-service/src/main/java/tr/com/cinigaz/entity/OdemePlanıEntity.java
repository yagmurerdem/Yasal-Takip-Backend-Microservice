package tr.com.cinigaz.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="odeme_plani")
public class OdemePlanıEntity extends MainEntity{




    @Id
    @Column(name="odeme_plani_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "odeme_plani")
    @SequenceGenerator(name = "odeme_plani", allocationSize = 1, sequenceName = "seq_odeme_plani")
    private Long odemePlaniId;
    @Column(name="tutar",  length = 50)
    private double tutar;
    @Column(name="faiz",  length = 50)
    private double faiz;
    @Column(name="taksit_secenek",  length = 50)
    private int taksitSecenek;
    @Column(name="son_tutar",  length = 50)
    private double sonTutar;


}
