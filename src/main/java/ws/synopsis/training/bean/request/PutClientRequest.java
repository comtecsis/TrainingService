package ws.synopsis.training.bean.request;

import lombok.Data;

@Data
public class PutClientRequest {
    private Long    id;
    private String  name;
    private String  lastName;
    private Integer phone;
    private String word;
}