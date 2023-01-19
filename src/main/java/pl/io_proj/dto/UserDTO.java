package pl.io_proj.dto;

import jakarta.annotation.Nullable;
<<<<<<< HEAD
import lombok.Getter;
import pl.io_proj.model.DBUser;

import java.io.Serializable;

@Getter
public class UserDTO implements Serializable {
    private final String firstName;
    private final String surname;
    @Nullable
    private final Integer weight;
    @Nullable
    private final Integer height;
    @Nullable
    private final Integer age;
=======
import pl.io_proj.model.DBUser;

public class UserDTO {
    private String firstName;
    private String surname;
    @Nullable
    private Integer weight;
    @Nullable
    private Integer height;
    @Nullable
    private Integer age;
>>>>>>> f07a653 (Changed api/users/about not to display password by adding UserDTO)

    public UserDTO(DBUser user){
        this.firstName = user.getFirstName();
        this.surname = user.getSurname();
        this.weight = user.getWeight();
        this.height = user.getHeight();
        this.age = user.getAge();
    }
}
