
package ws.synopsis.training.rest.service;

import ws.synopsis.training.rest.bean.request.LoginRequest;
import ws.synopsis.training.rest.bean.response.ClientResponse;
import ws.synopsis.training.rest.bean.response.base.GenResponse;
import ws.synopsis.training.rest.exception.TrainingLogicException;

import java.sql.SQLException;

public interface LoginService {

	public GenResponse<ClientResponse> login(LoginRequest login) throws TrainingLogicException, SQLException;
	
}
