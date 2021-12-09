package ws.synopsis.training.rest.bean.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ws.synopsis.training.rest.bean.dao.UserDao;
import ws.synopsis.training.rest.model.Client;

import javax.persistence.Column;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientResponse {

    private Long idClient;
    private String name;
    private String lastName;
    private Integer telephone;
    private String uuid;

    public ClientResponse(Client source) {
        this.setIdClient(source.getIdClient());
        this.setName(source.getName());
        this.setLastName(source.getLastName());
        this.setTelephone(source.getPhone());
        this.setUuid(UUID.randomUUID().toString());
    }

    public ClientResponse(UserDao source) {
        this.setIdClient(source.getIdClient());
        this.setName(source.getName());
        this.setLastName(source.getLastName());
        this.setTelephone(source.getPhone());
        this.setUuid(UUID.randomUUID().toString());
    }

}
