package VenuMateEventSolution.VenuMate.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EventJdbcRepository {

    @Autowired
    private JdbcClient jdbcClient;

    public List<Integer> findAllIds() {
        return jdbcClient.sql("SELECT id FROM venueslist")
                .query(Integer.class)
                .list();
    }

}


