package ga.bazinga.DoctorialHatServer.Repository;

import ga.bazinga.DoctorialHatServer.Entity.UserInfo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoRepository extends MongoRepository<UserInfo,String> {

}
