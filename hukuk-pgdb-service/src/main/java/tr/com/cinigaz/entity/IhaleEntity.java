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
@Table(name = "ihale")

public class IhaleEntity extends MainEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ihale_id")
    private String ihaleId;

    @Column(name = "avukatId")
    private String avukatId;

    @Column (name="ihale_adi")
    private String ihaleAdi;
}
