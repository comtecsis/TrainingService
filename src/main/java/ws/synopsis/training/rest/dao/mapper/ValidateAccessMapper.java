package ws.synopsis.training.rest.dao.mapper;


import org.springframework.jdbc.core.RowMapper;
import ws.synopsis.training.rest.bean.dao.UserDao;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ValidateAccessMapper implements RowMapper<UserDao> {

	private static final String COL_USERID = "client_id";
	private static final String COL_NAME = "client_name";
	private static final String COL_LASTNAME = "client_last_name";
	private static final String COL_PHONE = "client_phone";

	@Override
	public UserDao mapRow(ResultSet rs, int rowNum) throws SQLException {
		//@formatter:off
		UserDao loadRole = UserDao.builder()
			.idClient(rs.getLong(COL_USERID))
			.name(rs.getString(COL_NAME))
			.lastName(rs.getString(COL_LASTNAME))
			.phone(rs.getInt(COL_PHONE))
			.build()
			;
		//@formatter:on
		return loadRole;
	}

}
