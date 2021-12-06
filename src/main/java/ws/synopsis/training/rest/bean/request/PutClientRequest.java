package ws.synopsis.training.rest.bean.request;

import lombok.Data;

@Data
public class PutClientRequest {
    private Long    id;
    private String  name;
    private String  lastName;
    private Integer phone;
}
