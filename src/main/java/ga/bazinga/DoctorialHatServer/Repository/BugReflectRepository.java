package ga.bazinga.DoctorialHatServer.Repository;

import ga.bazinga.DoctorialHatServer.Entity.BugReflect;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BugReflectRepository extends MongoRepository<BugReflect,String> {

}
