package ws.synopsis.training.rest.dao.impl;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import ws.synopsis.training.rest.bean.dao.UserDao;
import ws.synopsis.training.rest.bean.request.LoginRequest;
import ws.synopsis.training.rest.dao.ValidateAccessDAO;
import ws.synopsis.training.rest.dao.sp.impl.SPValidateAccess;
import ws.synopsis.training.rest.enumeration.StatusEnum;
import ws.synopsis.training.rest.exception.TrainingLogicException;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Repository
@AllArgsConstructor
public class ValidateAccessDAOImpl implements ValidateAccessDAO {

	private SPValidateAccess spValidateAccess;

	@SuppressWarnings("unchecked")
	@Override
	public UserDao validateAccess(LoginRequest register) throws SQLException, TrainingLogicException {

		SqlParameterSource in = new MapSqlParameterSource()
				.addValue(SPValidateAccess.IN_PHONE, register.getPhone())
				.addValue(SPValidateAccess.IN_PASSWORD, register.getWord());

		Map<String, Object> result = spValidateAccess.execute(in);
		List<UserDao> list = (List<UserDao>) result.get(SPValidateAccess.OUT_CURSOR);

		if (list.isEmpty()) {
			throw new TrainingLogicException(StatusEnum.LOGIN_ERROR);
		} else {
			return list.get(0);
		}
		//@formatter:on

	}

}
