package ws.synopsis.training.rest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    private Long idClient;
    private String name;
    private String lastName;
    private String phoneNumber;
}
