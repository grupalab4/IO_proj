package pl.io_proj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.io_proj.model.DBUser;
import pl.io_proj.service.DBUserService;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface DBUserRepository extends JpaRepository<DBUser, Long> {
    DBUser getDBUserByUsername(String username);
    boolean existsDBUserByUsername(String username);
}
