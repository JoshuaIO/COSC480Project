package apex.example.demo;
import apex.example.demo.Users;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository <Users, Integer>{
}
