package pl.io_proj.responses;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RegisterResponse {
    public String getMessage() {
        return message;
    }

    public String getType() {
        return type;
    }

    private String message;
    private String type = "RegisterResponse";
    public static RegisterResponse Ok = new RegisterResponse("created new user successfully!");
    public static RegisterResponse UserAlreadyExists = new RegisterResponse("username already exists!");
    public static RegisterResponse NotEnoughParameters = new RegisterResponse("not enough parameters!");

    public RegisterResponse(String message) {
        this.message = message;
    }

    public String json() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(this);
    }
}
