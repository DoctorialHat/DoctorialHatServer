package ga.bazinga.DoctorialHatServer.Repository;

import ga.bazinga.DoctorialHatServer.Entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User,String> {
    User findByPhoneAndPassword(@Param("phone") String phone, @Param("password") String password);
}
