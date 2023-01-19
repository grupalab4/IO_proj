package pl.io_proj.dto;

import jakarta.annotation.Nullable;
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

    public UserDTO(DBUser user){
        this.firstName = user.getFirstName();
        this.surname = user.getSurname();
        this.weight = user.getWeight();
        this.height = user.getHeight();
        this.age = user.getAge();
    }
}
