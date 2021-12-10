
package ws.synopsis.training.bean.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class LoginRequest implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String phone;
    private String word;
    
}
