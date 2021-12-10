package ws.synopsis.training.dao.sp.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.stereotype.Component;
import ws.synopsis.training.dao.mapper.ValidateAccessMapper;
import ws.synopsis.training.dao.sp.SPAbstract;

import java.sql.Types;

@Component
public class SPValidateAccess extends SPAbstract {

	private static final String SP_NAME = "SPValidateAccess";
	public static final String IN_PHONE = "phone";
	public static final String IN_PASSWORD = "password";
	public static final String OUT_CURSOR = "@salCursor";

	@Autowired
	public SPValidateAccess(JdbcTemplate jdbcTemplate) {
		super(jdbcTemplate, SP_NAME);
	}

	@Override
	public void configSP() {
		//@formatter:off
		getSimpleJdbcCall()
			.useInParameterNames(
				IN_PHONE,
				IN_PASSWORD
			)
			.declareParameters(
				new SqlParameter(IN_PHONE, Types.VARCHAR),
				new SqlParameter(IN_PASSWORD, Types.VARCHAR)
			)
			.returningResultSet(OUT_CURSOR, new ValidateAccessMapper());
		//@formatter:on
	}
}
