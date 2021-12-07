package ws.synopsis.training.rest.bean.request;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class ClientRequest {
    private String name;
    private String lastName;
    private Integer phone;
    private String word;
}
