package ga.bazinga.DoctorialHatServer.Entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;

@Data
public class User {

    @Id
    private String id;

    @Indexed(unique = true, direction = IndexDirection.DESCENDING, dropDups = true)
    private String phone;

    private String password;

    private String description;//个性签名
    private String nickName;//用户的昵称
    private int rank;//答题的排名
    private double winRating;//答题的正确率
    private int questionNum;//总答题数
}
