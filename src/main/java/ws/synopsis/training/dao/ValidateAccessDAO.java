package ws.synopsis.training.dao;

import ws.synopsis.training.bean.dao.UserDao;
import ws.synopsis.training.bean.request.LoginRequest;
import ws.synopsis.training.exception.TrainingLogicException;

import java.sql.SQLException;

public interface ValidateAccessDAO {

	UserDao validateAccess(LoginRequest register) throws SQLException, TrainingLogicException;

}
