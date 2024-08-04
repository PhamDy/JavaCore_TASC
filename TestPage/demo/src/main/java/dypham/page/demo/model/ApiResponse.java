package dypham.page.demo.model;

import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.springframework.http.HttpStatus;

import java.util.Map;

@Data
@SuperBuilder
public class ApiResponse {
    private String timeStamp;
    private int statusCode;
    private HttpStatus status;
    private String message;
    private Map<?,?> data;
}
