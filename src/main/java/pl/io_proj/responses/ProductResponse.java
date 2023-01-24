package pl.io_proj.responses;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ProductResponse {
    public String getMessage() {
        return message;
    }

    public String getType() {
        return type;
    }

    private String message;
    private String type = "ProductResponse";
    public static ProductResponse Ok = new ProductResponse("added new product successfully!");
    public static ProductResponse ProductAlreadyExists = new ProductResponse("product already exists!");
    public static ProductResponse NotEnoughParameters = new ProductResponse("not enough parameters!");

    public ProductResponse(String message) {
        this.message = message;
    }

    public String json() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(this);
    }
}
