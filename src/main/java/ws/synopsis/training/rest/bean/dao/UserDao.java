
package ws.synopsis.training.rest.bean.dao;

import lombok.Builder;
import lombok.Data;
import ws.synopsis.training.rest.utils.Constants;

import java.io.Serializable;

@Data
@Builder
public class UserDao implements Serializable
{

    private static final long serialVersionUID = Constants.SERIALIZATION_VERSION;

    private Long idClient;
    private String name;
    private String lastName;
    private Integer phone;

}
