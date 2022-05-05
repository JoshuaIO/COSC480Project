package apex.example.demo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface UsersRepository extends CrudRepository <Users, Integer>{

    @Query(
            value = "SELECT * FROM USERS u WHERE u.username = ?1 AND u.password = ?2",
            nativeQuery = true)
    Collection<Users> findAllUsersWithPassword(String username, String password);

}
