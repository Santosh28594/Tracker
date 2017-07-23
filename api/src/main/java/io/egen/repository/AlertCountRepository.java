package io.egen.repository;

import io.egen.entity.AlertCount;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public interface AlertCountRepository {

    List<AlertCount> getAlertCount();
    void setJdbcTemplate(JdbcTemplate jdbcTemplate) ;
}
