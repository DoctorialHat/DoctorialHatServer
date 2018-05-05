package ga.bazinga.DoctorialHatServer.Entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class UserInfo {

    @Id
    private String id;
    private User user;
    private String description;//个性签名
    private String nickName;//用户的昵称
    private int rank;//答题的排名
    private double winRating;//答题的正确率
    private int questionNum;//总答题数
}
