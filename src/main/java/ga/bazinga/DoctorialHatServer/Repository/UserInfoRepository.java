package ga.bazinga.DoctorialHatServer.Repository;

import ga.bazinga.DoctorialHatServer.Entity.UserInfo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "userinfo", path = "userinfo")
public interface UserInfoRepository extends MongoRepository<UserInfo,String> {

}
