package tr.com.cinigaz.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Table(name = "avukat")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AvukatEntity extends MainEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Column(name="adi")
    private String adi;
    @Column(name="soyadi")
    private String soyadi;
    @Column(name="baro_bilgisi")
    private String baroBilgisi;
    @Column(name="sicil_no")
    private Integer sicilNo;


}
