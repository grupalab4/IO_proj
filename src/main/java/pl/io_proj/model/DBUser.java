package pl.io_proj.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "users", schema = "liczymy_kalorie")
public class DBUser implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;
    @Column(unique = true)
    private String username;
    private String password;
    private String firstName;
    private String surname;
    @Nullable
    private Integer weight;
    @Nullable
    private Integer height;
    @Nullable
    private Integer age;

    public DBUser(String username,
                  String password,
                  String firstName,
                  String surname,
                  Integer weight,
                  Integer height,
                  Integer age) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.surname = surname;
        this.weight = weight;
        this.height = height;
        this.age = age;
    }
}
