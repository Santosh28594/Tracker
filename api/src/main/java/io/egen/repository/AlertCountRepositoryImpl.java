package io.egen.repository;
import io.egen.entity.AlertCount;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;



public class AlertCountRepositoryImpl  implements AlertCountRepository {

//    @PersistenceContext
//    private EntityManager entityManager;


    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<AlertCount> getAlertCount() {
        return jdbcTemplate.query("SELECT v.vin, count(*) as count FROM veh_db.alert as a, veh_db.vehicle as v, veh_db.reading as r where a.readid=r.readid and v.vin=r.vin and a.priority='HIGH' and a.datetime>=SUBDATE( CURRENT_TIMESTAMP , INTERVAL 2 HOUR) group by v.vin", new RowMapper<AlertCount>() {

            public AlertCount mapRow(ResultSet resultSet, int rownumber) throws SQLException {
                AlertCount alert = new AlertCount();
                alert.setVin(resultSet.getString(1));
                alert.setCount(resultSet.getInt(2));
                return alert;
            }
        });


    }
}