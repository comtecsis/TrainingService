package ws.synopsis.training.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ws.synopsis.training.bean.dao.UserDao;
import ws.synopsis.training.bean.request.LoginRequest;
import ws.synopsis.training.bean.response.ClientResponse;
import ws.synopsis.training.bean.response.base.GenResponse;
import ws.synopsis.training.dao.ValidateAccessDAO;
import ws.synopsis.training.exception.TrainingLogicException;
import ws.synopsis.training.service.LoginService;

import java.sql.SQLException;

@Service
@AllArgsConstructor
public class LoginServiceImpl implements LoginService {

    private ValidateAccessDAO accessDAO;

    @Override
    public GenResponse<ClientResponse> login(LoginRequest login) throws TrainingLogicException, SQLException {
        UserDao userDao = accessDAO.validateAccess(login);
        return GenResponse.<ClientResponse>builder().data(new ClientResponse(userDao)).build();
    }
}