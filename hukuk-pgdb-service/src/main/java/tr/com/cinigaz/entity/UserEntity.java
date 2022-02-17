package tr.com.cinigaz.entity;

import lombok.*;

import javax.persistence.*;
@Entity
@Data
@Table(name="kullanici")
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity extends MainEntity{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "adi")
    private String adi;
    @Column(name="soyadi")
    private String soyadi;
    @Column(name="email")
    private String email;
    @Column(name ="role")
    private String role;

}
