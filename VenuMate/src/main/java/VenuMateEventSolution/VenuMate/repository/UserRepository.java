package VenuMateEventSolution.VenuMate.repository;
import VenuMateEventSolution.VenuMate.model.Users;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@Repository
public class UserRepository {

    private final JdbcClient jdbcClient;

    @Autowired
    public UserRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public Users findByUsernameAndPassword(String username, String password) {
        String sql = "SELECT * FROM users WHERE username = ? AND pwd = ?";

        return jdbcClient.sql(sql)
                .params(List.of(username, password))
                .query((rs, rowNum) -> {
                    Users user = new Users();
                    user.setUsername(rs.getString("username"));
                    user.setPwd(rs.getString("pwd"));
                    user.setRole(rs.getString("role"));
                    return user;
                })
                .optional()
                .orElse(null);
    }
}
