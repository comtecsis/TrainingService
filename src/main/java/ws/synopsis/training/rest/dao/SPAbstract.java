package ws.synopsis.training.rest.dao;

import java.util.Map;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

public abstract class SPAbstract {

    private SimpleJdbcCall simpleJdbcCall;

    public SPAbstract(JdbcTemplate jdbcTemplate, String name) {
        setSimpleJdbcCall(new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName(name)
                .withoutProcedureColumnMetaDataAccess());
    }

    //este excecute usa al simplejdccall de la calse padre CPStoredProcedure
    @Transactional
    public Map<String, Object> execute(SqlParameterSource parameters) {
        getSimpleJdbcCall().getJdbcTemplate().execute("SET CHAINED OFF");
        return getSimpleJdbcCall().execute(parameters);
    }

    @PostConstruct
    public abstract void configSP();

    private SimpleJdbcCall getSimpleJdbcCall() {
        return simpleJdbcCall;
    }

    private void setSimpleJdbcCall(SimpleJdbcCall simpleJdbcCall) {
        this.simpleJdbcCall = simpleJdbcCall;
    }
}
