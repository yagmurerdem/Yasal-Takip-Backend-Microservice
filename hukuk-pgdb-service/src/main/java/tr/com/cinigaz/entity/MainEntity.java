package tr.com.cinigaz.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;


@MappedSuperclass

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MainEntity {
    @Column(name = "created_by", length = 30)
    private String createdBy;
    @Column(name = "updated_by", length = 30)
    private String updatedBy;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

}
