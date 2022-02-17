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
@Table(name="haciz")
public class HacizEntity extends MainEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="haciz_id")
    private Long hacizId;


    @Column(name="alınan_tur",  length = 50)
    private String alınanTur;


    @Column(name="bedeli",  length = 50)
    private String bedeli;

}
