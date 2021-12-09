package ws.synopsis.training.rest.dao;

import ws.synopsis.training.rest.bean.dao.UserDao;
import ws.synopsis.training.rest.bean.request.LoginRequest;
import ws.synopsis.training.rest.exception.TrainingLogicException;

import java.sql.SQLException;

public interface ValidateAccessDAO {

	UserDao validateAccess(LoginRequest register) throws SQLException, TrainingLogicException;

}
