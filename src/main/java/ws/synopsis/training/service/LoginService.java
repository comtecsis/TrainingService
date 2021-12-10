
package ws.synopsis.training.service;

import ws.synopsis.training.bean.request.LoginRequest;
import ws.synopsis.training.bean.response.ClientResponse;
import ws.synopsis.training.bean.response.base.GenResponse;
import ws.synopsis.training.exception.TrainingLogicException;

import java.sql.SQLException;

public interface LoginService {

	public GenResponse<ClientResponse> login(LoginRequest login) throws TrainingLogicException, SQLException;
	
}
