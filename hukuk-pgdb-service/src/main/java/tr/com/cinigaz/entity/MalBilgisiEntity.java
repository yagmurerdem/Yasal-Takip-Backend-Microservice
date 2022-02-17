package tr.com.cinigaz.entity;


import lombok.*;

import javax.persistence.*;
@Data
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="mal_bilgisi")
public class MalBilgisiEntity extends MainEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="mal_bilgisi_id")
    private Long malBilgisiId;
    @Column(name="kayitli_mal",  length = 50)
    private String kayitliMal;
    @Column(name="ad",  length = 50)
    private String ad;
    @Column(name="soyad",  length = 50)
    private String soyad;

}
